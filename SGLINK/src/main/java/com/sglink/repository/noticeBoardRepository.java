package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sglink.entity.noticeBoard;

@Repository
public interface noticeBoardRepository extends JpaRepository<noticeBoard, Long>{
	String UPDATE_BOARD = "UPDATE Board"+
			"SET TITLE = :#{#noticeBoardRequestDto.title}, "+
			"CONTENT = :#{#noticeBoardRequestDto.content}, "+
			"UPDATE_TIME = NOW() "+
			"WHERE ID = :#{#noticeBoardRequestDto.id} ";
	
	@Transactional
	@Modifying
	@Query(value = UPDATE_BOARD, nativeQuery = true)
	public int updateBoard(@Param("noticeBoaedRequestDto") NoticeBoardRequestDto noticeBoardRequestDto);
}
