// 定义服务层:
app.service("performanceService",function($http){
	this.findPv = function(){
		return $http.get("../teamUser/findPv.do");
	}
	
	this.findStarRate = function(){
		return $http.get("../teamUser/findStarRate.do");
	}
	
	this.findGroup = function(){
		return $http.get("../teamUser/findGroup.do");
	}
});