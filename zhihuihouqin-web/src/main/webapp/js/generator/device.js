$(function () {
    $("#jqGrid").jqGrid({
        url: '../device/list',
        datatype: "json",
        colModel: [			
			{ label: 'deviceId', name: 'deviceId', index: 'device_id', width: 50, key: true },
			{ label: '设备名字', name: 'deviceName', index: 'device_name', width: 80 }, 			
			{ label: 'imei', name: 'imei', index: 'imei', width: 80 }, 			
			{ label: '', name: 'addTime', index: 'add_time', width: 80 }			
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
		device: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.device = {};
		},
		update: function (event) {
			var deviceId = getSelectedRow();
			if(deviceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(deviceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.device.deviceId == null ? "../device/save" : "../device/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.device),
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
			var deviceIds = getSelectedRows();
			if(deviceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../device/delete",
				    data: JSON.stringify(deviceIds),
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
		getInfo: function(deviceId){
			$.get("../device/info/"+deviceId, function(r){
                vm.device = r.device;
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