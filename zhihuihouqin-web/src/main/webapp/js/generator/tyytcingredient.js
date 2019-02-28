$(function () {
    $("#jqGrid").jqGrid({
        url: '../tyytcingredient/list',
        datatype: "json",
        colModel: [			
			{ label: 'iId', name: 'iId', index: 'i_id', width: 50, key: true },
			{ label: '原料名称(包括用量)', name: 'iNameNum', index: 'i_name_num', width: 80 }, 			
			{ label: '菜单id', name: 'mId', index: 'm_id', width: 80 }			
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
		tYytcIngredient: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tYytcIngredient = {};
		},
		update: function (event) {
			var iId = getSelectedRow();
			if(iId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(iId)
		},
		saveOrUpdate: function (event) {
			var url = vm.tYytcIngredient.iId == null ? "../tyytcingredient/save" : "../tyytcingredient/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tYytcIngredient),
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
			var iIds = getSelectedRows();
			if(iIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tyytcingredient/delete",
				    data: JSON.stringify(iIds),
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
		getInfo: function(iId){
			$.get("../tyytcingredient/info/"+iId, function(r){
                vm.tYytcIngredient = r.tYytcIngredient;
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