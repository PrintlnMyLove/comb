app.service('searchService',function($http){
	
	
	this.search=function(searchMap){
		return $http.post('itemsearch/search.do',searchMap);
	}
	
	this.pvConunt=function(goodsId){
		return $http.get('itemsearch/pvConunt.do?goodsId='+goodsId);
	}
	
});