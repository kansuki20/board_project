package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    
    @GetMapping("/members")
    public String memberList(Model model) {
	List<MemberVO> members = memberService.getAllMember();
	model.addAttribute("members", members);
	return "members/memberList";
    }
    @GetMapping("/joinMember")
    public String joinMemberForm() {
	return "members/joinMemberForm";
    }
    @PostMapping("/joinMember")
    public String joinMember(@ModelAttribute MemberVO memberVo) {
	memberService.joinMember(memberVo);
	return "redirect:/";
    }
    @ResponseBody @RequestMapping("/login")
    public String login(String id, String pwd, HttpSession session) {
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("id", id);
	map.put("pwd", pwd);
	MemberVO memberVo = memberService.login(map);
	
	session.setAttribute("login_info", memberVo);
	
	return memberVo != null ? "true" : "false";
    }
    @ResponseBody @RequestMapping("/logout")
    public void logout(HttpSession session) {
	session.removeAttribute("login_info");
    }
    @GetMapping("/fixProfileForm")
    public String fixProfileForm() {
	return "members/fixProfile";
    }
    @PostMapping("fixProfile")
    public String fixProfile(String name, String pwd, String email, HttpSession session) {
	MemberVO memberVo = (MemberVO) session.getAttribute("login_info");
	MemberVO memberVoFixed = new MemberVO(memberVo.getId(), pwd, name, email, memberVo.getJoinDate()); 
	memberService.fixMember(memberVoFixed);
	session.removeAttribute("login_info");
	session.setAttribute("login_info", memberVoFixed);
	return "redirect:/";
    }
    @GetMapping("signOut")
    public String signOut(HttpSession session) {
	MemberVO memberVo = (MemberVO) session.getAttribute("login_info");
	memberService.signOut(memberVo.getId());
	session.removeAttribute("login_info");
	return "redirect:/";
    }
}
