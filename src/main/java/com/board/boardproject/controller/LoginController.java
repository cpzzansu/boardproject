package com.board.boardproject.controller;

import com.board.boardproject.entity.MemberEntity;
import com.board.boardproject.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/member")
    public ResponseEntity<MemberEntity> save(@RequestBody MemberEntity member) {
        MemberEntity registeredMember = memberService.save(member);
        return new ResponseEntity<>(registeredMember, HttpStatus.CREATED);
    }
}
