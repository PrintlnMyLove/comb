//服务层
app.service('teamUserService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../teamUser/findAll.do');		
	}
//	//分页 
//	this.findPage=function(page,rows){
//		return $http.get('../teamUser/findPage.do?page='+page+'&rows='+rows);
//	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../teamUser/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../teamUser/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../teamUser/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../teamUser/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../teamUser/search.do?page='+page+"&rows="+rows, searchEntity);
	}    	
	//更新状态
	this.updateStatus = function(teamId,status){
		return $http.get('../teamUser/updateStatus.do?teamId='+teamId+"&status="+status);
	}
});
