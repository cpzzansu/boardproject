package com.board.boardproject.service;


import com.board.boardproject.common.FileUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class BoardService {

    private FileUtils fileUtils;
    //private final BoardMapper boardMapper;


}
