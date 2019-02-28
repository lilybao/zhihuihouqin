$(function () {
    $("#jqGrid").jqGrid({
        url: '../ylfwyyghdoctor/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '医生名称', name: 'realname', index: 'realname', width: 80 }, 			
			{ label: '职称', name: 'positionid', index: 'positionid', width: 80 }, 			
			{ label: '电话', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '医院', name: 'hospitalid', index: 'hospitalid', width: 80 }, 			
			{ label: '问诊量', name: 'consultcount', index: 'consultcount', width: 80 }, 			
			{ label: '分数', name: 'score', index: 'score', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '是否有效 1:有效，0-：无效', name: 'valid', index: 'valid', width: 80 }, 			
			{ label: '简介', name: 'brief', index: 'brief', width: 80 }, 			
			{ label: '图片', name: 'photo', index: 'photo', width: 80 }			
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
		ylfwYyghDoctor: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.ylfwYyghDoctor = {};
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
			var url = vm.ylfwYyghDoctor.id == null ? "../ylfwyyghdoctor/save" : "../ylfwyyghdoctor/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.ylfwYyghDoctor),
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
				    url: "../ylfwyyghdoctor/delete",
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
			$.get("../ylfwyyghdoctor/info/"+id, function(r){
                vm.ylfwYyghDoctor = r.ylfwYyghDoctor;
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