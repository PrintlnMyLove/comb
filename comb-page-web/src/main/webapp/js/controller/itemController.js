 //控制层 
app.controller('itemController' ,function($scope,$http){	

	$scope.specificationItems={};//记录用户选择的规格
	
	//数量加减
	$scope.addNum=function(x){
		$scope.num+=x;
		if($scope.num<1){
			$scope.num=1;
		}
	}
	
		//用户选择规格
	$scope.selectSpecification=function(name,value){	
		$scope.specificationItems[name]=value;
		searchSku();
	}	
	//判断某规格选项是否被用户选中
	$scope.isSelected=function(name,value){
		if($scope.specificationItems[name]==value){
			return true;
		}else{
			return false;
		}		
	}

	$scope.sku={};
	
	//加载默认SKU
	$scope.loadSku=function(){
		$scope.sku=skuList[0];		
		$scope.specificationItems= JSON.parse(JSON.stringify($scope.sku.spec));
	}

	//匹配两个对象
	matchObject=function(map1,map2){		
		for(var k in map1){
			if(map1[k]!=map2[k]){
				return false;
			}			
		}
		for(var k in map2){
			if(map2[k]!=map1[k]){
				return false;
			}			
		}
		return true;		
	}
	
	//查询SKU
	searchSku=function(){
		for(var i=0;i<skuList.length;i++ ){
			if( matchObject(skuList[i].spec ,$scope.specificationItems ) ){
				$scope.sku=skuList[i];
				return ;
			}			
		}	
		$scope.sku={id:0,title:'----暂无此规格产品----',price:0};//如果没有匹配的		
	}
	//添加商品到购物车
		$scope.addToCart=function(){
		//alert('skuid:'+$scope.sku.id);	
		
		$http.get('http://localhost:8087/cart/addGoodsToCartList.do?itemId=' + $scope.sku.id + '&num=' + $scope.num ,{'withCredentials':true}).success(
				function(response){
					if(response.success){
						location.href='http://localhost:8087/cart.html';
					}else{
						alert(response.message);
					}
				}
		);
		
	}
		
	
});	
