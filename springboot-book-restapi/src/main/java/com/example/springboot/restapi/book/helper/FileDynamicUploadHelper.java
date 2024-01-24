package com.example.springboot.restapi.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileDynamicUploadHelper {

	public final String uploadDirectory = new ClassPathResource("/static/image/").getFile().getAbsolutePath();

	public FileDynamicUploadHelper() throws IOException {
		
	}
	
	public boolean uploadFile(MultipartFile file) {
		boolean isUploaded = false;

		try {

			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);

			FileOutputStream fos = new FileOutputStream(uploadDirectory + File.separator + file.getOriginalFilename());
			fos.write(data);

			if (fos != null) {
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
