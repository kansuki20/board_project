package com.example.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class MemberVO {
    @JsonProperty
    private String id;
    @JsonProperty
    private String pwd;
    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private Date joinDate;
}
