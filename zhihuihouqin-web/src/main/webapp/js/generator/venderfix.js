$(function () {
    $("#jqGrid").jqGrid({
        url: '../venderfix/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '地址', name: 'address', index: 'address_id', width: 80}, 			
			{ label: '柜机号', name: 'vendorId', index: 'vendor_id', width: 80 }, 			
			{ label: '格子', name: 'gridId', index: 'grid_id', width: 80 }, 			
			{ label: '报修原因', name: 'reasonId', index: 'reason_id', width: 80 }, 			
			{ label: '报修说明', name: 'descriptions', index: 'descriptions', width: 80 }, 			
			{ label: '任务号', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '任务状态', name: 'status', index: 'status', width: 80 , formatter:function(value, options, row){
				return value === 0 ? 
						'<span class="label label-danger">未完成</span>' : 
						'<span class="label label-success">已完成</span>';
			} }, 			
			{ label: '报修来源', name: 'userId', index: 'user_id', width: 80 }			
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
function setAddress(){
	$("#vendorAddress").prop("value",$("#vendorId option:selected").prop("id"));
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			vendorId: null
		},
		showList: true,
		title: null,
		venderFix: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.queryVendorId();
			vm.venderFix = {};
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
			var url = vm.venderFix.id == null ? "../venderfix/save" : "../venderfix/update";
			if(!vm.venderFix.vendorId){
				vm.venderFix["vendorId"]=$("#vendorId").val();
			}
			if(!vm.venderFix.status){
				vm.venderFix["status"]="0";
			}
			
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.venderFix),
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
				    url: "../venderfix/delete",
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
			$.get("../venderfix/info/"+id, function(r){
				$("#reasonid").hide();
				$("#addressid").hide();
				$("#vendorid").hide();
				$("#gridid").hide();
				$("#descriptions").hide();
				$("#ordernum").hide();
				$("#userid").hide();
                vm.venderFix = r.venderFix;
            });
		},
		queryVendorId:function(){
			$("#reasonid").show();
			$("#addressid").show();
			$("#vendorid").show();
			$("#gridid").show();
			$("#descriptions").show();
			$("#ordernum").show();
			$("#userid").show();
			$.get("../vendor/list",function(result){
				var vendorid=result.page.list;
				$("#vendorId").empty();
				for(i=0;i<vendorid.length;i++){
						$("#vendorId").append("<option value='"+vendorid[i].id+"' id='"+vendorid[i].address+"'>"+vendorid[i].no+"</option>");
					}
				window.setTimeout(function (){
					$("#vendorAddress").prop("value",$("#vendorId option:selected").prop("id"));
				},1000);
			});
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'vendorId': vm.q.vendorId},
                page:page
            }).trigger("reloadGrid");
		}
	}
});