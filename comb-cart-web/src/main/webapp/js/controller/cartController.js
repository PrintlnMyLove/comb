//购物车控制层
app.controller('cartController',function($scope,cartService,addressService){


	//查询购物车列表
	$scope.findCartList=function(){
		cartService.findCartList().success(
			function(response){
				$scope.cartList=response;
				$scope.totalValue= cartService.sum($scope.cartList);
			}
		);
	}
	
	//数量加减
	$scope.addGoodsToCartList=function(itemId,num){
		cartService.addGoodsToCartList(itemId,num).success(
			function(response){
				if(response.success){//如果成功
					$scope.findCartList();//刷新列表
				}else{
					alert(response.message);
				}				
			}		
		);		
	}
	

	//搜索  （传递参数）
	$scope.search=function(){
		location.href="http://localhost:8084/search.html#?keywords="+$scope.keywords;
	}
	
	//获取当前用户的地址列表
	$scope.findAddressList=function(){
		cartService.findAddressList().success(
			function(response){
				$scope.addressList=response;
				for(var i=0;i<$scope.addressList.length;i++){
					if($scope.addressList[i].isDefault=='1'){
						$scope.address=$scope.addressList[i];
						break;
					}					
				}
				
			}
		);		
	}
	
	//选择地址
	$scope.selectAddress=function(address){
		$scope.address=address;		
	}
	
	//判断某地址对象是不是当前选择的地址
	$scope.isSeletedAddress=function(address){
		if(address==$scope.address){
			return true;
		}else{
			return false;
		}		
	}
	
	$scope.order={paymentType:'1'};//订单对象
	
	//选择支付类型
	$scope.selectPayType=function(type){
		$scope.order.paymentType=type;
	}


	//var orderCount = [];
	var orderCount = [];

//	$scope.orderCount=function(){
//		for(cart in $scope.cartList){
//			for(item in cart){
//				obj = {orderNum:item.num, sellerId:item.sellerId};
//				orderCount.push(obj);
//
//			}
//		}
//
//		cartService.orderCount(orderCount).success(
//				function(response){
//
//				}
//
//		)
//	}

	//保存订单
	$scope.submitOrder=function(){
		$scope.order.receiverAreaName=$scope.address.address;//地址
		$scope.order.receiverMobile=$scope.address.mobile;//手机
		$scope.order.receiver=$scope.address.contact;//联系人
//		$scope.orderCount();
		cartService.submitOrder( $scope.order ).success(
		function(response){
				//alert(response.message);
				if(response.success){
					//页面跳转
					if($scope.order.paymentType=='1'){//如果是微信支付，跳转到支付页面
						location.href="pay.html";
					}else if($scope.order.paymentType=='2'){//如果货到付款，跳转到提示页面
						location.href="paysuccess.html";
					}else{
						location.href="paysuccess.html";
					}
					
				}else{
					alert(response.message);	//也可以跳转到提示页面				
				}
				
			}				
		);		
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=addressService.update( $scope.entity ); //修改  
		}else{
			serviceObject=addressService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
					location.reload();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	//查询实体 
	$scope.findOne=function(id){				
		addressService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//批量删除 
	$scope.dele=function(id){	
		if(confirm("是否确定删除地址？")){
			//获取选中的复选框	
			addressService.dele(id ).success(
				function(response){
					if(response.success){
						alert(response.message);
						location.reload();
					}						
				}		
			);	
		}		
	}
	
	$scope.showName=function(){
		cartService.showName().success(
			function(response){				
				$scope.loginName=response.loginName;
			}
		);
	}


});