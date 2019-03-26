app.service('uploadService',function($http){
	
	//上传文件
	this.uploadFile=function(){
		var formdata=new FormData();//上传
		formdata.append('file',file.files[0]);//file 文件上传框的name
		
		return $http({
			url:'../upload.do',		
			method:'post',
			data:formdata,
			headers:{'Content-Type':undefined },//默认是JSON
			transformRequest: angular.identity	 //二进制序列化		
		});
	}
	
});