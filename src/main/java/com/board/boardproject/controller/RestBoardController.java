package com.board.boardproject.controller;


import com.board.boardproject.dto.Board;
import com.board.boardproject.dto.BoardResponseDTO;
import com.board.boardproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
public class RestBoardController {

  private final BoardService boardService;

  /**
   * 게시물 등록 매핑 메서드
   * @param boardContent
   * @param files
   * @throws Exception
   */
  @PostMapping("/board")
  public void addBoard(@RequestParam("boardContent") String boardContent,
                                         @RequestParam("files") List<MultipartFile> files) throws Exception {
    Board board = new Board();
    board.setBoardContent(boardContent);

    boardService.addBoard(board, files);

  }

  /**
   * 게시물 전체 조회 매핑 메서드
   * @return
   * @throws Exception
   */
  @GetMapping("/board")
  public List<BoardResponseDTO> getBoard() throws Exception{
    return boardService.getBoard();
  }
}
