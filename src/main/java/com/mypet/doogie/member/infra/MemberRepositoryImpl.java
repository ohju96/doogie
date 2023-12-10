package com.mypet.doogie.member.infra;

import com.mypet.doogie.member.command.domain.Member;
import com.mypet.doogie.member.command.domain.MemberJPARepository;
import com.mypet.doogie.member.command.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJPARepository memberJPARepository;

    @Override
    public Optional<Member> findById(Long memberId) {
        return memberJPARepository.findById(memberId);
    }

    @Override
    public Member save(Member member) {
        return memberJPARepository.save(member);
    }

}
