$(function () {
    $("#jqGrid").jqGrid({
        url: '../version/list',
        datatype: "json",
        colModel: [			
			{ label: '版本id', name: 'versionId', index: 'version_id', width: 50, key: true },
			{ label: '版本号', name: 'versionCode', index: 'version_code', width: 80 }, 			
			{ label: '版本名', name: 'versionName', index: 'version_name', width: 80 }, 			
			{ label: '系统', name: 'type', index: 'type', width: 80,formatter:function(value, options, row){
				if (value==0) {
					return 'Android'
				}
				if (value==1) {
					return 'iOS'
				}
				
			} }, 			
			{ label: '包地址', name: 'url', index: 'url', width: 80 }, 			
			{ label: '是否强制更新', name: 'isForceUpdate', index: 'is_force_update', width: 80,formatter:function(value, options, row){
				if (value==0) {
					return '否'
				}
				if (value==1) {
					return '是'
				}
			}}, 
			{ label: '更新内容', name: 'content', index: 'content', width: 80 },	
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    
    new AjaxUpload('#upload', {
        action: '../sys/oss/upload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
        	alert("1111")
      /*      if(vm.config.type == null){
                alert("云存储配置未配置");
                return false;
            }*/
            if (!(extension && /^(apk)$/.test(extension.toLowerCase()))){
                alert('只支持apk格式的附件！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.errCode == 0){
                alert(r.url);
                vm.version.url=r.url;
                $("#upload").next().remove();
                $("#upload").parent().append('<span>'+r.url+'</span>');
                $("#upload").hide
            }else{
                alert(r.msg);
            }
        }
    });
    
    
    
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		version: {},
		showIosUrlInput:false,
		typeSelected:0,
		forceSelected:0
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.version = {};
		},
		update: function (event) {
			var versionId = getSelectedRow();
			if(versionId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(versionId)
		},
		saveOrUpdate: function (event) {
			var url = vm.version.versionId == null ? "../version/save" : "../version/update";
			vm.version.type=this.typeSelected;
			
			vm.version.isForceUpdate=this.forceSelected;
			if (this.typeSelected==0) {
				vm.version.url=$("#upload").next().text()
			}
			
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.version),
			    success: function(r){
			    	if(r.errCode === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var versionIds = getSelectedRows();
			if(versionIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../version/delete",
				    data: JSON.stringify(versionIds),
				    success: function(r){
						if(r.errCode == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(versionId){
			$.get("../version/info/"+versionId, function(r){
                vm.version = r.version;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
		change:function(){
			
			alert(this.typeSelected)
			alert(this.showIosUrlInput)
			
				this.showIosUrlInput=!this.showIosUrlInput;
		}
	}
});