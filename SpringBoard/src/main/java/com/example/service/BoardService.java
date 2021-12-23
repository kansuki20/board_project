package com.example.service;

import java.util.List;

import com.example.vo.BoardVO;

public interface BoardService {
    List<BoardVO> getAllBoard();
    BoardVO getOneBoard(int boardId);
    void createBoard(BoardVO boardVo);
    void updateBoard(int boardId, String title, String content);
    void deleteBoard(int boardId);
    Integer checkBoard(String memberId, int boardId);
}
