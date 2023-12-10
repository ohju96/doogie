package com.mypet.doogie.member.infra;

import com.mypet.doogie.member.command.application.MemberService;
import com.mypet.doogie.member.command.domain.MemberRepository;
import com.mypet.doogie.member.command.domain.Request.RegisterRequest;
import com.mypet.doogie.member.command.domain.Role;
import com.mypet.doogie.member.query.RegisterResponse;
import com.mypet.doogie.member.query.dto.MemberDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Override
    @Transactional
    public RegisterResponse createMember(RegisterRequest registerRequest) {
        return RegisterResponse.of(memberRepository.save(MemberDto.of(null,
                registerRequest.Email(),
                registerRequest.provider(),
                registerRequest.providerId(),
                registerRequest.nickname(),
                registerRequest.name(),
                registerRequest.password(),
                Role.USER).to()));
    }
}
