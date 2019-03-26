app.controller('indexController',function($scope,loginService){
	
	
	//显示当前用户名
	$scope.showLoginName=function(){
		loginService.loginName().success(
			function(response){
				$scope.loginName=response.loginName;				
				$scope.loginTime=response.loginTime;				
			}
		);		
	}
	
});