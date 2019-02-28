$(function () {
    $("#jqGrid").jqGrid({
        url: '../tyytcroolingimg/list',
        datatype: "json",
        colModel: [			
			{ label: 'riId', name: 'riId', index: 'ri_id', width: 50, key: true },
			{ label: '轮播图片', name: 'riImgPath', index: 'ri_img_path', width: 80 }, 			
			{ label: '排序', name: 'riSort', index: 'ri_sort', width: 80 }, 			
			{ label: '菜单id', name: 'riMId', index: 'ri_m_id', width: 80 }			
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
		tYytcRoolingimg: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tYytcRoolingimg = {};
		},
		update: function (event) {
			var riId = getSelectedRow();
			if(riId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(riId)
		},
		saveOrUpdate: function (event) {
			var url = vm.tYytcRoolingimg.riId == null ? "../tyytcroolingimg/save" : "../tyytcroolingimg/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tYytcRoolingimg),
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
			var riIds = getSelectedRows();
			if(riIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tyytcroolingimg/delete",
				    data: JSON.stringify(riIds),
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
		getInfo: function(riId){
			$.get("../tyytcroolingimg/info/"+riId, function(r){
                vm.tYytcRoolingimg = r.tYytcRoolingimg;
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