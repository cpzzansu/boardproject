package com.board.boardproject.dto;

import lombok.Data;

@Data
public class BoardFile {
    private int idx;
    private int boardCode;
    private String originalFileName;
    private String storedFilePath;
    private String imageSourcePath;
    private Long fileSize;
    private String creatorEmail;
    private String creatorDatetime;
}
