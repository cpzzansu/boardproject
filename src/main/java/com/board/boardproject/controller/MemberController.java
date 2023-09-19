package com.board.boardproject.controller;

import com.board.boardproject.dto.Member;
import com.board.boardproject.entity.MemberEntity;
import com.board.boardproject.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
public class MemberController {

    final MemberService memberService;

     @PostMapping("/member")
     public ResponseEntity<MemberEntity> save(@RequestBody Member member) {
        MemberEntity registeredMember = memberService.save(member);
      return new ResponseEntity<>(registeredMember, HttpStatus.CREATED);
     }
}
