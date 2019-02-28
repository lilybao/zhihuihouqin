$(function () {
    $("#jqGrid").jqGrid({
        url: '../productorder/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '订单号', name: 'orderNo', index: 'order_no', width: 150 }, 			
			{ label: '商品ID', name: 'productId', index: 'product_id', width: 50 }, 			
			{ label: '商品类型ID', name: 'ptid', width: 50,sortable: false }, 			
			{ label: '商品名', name: 'ptname', width: 70,sortable: false }, 			
			{ label: '用户', name: 'uid', index: 'uid', width: 50 }, 			
			{ label: '添加时间', name: 'createTime', index: 'create_time', width: 120 }, 					
			{ label: '取货时间', name: 'takeTime', index: 'take_time', width: 100 }, 			
			{ label: '还货时间', name: 'returnTime', index: 'return_time', width: 100 }, 			
			{ label: '订单状态', name: 'orderStatus', index: 'order_status', width: 80,formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '<span class="label label-default">已失效</span>';
					break;
				case 1:
					str = '<span class="label label-warning">待取货</span>';
					break;
				case 2:
					str = '<span class="label label-info">已取货</span>';
					break;
				case 3:
					str = '<span class="label label-warning">已预约退货</span>';
					break;
				case 4:
					str = '<span class="label label-info">已退货</span>';
					break;
				case 5:
					str = '<span class="label label-success">已完成</span>';
					break;
				case 6:
					str = '<span class="label label-danger">超时</span>';
					break;
				case 7:
					str = '<span class="label label-danger">异常</span>';
					break;
				case 8:
					str = '<span class="label label-success">已评价</span>';
					break;
				default:
					break;
				}
				return str;
			}}, 			
			{ label: '支付状态', name: 'payStatus', index: 'pay_status', width: 80,formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '<span class="label label-warning">未支付</span>';
					break;
				case 1:
					str = '<span class="label label-success">已支付</span>';
					break;
				default:
					break;
				}
				return str;
			} },
			{ label: '是否关门', name: 'closed', index: 'closed', width: 80,formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '<span class="label label-danger">开门状态</span>';
					break;
				case 1:
					str = '<span class="label label-success">已经关门</span>';
					break;
				default:
					break;
				}
				return str;
			} },
			{ label: '总金额', name: 'totalPay', index: 'total_pay', width: 80,formatter: function(value, options, row){
				var str = '￥'+value+'元';
				return str;
			} }, 			
			{ label: '柜子号', name: 'vendorNo', index: 'vendor_id', width: 120 }, 	
			{ label: '格子号', name: 'gridNo', index: 'grid_id', width: 60 }, 			
			{ label: '取货地点', name: 'address', index: 'address', width: 100 ,sortable: false}, 			
			{ label: '还货柜子', name: 'returnVendorNo', index: 'return_place_vendor_id', width: 120 }, 			
			{ label: '还货格子', name: 'returnGridNo', index: 'return_grid_id', width: 120 }, 		
			{ label: '还货地点', name: 'returnPlace', index: 'return_place', width: 120,sortable: false }, 			
			{ label: '订单来源', name: 'sources', index: 'sources', width: 120 ,formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '微信';
					break;
				case 1:
					str = 'app';
					break;
				default:
					break;
				}
				return str;
			}}, 			
			{ label: '支付类型', name: 'payType', index: 'pay_type', width: 120 ,formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '微信支付';
					break;
				case 1:
					str = '钱包支付';
					break;
				case 2:
					str = '押金支付';
					break;
				default:
					break;
				}
				return str;
			}}, 			
			{ label: '用户优惠id', name: 'ucId', index: 'uc_id', width: 120,sortable: false },	
			{ label: '优惠总金额', name: 'cpmTotal', index: 'cpm_total', width: 120 },
			{ label: '总租期', name: 'totalDays', index: 'total_days', width: 120 },  			
			{ label: '续租增加的天数', name: 'addRentDays', index: 'add_rent_days', width: 120,sortable: false }, 			
			{ label: '续租增加的总金额', name: 'addRentTotalPay', index: 'add_rent_total_pay', width: 120,sortable: false }, 			
			{ label: '支付订单号', name: 'payNo', index: 'pay_no', width: 120,sortable: false }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 100, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        shrinkToFit:false,
        autoScroll: false,
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
        	 
        }
    });
    
    $.get("../vendor/getVendorList", function(r){
		console.log($)
		vm.vendorList = r.vendorList;
	});
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			productId:null,
			ptid:null,
			userId:null,
			oid:null,
			status:"",
			createTimeStart:null,
			createTimeEnd:null,
			vendorId:"",
			returnVendorId:"",
			payStatus:""
		},
		vendorList:{},
		showList: true,
		title: null,
		productOrder: {}
	},
	methods: {
		change:function (){
			alert(1);
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.productOrder = {};
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
			var url = vm.productOrder.id == null ? "../productorder/save" : "../productorder/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.productOrder),
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
				    url: "../productorder/delete",
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
			$.get("../productorder/info/"+id, function(r){
                vm.productOrder = r.productOrder;
            });
		},
		reload: function (event) {
			vm.showList = true;
			vm.q.createTimeStart = $("#dtp_input1").val();
			vm.q.createTimeEnd = $("#dtp_input2").val();
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
				postData:{
					'productId':vm.q.productId,
					'ptid':vm.q.ptid,
					'userId':vm.q.userId,
					'oid':vm.q.oid,
					'status':vm.q.status,
					'createTimeStart':vm.q.createTimeStart,
					'createTimeEnd':vm.q.createTimeEnd,
					'vendorId':vm.q.vendorId,
					'returnVendorId':vm.q.returnVendorId,
					'payStatus':vm.q.payStatus
					},
                page:page
            }).trigger("reloadGrid");
		}
	}
});