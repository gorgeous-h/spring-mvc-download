package com.springmvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadDemo {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/testDownload")
	public void testDownload(HttpServletResponse response) throws IOException{
		String path = "D:/";
		String fileName = "default.txt";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		// response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment;fileName="+URLEncoder.encode(fileName, "UTF-8"));
		
		File file = new File(path, fileName);
		InputStream input = new FileInputStream(file);
		byte[] buff = new byte[input.available()];
		input.read(buff);
		OutputStream output = response.getOutputStream();
		output.write(buff);
		input.close();
		output.close();
	}
	
	@RequestMapping("/downloadEntity")
	public ResponseEntity<byte[]> downloadsEntity() throws Exception{
		String path = "D:/";
		String fileName = "default.txt";
		File file = new File(path, fileName);
		InputStream input = new FileInputStream(file);
		byte[] buff = new byte[input.available()];
		input.read(buff);
		input.close();
		
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.setContentDispositionFormData("attachment", fileName);
		return new ResponseEntity<byte[]>(buff, headers, HttpStatus.OK);
	}
	
}
