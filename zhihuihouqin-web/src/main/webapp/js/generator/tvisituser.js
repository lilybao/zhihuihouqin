$(function () {
    $("#jqGrid").jqGrid({
        url: '../tvisituser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '姓名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '房间号', name: 'roomnum', index: 'roomnum', width: 80 }, 			
			{ label: '来访事由', name: 'reason', index: 'reason', width: 80 }, 			
			{ label: '预计到达时间', name: 'expertarrivaltime', index: 'expertarrivaltime', width: 80 }, 			
			{ label: '预计离开时间', name: 'expertleavetime', index: 'expertleavetime', width: 80 }, 			
			{ label: '访问时段 1: 一次，2：一星期，3：半个月，4：长期', name: 'visitperiod', index: 'visitperiod', width: 80 }, 			
			{ label: '车辆类型id', name: 'cartypeid', index: 'cartypeid', width: 80 }, 			
			{ label: '车牌号前缀', name: 'precarcode', index: 'precarcode', width: 80 }, 			
			{ label: '车牌号尾数', name: 'suffixcarcode', index: 'suffixcarcode', width: 80 }			
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
		tVisitUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tVisitUser = {};
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
			var url = vm.tVisitUser.id == null ? "../tvisituser/save" : "../tvisituser/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tVisitUser),
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
				    url: "../tvisituser/delete",
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
			$.get("../tvisituser/info/"+id, function(r){
                vm.tVisitUser = r.tVisitUser;
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