package com.sglink.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sglink.entity.FileBoard;
import com.sglink.repository.FileBoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileBoardService {
	
	private final FileBoardRepository fileboardRepository;
	

}
