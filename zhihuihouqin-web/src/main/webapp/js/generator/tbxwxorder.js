$(function () {
    $("#jqGrid").jqGrid({
        url: '../tbxwxorder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '维修项目id', name: 'menditem', index: 'menditem', width: 80 }, 			
			{ label: '姓名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '预约时间', name: 'invitetime', index: 'invitetime', width: 80 }, 			
			{ label: '服务地点', name: 'serviceplace', index: 'serviceplace', width: 80 }, 			
			{ label: '维修人员id', name: 'menderid', index: 'menderid', width: 80 }, 			
			{ label: '详情信息', name: 'mendcontent', index: 'mendcontent', width: 80 }, 			
			{ label: '维修图片信息(多逗号分割)', name: 'mendimgs', index: 'mendimgs', width: 80 }, 			
			{ label: '价格', name: 'price', index: 'price', width: 80 }, 			
			{ label: '1:待接单，2： 已接单，3：已完成，4:待评价，5：已取消 ', name: 'orderstatus', index: 'orderstatus', width: 80 }, 			
			{ label: '', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '下单时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '预约时间类型 1: 立即上门，2： 选择时间上门', name: 'invitetimetype', index: 'invitetimetype', width: 80 }, 			
			{ label: '状态改变', name: 'orderchange', index: 'orderchange', width: 80 }, 			
			{ label: '订单号', name: 'ordercode', index: 'ordercode', width: 80 }, 			
			{ label: '1: 支付，0：没', name: 'paystatus', index: 'paystatus', width: 80 }, 			
			{ label: '是否删除', name: 'isdel', index: 'isdel', width: 80 }			
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
		tBxwxOrder: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tBxwxOrder = {};
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
			var url = vm.tBxwxOrder.id == null ? "../tbxwxorder/save" : "../tbxwxorder/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tBxwxOrder),
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
				    url: "../tbxwxorder/delete",
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
			$.get("../tbxwxorder/info/"+id, function(r){
                vm.tBxwxOrder = r.tBxwxOrder;
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