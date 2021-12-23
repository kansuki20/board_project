package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.MemberVO;

public interface MemberService {
    List<MemberVO> getAllMember();
    void joinMember(MemberVO memberVo);
    MemberVO login(HashMap<String, String> map);
    void fixMember(MemberVO memberVo);
    void signOut(String id);
}
