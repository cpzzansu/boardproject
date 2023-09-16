package com.board.boardproject.service;


import com.board.boardproject.common.FileUtils;
import com.board.boardproject.dto.Board;
import com.board.boardproject.dto.BoardFile;
import com.board.boardproject.dto.BoardResponseDTO;
import com.board.boardproject.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class BoardService {

    private FileUtils fileUtils;
    private final BoardMapper boardMapper;

    /**
     * 게시글 등록 메서드
     * @param board 게시글 내용
     * @param files 게시글 사진
     * @throws Exception
     */
    public void addBoard(Board board, List<MultipartFile> files) throws Exception {

        boardMapper.addBoard(board);

        List<BoardFile> list = fileUtils.parseFileInfo(board.getBoardCode(), files);

        if(!CollectionUtils.isEmpty(list)){
            boardMapper.addBoardFileList(list);
        }
    }

    /**
     * 메인화면에서 요청할 게시물 전체 조회 메서드
     * @return 응답보낼 게시판의 객체 리스트
     * @throws Exception
     */
    public List<BoardResponseDTO> getBoard() throws Exception{
        // 클라이언트로 응답보낼 게시판의 객체 리스트
        List<BoardResponseDTO> boardResponseDTOList = new ArrayList<>();
        // 모든 게시물 리스트
        List<Board> boardList = boardMapper.getBoard();
        // 모든 게시물의 코드로 각 게시물에 해당하는 정보를 응답보낼 객체 리스트에 담음
        for(Board board : boardList){
            // 게시물 하나의 정보를 담을 객체 생성
            BoardResponseDTO boardResponseDTO = new BoardResponseDTO();
            // 게시물의 코드 가져오기
            int boardCode = board.getBoardCode();
            // 게시물의 파일 리스트 가져오기
            List<BoardFile> boardFileList = boardMapper.getBoardFile(boardCode);

            // 게시물과 게시물 등록했던 파일의 정보 리스트를 응답보낼 게시판 객체 리스트에 세팅
            boardResponseDTO.setBoard(board);
            boardResponseDTO.setFiles(boardFileList);
            // 클라이언트로 응답보낼 게시판의 객체 리스트에 추가
            boardResponseDTOList.add(boardResponseDTO);
        }
        // 응답보낼 게시판 객체 리스트를 반환
        return boardResponseDTOList;
    }

}
