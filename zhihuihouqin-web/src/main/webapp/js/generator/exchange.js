$(function () {
    $("#jqGrid").jqGrid({
        url: '../exchange/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '地址', name: 'addressId', index: 'address_id', width: 80, formatter:function(value, options, row){
				var data;
				$.ajax({url:"../vendor/list",
						async:false,
						success:function(result){
					var vendorid=result.page.list;
					for(i=0;i<vendorid.length;i++){
						if(vendorid[i].id == row.vendorId){
							data= vendorid[i].address;
						}
						// $("#vendorId").append("<option
						// value='"+vendorid[i].id+"'
						// id='"+vendorid[i].address+"'>"+vendorid[i].no+"</option>");
					}
				}});
				return data;
			} }, 			
			{ label: '柜机号', name: 'vendorId', index: 'vendor_id', width: 80 }, 			
			{ label: '格子', name: 'gridId', index: 'grid_id', width: 80 }, 			
			{ label: '任务号', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '任务状态', name: 'status', index: 'status', width: 80 , formatter:function(value, options, row){
				return value === 0 ? 
						'<span class="label label-danger">未完成</span>' : 
						'<span class="label label-success">已完成</span>';
			} }, 			
			{ label: '替换商品ID', name: 'productId', index: 'product_id', width: 80 }, 			
			{ label: '被替换商品ID', name: 'productReplaceId', index: 'product_replace_id', width: 80 }, 			
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
        	// 隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});
function setAddress(){
	$("#vendorAddress").prop("value",$("#vendorId option:selected").prop("id"));
}

Vue.use(VueBaiduMap,{
	ak:"40bcbd6c7361485243a9c1e30d60d6cc"
})

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			vendorId: null
		},
		center: {lng: 0, lat: 0},
		showList: true,
		title: null,
		exchange: {}
	},
	methods: {
		
		 handler ({BMap, map}) {
		      console.log(BMap, map)
		      this.lng = 116.404
		      this.lat = 39.915
		},
		
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.queryVendorId();
			vm.queryProductId();
			vm.exchange = {};
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
			var url = vm.exchange.id == null ? "../exchange/save" : "../exchange/update";
			if(!vm.exchange.vendorId){
				vm.exchange["vendorId"]=$("#vendorId").val();
			}
			if(!vm.exchange.status){
				vm.exchange["status"]="0";
			}
			if(!vm.exchange.productId){
				vm.exchange["productId"]=$("#productId").val();
			}
			if(!vm.exchange.productReplaceId){
				vm.exchange["productReplaceId"]=$("#productReplaceId").val();
			}
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.exchange),
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
				    url: "../exchange/delete",
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
			$.get("../exchange/info/"+id, function(r){
				$("#productId").hide();
				$("#addressId").hide();
				$("#vendoeId").hide();
				$("#gridId").hide();
				$("#productIds").hide();
				$("#productReplaceIds").hide();
                vm.exchange = r.exchange;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'vendorId': vm.q.vendorId},
                page:page
            }).trigger("reloadGrid");
		},
		queryVendorId:function(){
			$("#productId").show();
			$("#addressId").show();
			$("#vendoeId").show();
			$("#gridId").show();
			$("#productIds").show();
			$("#productReplaceIds").show();
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
		queryProductId:function(){
			$.get("../producttype/list",function(result){
				var prodectsid=result.page.list;
				$("#productId").empty();
				$("#productReplaceId").empty();
				for(i=0;i<prodectsid.length;i++){
					$("#productId").append("<option value='"+prodectsid[i].id+"'>"+prodectsid[i].name+"</option>");
					$("#productReplaceId").append("<option value='"+prodectsid[i].id+"'>"+prodectsid[i].name+"</option>");
					}
			});
		}
	}
});