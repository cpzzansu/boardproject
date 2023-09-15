package com.board.boardproject.mapper;

import com.board.boardproject.dto.Board;
import com.board.boardproject.dto.BoardFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardMapper {
    void addBoard(Board board);

    void addBoardFileList(List<BoardFile> list);

}
