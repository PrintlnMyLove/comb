//首页控制器
app.controller('indexController',function($scope,loginService,orderService) {


	//搜索  （传递参数）
	$scope.search = function () {
		location.href = "http://localhost:8084/search.html#?keywords=" + $scope.keywords;
	}

	$scope.showName = function () {
		loginService.showName().success(
				function (response) {
					$scope.loginName = response.loginName;
				}
		);
	}

	//查询订单列表
	$scope.findOrderList = function () {
		orderService.findOrderList().success(
				function (response) {
					$scope.orderList = response;
				}
		);
	}

	$scope.ensure = function (id) {
		if (confirm("是否确认收货？")) {
			orderService.ensure(id).success(
					function (response) {
						if (response.success) {
							//重新查询 
							alert(response.message);
							window.location.reload();
						} else {
							alert(response.message);
						}
					}
			);
		}

	}
	$scope.status = ["", "未付款", "已付款", "未发货", "已发货", "交易成功", "交易关闭", "待评价"];

	var star = 0;
	$scope.check = function (param) {
		star = param;
	}

	var sellerId;
	$scope.getTeam = function (param) {
		sellerId = param;
	}

	$scope.evaluation = function (id) {
		orderService.evaluation(star, sellerId,id).success(
				function (response) {
					if (response.success) {
						window.location.reload();
					}
				}
		);
	}
})