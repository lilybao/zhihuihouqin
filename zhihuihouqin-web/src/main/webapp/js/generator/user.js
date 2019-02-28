$(function () {
    $("#jqGrid").jqGrid({
        url: '../user/list',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label:'上次登陆时间',name:'oldlogintime',index:'login_time',width:80},
			{ label: '性别', name: 'sex', index: 'sex', width:40,formatter:function(value,options,row){
				if(value==0){
					return "男";
				}else if(value==1){
					return "女";
				}else{
					return "未填写";
					}
			}}, 			
			{ label: '省', name: 'regionid', index: 'regionid', width: 60 ,formatter:function(value,options,row){
				var data;
				$.ajax({
					url:"../regions/infoselect/"+value,
					async:false,
					success:function(result){
						if(result.regions!=null)data= result.regions.fLocalname;
					}
				});
				if(data!=null){
					return data;
				}else{
					return "--";
				}
			}}, 			
			{ label: '市', name: 'pregionid', index: 'pregionid', width: 80 ,formatter:function(value,options,row){
				var data;
				$.ajax({
					url:"../regions/infoselect/"+value,
					async:false,
					success:function(result){
						if(result.regions!=null)data= result.regions.fLocalname;
					}
				});
				if(data!=null){
					return data;
				}else{
					return "--";
				}
			}}, 			
			{ label: '昵称', name: 'nickname', index: 'nickname', width: 80 }, 	
			{ label:'VIP创建时间',name:'vipcretetime',width:80,formatter:function(value,options,row){
				var data;
				$.ajax({
					url:"../uservip/infoselect/"+row.userId,
					async:false,
					success:function(result){
						if(result.userVip!=null)data= result.userVip.createTime;
					}
				});
				if(data!=null){
				return data;
				}else{
					return "--";
				}
			}},
			{ label:'VIP等级',name:'viplevel',width:80,formatter:function(value,options,row){
				var data;
				$.ajax({
					url:"../uservip/infoselect/"+row.userId,
					async:false,
					success:function(result){
						if(result.userVip!=null){
							$.ajax({
								url:"../userviplevel/infoselect/"+result.userVip.levelId,
								async:false,
								success:function(res){
									if(res.userVipLevel!=null)data=res.userVipLevel.level;
								}
							});
						}
					}
				});
				if(data!=null){
					return data+"级";
				}else{
					return "--";
				}
			}},
			{ label:'VIP状态',name:'vipstatus',width:80,formatter:function(value,options,row){
				var data;
				$.ajax({
					url:"../uservip/infoselect/"+row.userId,
					async:false,
					success:function(result){
						if(result.userVip!=null)data= "已激活";
					}
				});
				if(data!=null){
				return data;
				}else{
					return "未激活VIP";
				}
			}}
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
			telname: null
		},
		showList: true,
		title: null,
		user: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			$("#saveandupdate").show();
			vm.queryCity();
			vm.user = {};
		},
		saveOrUpdate: function (event) {
			var url = vm.user.userId == null ? "../user/save" : "../user/update";
			if(!vm.user.sex){
				vm.user["sex"]="0";
			}
			if(!vm.user.regionid){
				vm.user["regionid"]=$("#regionid").val();
			}
			if(!vm.user.pregionid){
				vm.user["pregionid"]=$("#pregionid").val();
			}
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.user),
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
		queryCity:function(){
			$.get("../regions/listselect",function(result){
				users=result.page.list;
				$("#regionid").empty();
				$("#pregionid").empty();
				for(var i=0;i<users.length;i++){
					if(users[i].fPregionid==0){
						$("#regionid").append("<option value='"+users[i].fRegionid+"'>"+users[i].fLocalname+"</option>");
					}else{
						$("#pregionid").append("<option value='"+users[i].fRegionid+"'>"+users[i].fLocalname+"</option>");
					}
				}
			});
		},
		del: function (event) {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../user/delete",
				    data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.queryCity();
			$("#saveandupdate").hide();
			vm.showList = false;
            vm.title = "查询";
			$.get("../user/info/"+id, function(r){
                vm.user = r.user;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			if(isNaN(vm.q.telname)){
				$("#jqGrid").jqGrid('setGridParam',{ 
					postData:{'username': vm.q.telname},
	                page:page
	            }).trigger("reloadGrid");
				$("#jqGrid").jqGrid('setGridParam',{ 
					postData:{'username': null},
	                page:page
	            });
			}else{
				$("#jqGrid").jqGrid('setGridParam',{ 
					postData:{'mobile': vm.q.telname},
	                page:page
	            }).trigger("reloadGrid");
				$("#jqGrid").jqGrid('setGridParam',{ 
					postData:{'mobile': null},
	                page:page
	            });
			}
		}
	}
});