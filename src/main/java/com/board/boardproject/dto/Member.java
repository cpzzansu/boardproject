package com.board.boardproject.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;
import org.hibernate.annotations.BatchSize;


import java.time.LocalDateTime;

@Data
public class Member {
    private long id;
    private String memberEmail;
    private String memberPw;
    private LocalDateTime memberRegistTime;
    private LocalDateTime memberUpdateTime;
}
