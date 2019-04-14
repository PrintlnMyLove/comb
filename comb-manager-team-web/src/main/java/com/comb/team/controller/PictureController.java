package com.comb.team.controller;

import java.util.HashMap;
 
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Value;
 
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.ResponseBody;
 
import org.springframework.web.multipart.MultipartFile;

import util.FastDFSClient;
 
 
@Controller
public class PictureController {
	// 动态读取FastdfsURL.properties中url地址,解决硬编码问题
	@Value("${FILE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map uploadPicture(MultipartFile uploadFile){
		try{
		    //此处使用的fastdfs_client Maven工程,安装到本地仓库,并添加依赖可以直接使用(目的导入fastdfs_client.jar)
			//把图片上传到服务器
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
		
			//获得文件的扩展名
			String originalName = uploadFile.getOriginalFilename();
			String ext = originalName.substring(originalName.lastIndexOf(".")+1);
			
			//得到一个图片的地址和文件名
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(),ext);
			//补充完整的URL
			url = IMAGE_SERVER_URL + url;
			
			//kindeditor的官方文档
			//http://kindeditor.net/docs/upload.html
			//使用的图片上传为kindeditor插件,需要返回json串
			//返回Map,通过@ResponseBody转化为json串
			Map resultMap = new HashMap<>();
 
			resultMap.put("error", 0);
			resultMap.put("url", url);
			return resultMap;
			}
                        catch (Exception e) {
			e.printStackTrace();
 
			Map resultMap = new HashMap<>();
			resultMap.put("error", 0);
			resultMap.put("message", "图片上传失败");
			return resultMap;
	        }
        }
}

