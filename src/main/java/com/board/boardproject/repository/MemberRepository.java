package com.board.boardproject.repository;

import com.board.boardproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity findByMemberEmailAndMemberPw(String memberEmail, String memberPw);
}
