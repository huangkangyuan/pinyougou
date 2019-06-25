app.service('contentService' ,function($http){
	
	//根据广告分类ID查询广告
	this.findByCategoryId=function(categoryId){
		return $http.get('content/findByCategoryId.do?categoryId='+categoryId);
	}
	
});