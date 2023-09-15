package com.board.boardproject.dto;

import lombok.Data;

@Data
public class Board {

  private int boardCode;
  private String memberEmail;
  private String memberName;
  private String boardContent;
  private String boardRegistTime;
}
