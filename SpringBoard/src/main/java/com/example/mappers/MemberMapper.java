package com.example.mappers;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.MemberVO;

@Mapper
public interface MemberMapper {
    public List<MemberVO> getAllMember();
    public void joinMember(MemberVO memberVo);
    public MemberVO login(HashMap<String, String> map);
    public void fixMember(MemberVO memberVo);
    public void signOut(String id);
    //회원탈퇴,
}
