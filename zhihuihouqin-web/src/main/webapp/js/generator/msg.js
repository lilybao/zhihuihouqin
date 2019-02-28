$(function () {
    $("#jqGrid").jqGrid({
        url: '../msg/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户ID', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 , formatter:function(value, options, row){
				if(value==0){
					return "未读";
				}else if(value==1){
					return "已读";
				}
			}}, 			
			{ label: '内容', name: 'context', index: 'context', width: 80 }, 			
			{ label: '标题', name: 'title', index: 'title', width: 80 }, 			
			{ label: '类型', name: 'type', index: 'type', width: 80 , formatter:function(value, options, row){
				if(value==0){
					return "活动";
				}else if(value==1){
					return "系统";
				}else if(value==2){
					return "个人";
				}else{
					return "其他";
				}
			}}, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '客户端类型', name: 'client', index: 'client', width: 80 ,formatter:function(value, options, row){
				if(value==1){
					return "APP";
				}else{
					return "PC";
				}
			}}			
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
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			vendorId: null
		},
		showList: true,
		title: null,
		msg: {}
	},
	methods: {
		query: function () {
			
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.msg = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			if(!vm.msg.status){
				vm.msg["status"]="0";
			}
			if(!vm.msg.type){
				vm.msg["type"]="0";
			}
			if(!vm.msg.client){
				vm.msg["client"]="0";
			}
			var url = vm.msg.id == null ? "../msg/save" : "../msg/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.msg),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../msg/delete",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get("../msg/info/"+id, function(r){
                vm.msg = r.msg;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'uid': vm.q.uid},
                page:page
            }).trigger("reloadGrid");
		}
	}
});