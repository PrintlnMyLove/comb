app.controller('detailController' ,function($scope,$controller,$location,orderService,detailService,loginService){
	
	$controller('indexController',{$scope:$scope});//继承
	
	
	
	$scope.findOrder=function(){
		var id = $location.search()['id'];
		detailService.findOrder(id).success(
				function(response){
					$scope.orderItem=response;
					$scope.status_order=['','finished','todo','todo','todo','todo'];
					for(var i=2; i < $scope.orderItem.order.status;i++){
						$scope.status_order[i]='current';
						if(i == 4) $scope.status_order[5]='current';
					}
				}
			);
	}
	
	$scope.payType=['','在线付款','货到付款'];
	
})