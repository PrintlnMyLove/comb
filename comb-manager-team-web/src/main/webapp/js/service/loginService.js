app.service('loginService',function($http){
	
	this.loginName=function(){
		return $http.get('../login/name.do');
	}
	
	//重置密码
	this.updataPassword=function(oldPassword, password,id){
		return $http.get('../teamUser/updataPassword.do?oldPassword='+oldPassword+"&password="+password+"&id="+id);
	}
	
});