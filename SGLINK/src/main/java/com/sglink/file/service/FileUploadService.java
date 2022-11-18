package com.sglink.file.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sglink.file.entity.FileEntity;
import com.sglink.file.handler.FileHandler;
import com.sglink.file.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {

	private final FileRepository fileRepository;
	@Autowired
	private FileHandler fileHandler;

	
	public void addFile(List<MultipartFile> files, Principal principal) throws Exception {
		// 파일을 저장하고 그 BoardPicture 에 대한 list 를 가지고 있는다
		List<FileEntity> list = fileHandler.parseFileInfo(files,principal);

		if (list.isEmpty()) {
			// TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
		}
		// 파일에 대해 DB에 저장하고 가지고 있을 것
		else {
			List<FileEntity> fileBeans = new ArrayList<>();
			for (FileEntity fileEntity : list) {
				fileBeans.add(fileRepository.save(fileEntity));
			}
		}
	}
	

}
