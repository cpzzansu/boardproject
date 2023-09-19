package com.board.boardproject.service;

import com.board.boardproject.dto.Member;
import com.board.boardproject.entity.MemberEntity;
import com.board.boardproject.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class MemberService {

    MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;

    public MemberEntity save(Member member){

        member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));
        member.setMemberRegistTime(LocalDateTime.now());
        member.setMemberUpdateTime(LocalDateTime.now());

        MemberEntity memberEntity = MemberEntity.builder()
                .memberEmail(member.getMemberEmail())
                .memberPw(member.getMemberPw())
                .memberRegistTime(member.getMemberRegistTime())
                .memberUpdateTime(member.getMemberUpdateTime())
                .build();

        return memberRepository.save(memberEntity);
    }
}
