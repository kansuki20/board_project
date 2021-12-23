package com.example.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.BoardVO;

@Mapper
public interface BoardMapper {
    public List<BoardVO> getAllBoard();
    public BoardVO getOneBoard(int boardId);
    public void createBoard(BoardVO boardVo);
    public void updateBoard(int boardId, String title, String content);
    public void deleteBoard(int boardId);
    public Integer checkBoard(String memberId, int boardId);
}
