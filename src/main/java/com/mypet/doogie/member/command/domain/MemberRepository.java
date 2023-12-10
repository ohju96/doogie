package com.mypet.doogie.member.command.domain;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(Long id);
    Member save(Member member);
}
