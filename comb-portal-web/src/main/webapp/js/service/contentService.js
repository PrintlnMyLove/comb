app.service("contentService",function($http){
	
	
	this.findByCategoryId = function(categoryId){
		return $http.get("content/findByCategoryId.do?categoryId="+categoryId);
	}
	
	//读取登录名
	this.showName=function(){
		return $http.get('../login/name.do');		
	}

	this.findItemCatList = function(parentId){
		return $http.get("content/getItemCatList.do?parentId="+parentId);
	}
	
});