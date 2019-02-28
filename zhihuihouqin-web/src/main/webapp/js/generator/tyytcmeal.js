$(function () {
    $("#jqGrid").jqGrid({
        url: '../tyytcmeal/list',
        datatype: "json",
        colModel: [			
			{ label: 'mId', name: 'mId', index: 'm_id', width: 50, key: true },
			{ label: '题目', name: 'mTitle', index: 'm_title', width: 80 }, 			
			{ label: '创建时间', name: 'mCreateTime', index: 'm_create_time', width: 80 }, 			
			{ label: '来源', name: 'mSource', index: 'm_source', width: 80 }, 			
			{ label: '菜单类型(1早2中3晚)', name: 'mType', index: 'm_type', width: 80 }, 			
			{ label: '菜单配图', name: 'mImg', index: 'm_img', width: 80 }, 			
			{ label: '菜单简介', name: 'mContent', index: 'm_content', width: 80 }, 			
			{ label: '浏览人数', name: 'mScanNum', index: 'm_scan_num', width: 80 }, 			
			{ label: '点赞人数', name: 'mPraiseNum', index: 'm_praise_num', width: 80 }, 			
			{ label: '收藏人数', name: 'mFavorNum', index: 'm_favor_num', width: 80 }, 			
			{ label: '摄入热量(卡路里)', name: 'mCalories', index: 'm_calories', width: 80 }			
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
		tYytcMeal: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tYytcMeal = {};
		},
		update: function (event) {
			var mId = getSelectedRow();
			if(mId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(mId)
		},
		saveOrUpdate: function (event) {
			var url = vm.tYytcMeal.mId == null ? "../tyytcmeal/save" : "../tyytcmeal/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tYytcMeal),
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
			var mIds = getSelectedRows();
			if(mIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tyytcmeal/delete",
				    data: JSON.stringify(mIds),
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
		getInfo: function(mId){
			$.get("../tyytcmeal/info/"+mId, function(r){
                vm.tYytcMeal = r.tYytcMeal;
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