$(function () {
    $("#jqGrid").jqGrid({
        url: '../tuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '用户名', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '密码', name: 'password', index: 'password', width: 80 }, 			
			{ label: '创建时间', name: 'createtime', index: 'createtime', width: 80 }, 			
			{ label: '更新时间', name: 'updatetime', index: 'updatetime', width: 80 }, 			
			{ label: '微信号', name: 'wxnum', index: 'wxnum', width: 80 }, 			
			{ label: '微博号', name: 'wbnum', index: 'wbnum', width: 80 }, 			
			{ label: 'qq号', name: 'qqnum', index: 'qqnum', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '用户昵称', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '是否有效   1:有效，0 无效', name: 'valid', index: 'valid', width: 80 }, 			
			{ label: '办公室座机', name: 'tel', index: 'tel', width: 80 }, 			
			{ label: '房间号', name: 'roomnum', index: 'roomnum', width: 80 }, 			
			{ label: '性别 1:男 0：女', name: 'sex', index: 'sex', width: 80 }, 			
			{ label: '头像', name: 'photo', index: 'photo', width: 80 }, 			
			{ label: '职位id', name: 'positionid', index: 'positionid', width: 80 }, 			
			{ label: '登录状态', name: 'loginstatus', index: 'loginstatus', width: 80 }, 			
			{ label: '登录后服务端唯一标识', name: 'signid', index: 'signid', width: 80 }, 			
			{ label: '真实姓名', name: 'realname', index: 'realname', width: 80 }			
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
		tUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tUser = {};
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
			var url = vm.tUser.id == null ? "../tuser/save" : "../tuser/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tUser),
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
				    url: "../tuser/delete",
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
			$.get("../tuser/info/"+id, function(r){
                vm.tUser = r.tUser;
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