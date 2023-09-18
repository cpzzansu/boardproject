package com.board.boardproject.service;

import com.board.boardproject.entity.MemberEntity;
import com.board.boardproject.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class MemberService {

    MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MemberEntity save(MemberEntity member){

        return memberRepository.save(member);
    }
}
