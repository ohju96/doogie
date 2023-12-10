package com.mypet.doogie.member.command.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJPARepository extends JpaRepository<Member, Long> {
}
