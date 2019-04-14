 //控制层 
app.controller('orderController' ,function($scope,$controller   , orderService,orderItemService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		orderService.findAll().success(
			function(response){
				$scope.list1=response;
			}			
		);
	}    
	
	//查询实体 
	$scope.findGood=function(id){				
		orderItemService.findGood(id).success(
			function(response){
				$scope.list2= response;					
			}
		);				
	}
	
	//分页
	$scope.findPage=function(page,rows){			
		orderService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){	
		orderService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.orderId!=null){//如果有ID
			serviceObject=orderService.update( $scope.entity ); //修改  
		}else{
			serviceObject=orderService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
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
		orderService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					alert(response.message);
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}else{
					alert(response.message);
				}						
			}		
		);				
	}
	
	
	//批量删除 
	$scope.updateStatus=function(){			
		//获取选中的复选框			
		orderService.updateStatus( $scope.selectIds ).success(
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
		orderService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	
	
	// 显示状态
	$scope.type = ["","在线付款","货到付款"];
	$scope.status = ["","未付款","已付款","未发货","已发货","交易成功","交易关闭","待评价","退货"];
	$scope.sourceType = ["","PC端","移动端"];
});	
