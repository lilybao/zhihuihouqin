$(function () {
    $("#jqGrid").jqGrid({
        url: '../managermsg/list',
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
			{ label: '类型', name: 'type', index: 'type', width: 80, formatter:function(value, options, row){
				if(value==1){
					return "系统消息";
				}else if(value==2){
					return "商品消息";
				}else{
					return "任务消息"
				}
			}}, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '客户端类型', name: 'client', index: 'client', width: 80  ,formatter:function(value, options, row){
				if(value==1){
					return "APP";
				}else{
					return "PC";
				}
			}}, 			
			{ label: '消息', name: 'handleType', index: 'handle_type', width: 80, formatter:function(value, options, row){
				if(value==1){
					return "补货消息";
				}else if(value==2){
					return "换货消息";
				}else if(value==3){
					return "消毒消息";
				}else{
					return "其他消息";
				}
			} }			
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
			uid: null
		},
		showList: true,
		title: null,
		managerMsg: {}
	},
	methods: {
		query: function () {
			
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.queryUser();
			vm.managerMsg = {};
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
			var url = vm.managerMsg.id == null ? "../managermsg/save" : "../managermsg/update";
			if(!vm.managerMsg.status){
				vm.managerMsg["status"]="0";
			}
			if(!vm.managerMsg.type){
				vm.managerMsg["type"]="1";
			}
			if(!vm.managerMsg.handleType){
				vm.managerMsg["handleType"]="1";
			}
			if(!vm.managerMsg.client){
				vm.managerMsg["client"]="0";
			}
			if(!vm.managerMsg.uid){
				vm.managerMsg["uid"]=$("#uid").val();
			}
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.managerMsg),
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
				    url: "../managermsg/delete",
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
			$.get("../managermsg/info/"+id, function(r){
                vm.managerMsg = r.managerMsg;
            });
		},
		queryUser:function(){
			$.get("../managers/lists",function(result){
				var vendorid=result.page.list;
				$("#uid").empty();
				for(i=0;i<vendorid.length;i++){
						$("#uid").append("<option value='"+vendorid[i].id+"'>"+vendorid[i].nickname+"</option>");
					}
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