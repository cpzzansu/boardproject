package com.board.boardproject.controller;

import com.board.boardproject.entity.MemberEntity;
import com.board.boardproject.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    MemberRepository memberRepository;


}
