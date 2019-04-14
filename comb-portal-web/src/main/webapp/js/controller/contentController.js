app.controller("contentController",function($scope,$sce,contentService){
	//广告列表
	$scope.contentList = [];
	// 根据分类ID查询广告的方法:
	$scope.findByCategoryId = function(categoryId){
			contentService.findByCategoryId(categoryId).success(function(response){
				$scope.contentList[categoryId] = response;
			});
	}
	
	$scope.find5=function(){
		findByCategoryId(5);
		$scope.contentList[5]
	}
	
	
	//搜索  （传递参数）
	$scope.search=function(){
		location.href="http://localhost:8084/search.html#?keywords="+$scope.keywords;
	}
	
	$scope.showName=function(){
		contentService.showName().success(
			function(response){				
				$scope.loginName=response.loginName;
			}
		);
	}

	$scope.list = [];
	$scope.findItemCatList=function(parentId){
		contentService.findItemCatList(parentId).success(
			function(response){			
				$scope.list[parentId] = response;
			}
		);
	}
	
	
//	
//	$scope.renderFinish = function(){
//		console.log("已完成");
//		$scope.modalBody=$sce.trustAsHtml("<script type='text/javascript' src='js/plugins/jquery/jquery.min.js'></script><script type='text/javascript' src='js/plugins/jquery.easing/jquery.easing.min.js'></script><script type='text/javascript' src='js/model/cartModel.js'></script><script type='text/javascript' src='js/czFunction.js'></script><script type='text/javascript' src='js/plugins/sui/sui.min.js'></script><script type='text/javascript' src='js/pages/index.js'></script><script type='text/javascript' src='js/widget/cartPanelView.js'></script><script type='text/javascript' src='js/widget/jquery.autocomplete.js'></script><script type='text/javascript' src='js/widget/nav.js'></script>")
//	}

	
	
	


	
	
	
	
	
	
	
	
	
	
	
});