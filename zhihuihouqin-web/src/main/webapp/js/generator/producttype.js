$(function () {
    $("#jqGrid").jqGrid({
        url: '../producttype/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '标题', name: 'title', index: 'title', width: 80 ,sortable: false}, 			
			{ label: '日租价', name: 'price', index: 'price', width: 80 }, 			
			{ label: '首页缩略图', name: 'avatar', index: 'avatar', width: 120 ,sortable: false, formatter: function(value, options, row){
				var str = '<img alt="" src="'+value+'" style="width:100px;height:100px"/>';
				return str;
			}}, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建账号', name: 'createAccount', index: 'create_account', width: 80 }, 			
			{ label: '最新', name: 'isnew', index: 'isnew', width: 80 }, 			
			{ label: '推荐', name: 'recommend', index: 'recommend', width: 80 },
			{ label: '销量', name: 'sellcount', index: 'sellcount', width: 80 }, 			
			{ label: '库存', name: 'stock', index: 'stock', width: 80 }, 
			{ label: '修改时间', name: 'updatetime', index: 'updatetime', width: 80 ,sortable: false}, 			
			{ label: '商品状态', name: 'status', index: 'status', width: 80 , formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 1:
					str = '<span class="label label-default">原价</span>';
					break;
				case 2:
					str = '<span class="label label-warning">折扣</span>';
					break;
				default:
					break;
				}
				return str;
			}}, 			
			{ label: '一级分类', name: 'cname', index: 'catalog_one', width: 80 }, 			
			{ label: '二级分类', name: 'catalogTwo', index: 'catalog_two', width: 80 }, 						
			{ label: '搜索关键字', name: 'searchKey', index: 'search_key',sortable: false, width: 80 }, 			
			{ label: '是否置顶', name: 'toFirst', index: 'to_first', width: 80 }, 			
			{ label: '品牌', name: 'bname', index: 'brand_id',sortable: false, width: 80 }, 			
			{ label: '最大年龄', name: 'maxAge', index: 'max_age',sortable: false, width: 80 }, 			
			{ label: '最小年龄', name: 'minAge', index: 'min_age',sortable: false, width: 80 }, 			
			{ label: '重量', name: 'weight', index: 'weight',sortable: false, width: 80 }, 			
			{ label: '浮动价格', name: 'fluctuationPrice', index: 'fluctuation_price',sortable: false, width: 80 }, 			
			{ label: '吊牌价', name: 'tagPrice', index: 'tag_price',sortable: false, width: 80 }, 			
			{ label: '尺寸', name: 'size', index: 'size', width: 80,sortable: false }, 			
			{ label: '产地', name: 'productionPlace', index: 'production_place', width: 80,sortable: false }, 			
			{ label: '材质', name: 'material', index: 'material', width: 80,sortable: false }, 			
			{ label: '折扣价', name: 'discountPrice', index: 'discount_price', width: 80,sortable: false }, 			
			{ label: '宝宝性别', name: 'babySexFit', index: 'baby_sex_fit', width: 80,sortable: false , formatter: function(value, options, row){
				var str = '';
				switch (value) {
				case 0:
					str = '<span class="label label-info">男</span>';
					break;
				case 1:
					str = '<span class="label label-danger">女</span>';
					break;
				default:
					break;
				}
				return str;
			}}, 			
			{ label: '折扣', name: 'discount', index: 'discount', width: 80,sortable: false }, 			
			{ label: '折扣开始时间', name: 'discountStart', index: 'discount_start', width: 80,sortable: false }, 			
			{ label: '折扣结束时间', name: 'discountEnd', index: 'discount_end', width: 80,sortable: false }		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        shrinkToFit:false,
        autoScroll: false,
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
        	
        }
    });
    $("#jqGridKc").jqGrid({
        url: '../product/list',
        datatype: "json",
        postData:{"id":vm.ptid},
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '收入累计', name: 'total', index: 'total', width: 80 }, 			
			{ label: '是否完好', name: 'isWell', index: 'is_well', width: 80 }, 			
			{ label: '是否可租', name: 'leasable', index: 'leasable', width: 80 }, 			
			{ label: '是否消毒', name: 'disinfect', index: 'disinfect', width: 80 }, 			
			{ label: '出租累计', name: 'count', index: 'count', width: 80 }, 			
			{ label: '货号', name: 'productNo', index: 'product_no', width: 80 }, 			
			{ label: '商品类型', name: 'productTypeId', index: 'product_type_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '柜子号', name: 'vendorNo', index: 'vendorNo', width: 80 },			
			{ label: '格子号', name: 'gridNo', index: 'gridNo', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        multiselect: true,
        shrinkToFit:false,
        pager: "#jqGridKcPager",
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
    new AjaxUpload('#upload', {
        action: '../sys/oss/upload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.errCode == 0){
//            	alert(r.url);
            	vm.productType.avatar = r.url;
//            	alert(vm.productType.avatar);
            }else{
                alert(r.msg);
            }
        }
    });
    new AjaxUpload('#uploadDPic', {
        action: '../sys/oss/upload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.errCode == 0){
//            	alert(r.url);
            	var productDetailImg = {
                		imgPath: r.url,
                		productId: vm.ptid,
                		sort:null
                	};
            	vm.productDetail.productDetailImgList.push(productDetailImg);
            }else{
                alert(r.msg);
            }
        }
    });
    new AjaxUpload('#uploadRPic', {
        action: '../sys/oss/upload',
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.errCode == 0){
//            	alert(r.url);
            	var productDetailImg = {
            		imgPath: r.url,
            		productId: vm.ptid,
            	};
            	vm.productDetail.productRoolImgList.push(productDetailImg);
            }else{
                alert(r.msg);
            }
        }
    });
    $.get("../cateloglevel/getCategoryOneList", function(r){
		console.log($)
		vm.categoryOneList = r.categoryOneList;
	});
    $.get("../brand/getBrandList", function(r){
    	console.log($)
    	vm.brandList = r.brandList;
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
			ptName:null,
			createUserId:null,
			status:"",
			categoryOne:"",
			categoryTwo:"",
			brand:"",
			createTimeStart:null,
			createTimeEnd:null
		},
		vendorList:{},
		categoryOneList:{},
		brandList:{},
		showListPt: true,
		showListPtGrid: false,
		title: null,
		productType: {},
		ptid:"",
		product: {},
		showListKc: true,
		showListKcGrid: true,
		productDetail:{productId:null,productDetailImgList:[],productRoolImgList:[]},
		showListDetail: true
	},
	methods: {
		kcPage: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.ptid = id;
			vm.showListKcGrid = false;
			vm.showListKc = true;
			vm.showListPt = true;
			vm.showListPtGrid = true;
			vm.reloadKc();
		},
		detail: function () {
			//添加修改详情
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showListPt = true;
			vm.showListPtGrid = true;
			vm.showListDetail = false;
			vm.getInfoDetail(id);
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showListKcGrid = true;
			vm.showListKc = true;
			vm.showListPt = false;
			vm.showListPtGrid = true;
			vm.title = "新增";
			vm.productType = {avatar:null};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showListKcGrid = true;
			vm.showListKc = true;
			vm.showListPt = false;
			vm.showListPtGrid = true;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.productType.id == null ? "../producttype/save" : "../producttype/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.productType),
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
				    url: "../producttype/delete",
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
			$.get("../producttype/info/"+id, function(r){
                vm.productType = r.productType;
            });
		},
		reload: function (event) {
			vm.showListKcGrid = true;
			vm.showListKc = true;
			vm.showListPt = true;
			vm.showListPtGrid = false;
			vm.q.createTimeStart = $("#dtp_input1").val();
			vm.q.createTimeEnd = $("#dtp_input2").val();
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{
					'ptName':vm.q.ptName,
					'createUserId':vm.q.createUserId,
					'status':vm.q.status,
					'categoryOne':vm.q.categoryOne,
					'categoryTwo':vm.q.categoryTwo,
					'brand':vm.q.brand,
					'createTimeStart':vm.q.createTimeStart,
					'createTimeEnd':vm.q.createTimeEnd
					},
                page:page
            }).trigger("reloadGrid");
		},
		backToPt: function(){
			vm.showListKcGrid = true;
			vm.showListKc = false;
			vm.showListPt = true;
			vm.showListPtGrid = true;
			vm.showListDetail = true;
			vm.product = {};
			vm.ptid = null;
			vm.title = "类别";
			vm.reload();
		},
		addKc: function(){
			vm.showListKcGrid = true;
			vm.showListKc = false;
			vm.showListPt = true;
			vm.showListPtGrid = true;
			vm.title = "库存/新增";
			vm.product = {productTypeId:vm.ptid};
		},
		updateKc: function (event) {
			var id = $("#jqGridKc").jqGrid('getGridParam','selrow');
			var ids = $("#jqGridKc").jqGrid('getGridParam','selarrrow');
			if(id == null||ids.length!=1){
				alert("请选择一条记录");
				return ;
			}			
			vm.showListKcGrid = true;
			vm.showListKc = false;
			vm.showListPt = true;
			vm.showListPtGrid = true;
            vm.title = "库存/修改";
            
            vm.getInfoKc(id)
		},
		saveOrUpdateKc: function (event) {
			var url = vm.product.id == null ? "../product/save" : "../product/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.product),
			    success: function(r){
			    	if(r.errCode === 0){
						alert('操作成功', function(index){
							vm.reloadKc();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		saveOrUpdateDetail: function (event) {
			var url = "../productdetail/save";
			$.ajax({
				type: "POST",
				url: url,
				data: JSON.stringify(vm.productDetail),
				success: function(r){
					if(r.errCode === 0){
						alert('操作成功', function(index){
							vm.showListKcGrid = true;
							vm.showListKc = false;
							vm.showListPt = true;
							vm.showListPtGrid = true;
							vm.showListDetail = true;
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		delKc: function (event) {
			var id = $("#jqGridKc").jqGrid('getGridParam','selrow');
			var ids = $("#jqGridKc").jqGrid('getGridParam','selarrrow');
			if(id == null||ids.length!=1){
				alert("请选择一条记录");
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../product/delete",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.errCode == 0){
							alert('操作成功', function(index){
								$("#jqGridKc").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfoKc: function(id){
			$.get("../product/info/"+id, function(r){
                vm.product = r.product;
            });
		},
		getInfoDetail: function(id){
			$.get("../productdetail/info/"+id, function(r){
				var id = getSelectedRow();
				vm.productDetail = r.productDetail;
				vm.productDetail.productId = id;
			});
		},
		reloadKc: function (event) {
			vm.showListKcGrid = false;
			vm.showListKc = true;
			vm.showListPt = true;
			vm.showListPtGrid = true;
			var page = $("#jqGridKc").jqGrid('getGridParam','page');
			$("#jqGridKc").jqGrid('setGridParam',{
				postData:{'id': vm.ptid},
                page:page
            }).trigger("reloadGrid");
		},
		delDPic: function() {
        	vm.productDetail.productDetailImgList = [];
		},
		delRPic: function() {
			vm.productDetail.productRoolImgList = [];
		}
//		vendorChange: function(event) {
//			alert(vm.product.vendorNo);
//			$.get("../vendor2/getGridList?vendorNo="+vm.product.vendorNo, function(r){
//				console.log($)
//				vm.gridList = r.gridList;
//			});
//		}
	}
});