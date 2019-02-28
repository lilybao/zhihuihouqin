$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/user/list',
        datatype: "json",
        colModel: [			
			{ label: '用户ID', name: 'userId', index: "user_id", width: 45, key: true },
			{ label: '用户名', name: 'username', width: 75,sortable: false  },
			{ label: '手机号', name: 'mobile', width: 100 ,sortable: false },
			{ label: '真实姓名', name: 'realName', index: 'real_name', width: 80 },
			{ label: '工号', name: 'jobNumber', index: 'job_number', width: 80 },	
			/*{ label: '用户类型', name: 'type', index: 'type', width: 80 , formatter: function(value, options, row){
				return value === 0 ? 
						'<span class="label label-warning">管理端</span>' : 
						'<span class="label label-success">web端</span>';
				}},
			{ label: '管理端职位', name: 'position', index: 'position', width: 80 },
			{ label: 'web端职位', name: 'roleList', width: 80,sortable: false , formatter: function(value, options, row){
				var str = '';
				if (value!=null&&value!=undefined&&value!="") {
					for (var i = 0; i < value.length; i++) {
						if (i==value.length-1) {
							str += value[i].roleName;
						}else{
							str += value[i].roleName+',';
						}
					}
				}
				return str;
			}},
			{ label: '区域id', name: 'regionId', index: 'region_id', width: 80 }, */
			{ label: '状态', name: 'status', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
					'<span class="label label-danger">禁用</span>' : 
					'<span class="label label-success">正常</span>';
			}},
			{ label: '创建时间', name: 'createTime', index: "create_time", width: 80},
			{ label: '性别', name: 'sex', index: 'sex', width: 80, formatter: function(value, options, row){
				return value === 0 ? 
						'女' : 
						'男';
				} }, 			
			{ label: '年龄', name: 'age', index: 'age', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 						
			/*{ label: '个人简介', name: 'profile', index: 'profile', width: 80 }, 			
			{ label: '工号', name: 'jobNumber', index: 'job_number', width: 80 }*/
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
            	vm.user.avatar = r.url;
            }else{
                alert(r.msg);
            }
        }
    });
    $.get("../regions/getRegionList", function(r){
		console.log($)
		vm.regionList = r.regionList;
	});
    $.get("../sys/role/select", function(r){
		console.log($)
		vm.roleList = r.list;
	});
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			username: null,
			mobile:null,
			regionId:'',
			roleId:'',
			type:''
		},
		showList: true,
		title:null,
		roleList:{},
		regionList:{},
		user:{
			status:1,
			roleIdList:[],
			avatar:null,
			regionId:null,
			type:0,
			positionNameList:[]
		},
		roleShow:true,
		positionList: []
	},
	watch:{
		'user.type': function(val,oldval){  
//            console.log(val+"aaa");
//            alert(val+"aa");
			if (val==0) {
				vm.roleShow = true;
			}else{
				vm.roleShow = false;
			}
        }
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.positionList = [{name:"消毒专员"},{name:"补货专员"},{name:"换货专员"},{name:"维修专员"}]
			vm.user = {status:1,roleIdList:[],avatar:null,regionId:null,type:0,role:true,positionNameList: []};
			//获取角色信息
			this.getRoleList();
//			this.getRegionList();
		},
		update: function () {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			
			vm.showList = false;
            vm.title = "修改";
			
			vm.getUser(userId);
			//获取角色信息
			this.getRoleList();
			vm.positionList = [{name:"消毒专员"},{name:"补货专员"},{name:"换货专员"},{name:"维修专员"}]
//			this.getRegionList();
		},
		del: function () {
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sys/user/delete",
				    data: JSON.stringify(userIds),
				    success: function(r){
						if(r.errCode == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		saveOrUpdate: function (event) {
			var url = vm.user.userId == null ? "../sys/user/save" : "../sys/user/update";
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
		getUser: function(userId){
			$.get("../sys/user/info/"+userId, function(r){
				vm.user = r.user;
			});
		},
		getRoleList: function(){
			$.get("../sys/role/select", function(r){
				console.log($)
				vm.roleList = r.list;
			});
		},
		/*getRegionList: function(){
			$.get("../regions/getRegionList", function(r){
				console.log($)
				vm.regionList = r.regionList;
			});
		},*/
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'username': vm.q.username,'mobile':vm.q.mobile,'regionId':vm.q.regionId,'roleId':vm.q.roleId,'type':vm.q.type},
                page:page
            }).trigger("reloadGrid");
		}
	}
});