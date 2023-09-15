package com.board.boardproject.service;


import com.board.boardproject.common.FileUtils;
import com.board.boardproject.dto.Board;
import com.board.boardproject.dto.BoardFile;
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

    public void addBoard(Board board, List<MultipartFile> files) throws Exception {

        boardMapper.addBoard(board);

        List<BoardFile> list = fileUtils.parseFileInfo(board.getBoardCode(), files);

        if(!CollectionUtils.isEmpty(list)){
            boardMapper.addBoardFileList(list);
        }
    }

}
