package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mappers.BoardMapper;
import com.example.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardMapper boardMapper;
    
    @Override
    public List<BoardVO> getAllBoard() {
	return boardMapper.getAllBoard();
    }
    
    @Override
    public BoardVO getOneBoard(int boardId) {
	return boardMapper.getOneBoard(boardId);
    }

    @Override
    public void createBoard(BoardVO boardVo) {
	boardMapper.createBoard(boardVo);
    }

    @Override
    public void updateBoard(int boardId, String title, String content) {
	boardMapper.updateBoard(boardId, title, content);
    }

    @Override
    public void deleteBoard(int boardId) {
	boardMapper.deleteBoard(boardId);
    }

    @Override
    public Integer checkBoard(String memberId, int boardId) {
	return boardMapper.checkBoard(memberId, boardId);
    }

}
