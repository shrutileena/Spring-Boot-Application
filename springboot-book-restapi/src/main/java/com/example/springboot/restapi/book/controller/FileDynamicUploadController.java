package com.example.springboot.restapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springboot.restapi.book.helper.FileDynamicUploadHelper;

@RestController
public class FileDynamicUploadController {

	@Autowired
	private FileDynamicUploadHelper fileDynamicUploadHelper;

	@PostMapping("/upload-file-dynamic")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());

		try {
			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contan file");
			}

			// validation
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Only jpeg content type are allowed");
			}

			// file upload code
			boolean isUploaded = fileDynamicUploadHelper.uploadFile(file);

			if (isUploaded) {
				return ResponseEntity.ok("file is successfully uploaded on path - " + ServletUriComponentsBuilder
						.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again.");
	}
}
