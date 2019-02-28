$(function () {
    $("#jqGrid").jqGrid({
        url: '../tyytcstep/list',
        datatype: "json",
        colModel: [			
			{ label: 'sId', name: 'sId', index: 's_id', width: 50, key: true },
			{ label: '菜单id', name: 'mId', index: 'm_id', width: 80 }, 			
			{ label: '步骤内容', name: 'sContent', index: 's_content', width: 80 }, 			
			{ label: '步骤配图', name: 'sImg', index: 's_img', width: 80 }, 			
			{ label: '步骤顺序', name: 'sSort', index: 's_sort', width: 80 }			
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
		tYytcStep: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tYytcStep = {};
		},
		update: function (event) {
			var sId = getSelectedRow();
			if(sId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(sId)
		},
		saveOrUpdate: function (event) {
			var url = vm.tYytcStep.sId == null ? "../tyytcstep/save" : "../tyytcstep/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tYytcStep),
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
			var sIds = getSelectedRows();
			if(sIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tyytcstep/delete",
				    data: JSON.stringify(sIds),
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
		getInfo: function(sId){
			$.get("../tyytcstep/info/"+sId, function(r){
                vm.tYytcStep = r.tYytcStep;
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