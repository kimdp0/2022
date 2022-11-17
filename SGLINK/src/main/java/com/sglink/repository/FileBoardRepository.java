package com.sglink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sglink.entity.FileBoard;

@Repository
public interface FileBoardRepository extends JpaRepository<FileBoard, Long> {
	
	
	

}
