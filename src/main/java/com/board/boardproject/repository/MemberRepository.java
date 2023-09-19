package com.board.boardproject.repository;

import com.board.boardproject.dto.Member;
import com.board.boardproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberEmailAndMemberPw(String memberEmail, String memberPw);
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
}
