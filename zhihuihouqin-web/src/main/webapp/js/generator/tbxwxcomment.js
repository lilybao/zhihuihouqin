$(function () {
    $("#jqGrid").jqGrid({
        url: '../tbxwxcomment/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '图片', name: 'imgs', index: 'imgs', width: 80 }, 			
			{ label: '评价内容', name: 'content', index: 'content', width: 80 }, 			
			{ label: '订单编号', name: 'orderid', index: 'orderid', width: 80 }, 			
			{ label: '用户编号', name: 'uid', index: 'uid', width: 80 }, 			
			{ label: '维修人员编号', name: 'menderid', index: 'menderid', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '总分', name: 'score', index: 'score', width: 80 }, 			
			{ label: '是否匿名 1；是 0:否', name: 'anonymous', index: 'anonymous', width: 80 }			
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
		tBxwxComment: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tBxwxComment = {};
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
			var url = vm.tBxwxComment.id == null ? "../tbxwxcomment/save" : "../tbxwxcomment/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tBxwxComment),
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
				    url: "../tbxwxcomment/delete",
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
			$.get("../tbxwxcomment/info/"+id, function(r){
                vm.tBxwxComment = r.tBxwxComment;
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