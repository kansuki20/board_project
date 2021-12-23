package com.example.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mappers.MemberMapper;
import com.example.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    
    @Override
    public List<MemberVO> getAllMember() {
	return memberMapper.getAllMember();
    }
    @Override
    public void joinMember(MemberVO memberVo) {
	memberMapper.joinMember(memberVo);
    }
    @Override
    public MemberVO login(HashMap<String, String> map) {
	return memberMapper.login(map);
    }
    @Override
    public void fixMember(MemberVO memberVo) {
	memberMapper.fixMember(memberVo);
    }
    @Override
    public void signOut(String id) {
	memberMapper.signOut(id);
    }
}
