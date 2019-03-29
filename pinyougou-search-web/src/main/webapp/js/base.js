// 定义模块:
var app = angular.module("pinyougou",[]);
// 定义过滤器
app.filter('trustHtml',['$sce',function($sce){
	return function(data){//传入参数时被过滤的内容
		return $sce.trustAsHtml(data);//返回的是过滤后的内容（信任html的转换）
	}	
} ]);
