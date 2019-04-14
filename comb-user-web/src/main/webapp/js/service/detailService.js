//服务层
app.service('detailService',function($http){
	this.findOrder=function(id){
		return $http.get('../order/findOrder.do?id='+id);
	}
})