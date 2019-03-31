package com.pinyougou.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pinyougou.common.util.FastDFSClient;

import entity.Result;

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	@Value("${FILE_SERVER_URL}")
	private String file_server_url;

	@RequestMapping("/uploadFile")
	public Result uploadFile(MultipartFile file){
		
		String originalFilename = file.getOriginalFilename();//获取文件名
		String extName=originalFilename.substring( originalFilename.lastIndexOf(".")+1);//得到扩展名
		
		try {
			FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extName);
			String url=file_server_url+fileId;//图片完整地址
			return new Result(true, url);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "上传失败");
		}
		
	}
	
	
}
