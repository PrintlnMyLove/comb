 //控制层 
app.controller('teamUserController' ,function($scope,$controller,$location,teamUserService,loginService,uploadService){	
	
	$controller('baseController',{$scope:$scope});//继承
	var id = $location.search()['id'];
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		teamUserService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
//	//分页
//	$scope.findPage=function(page,rows){			
//		teamUserService.findPage(page,rows).success(
//			function(response){
//				$scope.list=response.rows;	
//				$scope.paginationConf.totalItems=response.total;//更新总记录数
//			}			
//		);
//	}
	
	//查询实体 
	$scope.findOne=function(){	
		teamUserService.findOne(id).success(
			function(response){
				$scope.entity= response;	
			}
		);				
	}
	
	//保存 
	$scope.save=function(){		
		var serviceObject;//服务层对象  				
		serviceObject=teamUserService.update($scope.entity); //修改  		
		serviceObject.success(
			function(response){
				if(response.success){
					alert(response.message);
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		teamUserService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		teamUserService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	//新增注册
	$scope.add=function(){						
		teamUserService.add( $scope.entity  ).success(
			function(response){
				if(response.success){
					//如果注册成功，跳转到登录页
					alert("注册信息已提交！请耐心等待工作人员审核结果！");
					location.href="/teamlogin.html";
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	// 文件上传的方法:
	$scope.uploadFile = function(){
		uploadService.uploadFile().success(function(response){
			if(response.flag){
				$scope.entity.logoPic = response.message;
			}else{
				alert(response.message);
			}
		});
	}
	
	// 文件上传的方法:
	$scope.uploadApplyFile = function(){
		uploadService.uploadFile().success(function(response){
			if(response.flag){
				$scope.entity.FileData = response.message;
				alert(response.message);
			}else{
				alert(response.message);
			}
		});
	}
	
	
	//显示当前用户名
	$scope.showLoginName=function(){
		loginService.loginName().success(
			function(response){
				$scope.loginName=response.loginName;				
			}
		);		
	}
	
	
	//重置密码
	$scope.updataPassword=function(){
		$scope.showLoginName();
		if($scope.entity.password == $scope.entity.oldPassword){
			alert("新旧密码一样！");
			return;
		}
		if(!($scope.entity.password == $scope.entity.passwordTwo)){
			alert("两次输入的密码不一样！");
			return;
		}
		loginService.updataPassword($scope.entity.oldPassword,$scope.entity.password,id).success(function(response){
			if(response.flag){
				alert(response.message);
			}else{
				alert(response.message);
			}
		});
	}
});	
