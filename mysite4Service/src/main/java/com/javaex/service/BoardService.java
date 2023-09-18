package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> getBoardList() {
		System.out.println("@Service");
		List<BoardVo> boardList = boardDao.boardSelect();
		return boardList;
	}

	// 게시판 읽기 (조회수 상승)
	public BoardVo boardRead(int no) {
		boardDao.hitUp(no);
		return boardDao.boardRead(no);		
	}

}