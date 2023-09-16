package com.board.boardproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardResponseDTO {
    private Board board;
    private List<BoardFile> files;
}
