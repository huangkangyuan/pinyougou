// 定义控制器:
app.controller("brandController",function($scope,$controller,$http,brandService,uploadService){
	// AngularJS中的继承:伪继承
	$controller('baseController',{$scope:$scope});
	
	// 查询所有的品牌列表的方法:
	$scope.findAll = function(){
		// 向后台发送请求:
		brandService.findAll().success(function(response){
			$scope.list = response;
			alert($scope.list);
		});
	}

	// 分页查询
	$scope.findByPage = function(page,rows){
		// 向后台发送请求获取数据:
		brandService.findByPage(page,rows).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
	
	// 保存品牌的方法:
	$scope.save = function(){
		// 区分是保存还是修改
		var object;
		if($scope.entity.id != null){
			// 更新
			object = brandService.update($scope.entity);
		}else{
			// 保存
			object = brandService.save($scope.entity);
		}
		object.success(function(response){
			// {flag:true,message:xxx}
			// 判断保存是否成功:
			if(response.flag==true){
				// 保存成功
				alert(response.message);
				$scope.reloadList();
			}else{
				// 保存失败
				alert(response.message);
			}
		});
	}
	
	// 查询一个:
	$scope.findById = function(id){
		brandService.findById(id).success(function(response){
			// {id:xx,name:yy,firstChar:zz}
			$scope.entity = response;
		});
	}
	
	// 删除品牌:
	$scope.dele = function(){
		brandService.dele($scope.selectIds).success(function(response){
			// 判断删除是否成功:
			if(response.flag==true){
				// 删除成功
				// alert(response.message);
				$scope.reloadList();
				$scope.selectIds = [];
			}else{
				// 删除失败
				alert(response.message);
			}
		});
	}
	
	$scope.searchEntity={};
	
	// 假设定义一个查询的实体：searchEntity
	$scope.search = function(page,rows){
		// 向后台发送请求获取数据:
		brandService.search(page,rows,$scope.searchEntity).success(function(response){
			$scope.paginationConf.totalItems = response.total;
			$scope.list = response.rows;
		});
	}
	
	// 文件上传的方法:
	$scope.uploadFile = function(){
		uploadService.uploadFile().success(function(response){
			if(response.flag){
				$scope.entity.image = response.message;
			}else{
				$scope.entity.image = response.message;
			}
		});
	}
	
});
