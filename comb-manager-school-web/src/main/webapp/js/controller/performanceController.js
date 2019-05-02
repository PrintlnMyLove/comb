app.controller("performanceController",function($scope,$controller,performanceService){
	
	// 查询所有的pv列表的方法:
	$scope.findPv = function(){
		// 向后台发送请求:
		performanceService.findPv().success(function(response){
			$scope.listPv = response;
		});
	}
	
	$scope.findStarRate = function(){
		// 向后台发送请求:
		performanceService.findStarRate().success(function(response){
			$scope.listStarRate = response;
		});
	}
	
	$scope.findGroup = function(){
		// 向后台发送请求:
		performanceService.findGroup().success(function(response){
			$scope.listGroup = response;
		});
	}
});