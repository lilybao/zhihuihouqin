$(function () {
    $("#jqGrid").jqGrid({
        url: '../tbxwxmender/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '真实姓名', name: 'realname', index: 'realname', width: 80 }, 			
			{ label: '部门编号', name: 'departid', index: 'departid', width: 80 }, 			
			{ label: '状态 1: 有效，0： 无效', name: 'valid', index: 'valid', width: 80 }, 			
			{ label: '电话', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '登录编号', name: 'loginid', index: 'loginid', width: 80 }, 			
			{ label: '分数', name: 'score', index: 'score', width: 80 }, 			
			{ label: '接单量', name: 'count', index: 'count', width: 80 }, 			
			{ label: '头像', name: 'photo', index: 'photo', width: 80 }			
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
		showList: true,
		title: null,
		tBxwxMender: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tBxwxMender = {};
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
			var url = vm.tBxwxMender.id == null ? "../tbxwxmender/save" : "../tbxwxmender/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tBxwxMender),
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
				    url: "../tbxwxmender/delete",
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
			$.get("../tbxwxmender/info/"+id, function(r){
                vm.tBxwxMender = r.tBxwxMender;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});