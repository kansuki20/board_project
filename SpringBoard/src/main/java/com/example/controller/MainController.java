package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

@Controller
public class MainController {
    @Autowired
    BoardService boardSevice;
    
    @GetMapping("/")
    public String main(Model model) {
	List<BoardVO> boardList = boardSevice.getAllBoard();
	model.addAttribute("boardList", boardList);
	return "main";
    }
}
