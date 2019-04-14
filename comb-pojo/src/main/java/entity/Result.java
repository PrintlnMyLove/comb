package entity;

import java.io.Serializable;

/**
 * *
 * 用于向页面传递信息的类
 * @author WangQingBang
 *要在网络上传输，必须序列化
 */
public class Result implements Serializable{
	
	private boolean success;	//是否成功
	private boolean flag;		
	private String message;		//返回信息
	
	public Result(boolean success, String message) {
		super();
		this.success=success;
		this.flag = success;
		this.message = message;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
