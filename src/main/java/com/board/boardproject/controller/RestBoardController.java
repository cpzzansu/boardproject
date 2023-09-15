package com.board.boardproject.controller;


import com.board.boardproject.dto.Board;
import com.board.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
public class RestBoardController {

  private final BoardService boardService;

  @PostMapping("/board")
  public ResponseEntity<String> addBoard(@RequestParam("boardContent") String boardContent,
                                         @RequestParam("files") List<MultipartFile> files) throws Exception {
    Board board = new Board();
    board.setBoardContent(boardContent);

    //boardService.addBoard(board, files);
   
    return ResponseEntity.ok("파일업로드를 하였습니다.: ");
  }
}
