$(function () {
    $("#jqGrid").jqGrid({
        url: '../ylfwyyghorder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '', name: 'doctorid', index: 'doctorid', width: 80 }, 			
			{ label: '预约电话', name: 'invitemobile', index: 'invitemobile', width: 80 }, 			
			{ label: '预约计划id', name: 'scheduleid', index: 'scheduleid', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '订单状态改变 1: 改变，2： 未改变', name: 'changes', index: 'changes', width: 80 }, 			
			{ label: '订单状态 1:已预约 ，2： 服务中（用户到店，医生点击），3：已完成（包含待评价和已评价），4：待评价，5：已取消', name: 'status', index: 'status', width: 80 }, 			
			{ label: '订单号', name: 'ordercode', index: 'ordercode', width: 80 }, 			
			{ label: '支付时间', name: 'paytime', index: 'paytime', width: 80 }, 			
			{ label: '支付金额', name: 'money', index: 'money', width: 80 }			
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
		ylfwYyghOrder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ylfwYyghOrder = {};
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
			var url = vm.ylfwYyghOrder.id == null ? "../ylfwyyghorder/save" : "../ylfwyyghorder/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.ylfwYyghOrder),
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
				    url: "../ylfwyyghorder/delete",
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
			$.get("../ylfwyyghorder/info/"+id, function(r){
                vm.ylfwYyghOrder = r.ylfwYyghOrder;
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