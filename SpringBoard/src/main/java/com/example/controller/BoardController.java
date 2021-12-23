package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.BoardService;
import com.example.service.MemberService;
import com.example.vo.BoardVO;
import com.example.vo.MemberVO;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    MemberService memberService;
    
    @GetMapping("/createBoard")
    public String createBoardForm() {
	return "board/createBoard";
    }
    @PostMapping("/createBoard")
    public String createBoard(String title, String content, HttpSession session) {
	BoardVO boardVo = new BoardVO();
	boardVo.setTitle(title);
	boardVo.setContent(content);
	MemberVO memberVo = (MemberVO) session.getAttribute("login_info");
	System.out.println(memberVo);
	System.out.println(memberVo.getId());
	boardVo.setMemberId(memberVo.getId());
	
	boardService.createBoard(boardVo);
	
	return "redirect:/";
    }
    @GetMapping("/content")
    public String boardContent(Model model, @RequestParam Map<String, Object> param) {
	String boardNo = (String) param.get("boardNo");
	BoardVO boardVo = boardService.getOneBoard(Integer.parseInt(boardNo));
	model.addAttribute("boardVo", boardVo);
	
	return "board/boardContent";
    }
    
    @ResponseBody @RequestMapping("/deleteBoard")
    public String deleteBoard(String boardId, HttpSession session) {
	MemberVO memberVo = (MemberVO) session.getAttribute("login_info");
	System.out.println("게시판아이디 : " + boardId);
	System.out.println("객체 : " + memberVo);
	Integer boardIdx = Integer.parseInt(boardId);
	if (memberVo != null) {
	    if (boardService.checkBoard(memberVo.getId(), boardIdx) == boardIdx) {
		boardService.deleteBoard(boardIdx);
		return "true";
	    } else {
		return "not my";
	    }
	} else
	    return "false";
    }
    
    @ResponseBody @RequestMapping("/updateBoardForm")
    public String updateBoardForm(String boardId, HttpSession session, Model model) {
	MemberVO memberVo = (MemberVO) session.getAttribute("login_info");
	Integer boardIdx = Integer.parseInt(boardId);
	if (memberVo != null) {
	    if (boardService.checkBoard(memberVo.getId(), boardIdx) == boardIdx) {
		return "true";
	    } else {
		return "not my";
	    }
	} else
	    return "false";
    }
    @PostMapping("/moveUpdate")
    public String moveUpdate(int boardId, Model model) {
	BoardVO boardVo = boardService.getOneBoard(boardId);
	model.addAttribute("boardVo", boardVo);
	return "board/fixBoard";
    }
    @PostMapping("/updateBoard")
    public String updateBoard(String boardId, String title, String content) {
	boardService.updateBoard(Integer.parseInt(boardId), title, content);
	return "redirect:/content?boardNo=" + boardId;
    }
}
