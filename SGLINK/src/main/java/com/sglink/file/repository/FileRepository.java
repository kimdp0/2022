package com.sglink.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.file.entity.FileEntity;

public interface FileRepository  extends JpaRepository<FileEntity, Long>{
	
}
