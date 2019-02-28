$(function () {
    $("#jqGrid").jqGrid({
        url: '../vendor/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '编号', name: 'no', index: 'no', width: 80 }, 			
			{ label: '地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '经度', name: 'lon', index: 'lon', width: 80 }, 			
			{ label: '纬度', name: 'lat', index: 'lat', width: 80 }, 			
			{ label: '总容量', name: 'total', index: 'total', width: 80 }, 			
			{ label: '区域ID', name: 'regionId', index: 'region_id', width: 80 }, 			
			{ label: '类型', name: 'type', index: 'type', width: 80 }, 			
			{ label: '管理员',name:'admin',index:'admin',width:80 ,formatter:function(value, options, row){
				var data;
				$.ajax({
						url:"../userhandle/querybyid",
						data:"id="+row.id,
						async:false,
						success:function(result){
							data= result;
					}
				});
				return data;
			}},
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
		vendor: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.queryAdmin();
			vm.vendor = {};
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
			var url = vm.vendor.id == null ? "../vendor/save" : "../vendor/update";
			if(!vm.vendor.admin){
				vm.vendor["admin"]=$("#admin").val();
			}
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.vendor),
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
				    url: "../vendor/delete",
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
		queryAdmin:function(){
			$("#vno").show();
			$("#vtotal").show();
			$("#vtype").show();
			$.get("../managers/lists",function(result){
				var vendorid=result.page.list;
				$("#admin").empty();
				for(i=0;i<vendorid.length;i++){
						$("#admin").append("<option value='"+vendorid[i].id+"'>"+vendorid[i].nickname+"</option>");
					}
			});
		},
		getInfo: function(id){
			$.get("../vendor/info/"+id, function(r){
				$("#vno").hide();
				$("#vtotal").hide();
				$("#vtype").hide();
                vm.vendor = r.vendor;
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