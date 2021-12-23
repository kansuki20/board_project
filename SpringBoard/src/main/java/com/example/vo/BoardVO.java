package com.example.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BoardVO {
    @JsonProperty
    private int boardId;
    @JsonProperty
    private String memberId;
    @JsonProperty
    private String title;
    @JsonProperty
    private String content;
    @JsonProperty
    private Date joinDate;
}
