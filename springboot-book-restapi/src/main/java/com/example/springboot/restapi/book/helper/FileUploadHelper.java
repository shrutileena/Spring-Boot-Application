package com.example.springboot.restapi.book.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String uploadDirectory = "D:\\Eclipse\\workspace\\springboot-book-restapi\\src\\main\\resources\\static\\image\\";

	public boolean uploadFile(MultipartFile file) {
		boolean isUploaded = false;

		try {

			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);

			FileOutputStream fos = new FileOutputStream(uploadDirectory + file.getOriginalFilename());
			fos.write(data);
			
			if(fos != null) {
				isUploaded = true;
			}
			
			fos.close();
			
//			Files.copy(file.getInputStream(), Paths.get(uploadDirectory + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			isUploaded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isUploaded;
	}
}
