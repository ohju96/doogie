package com.mypet.doogie.member.command.application;

import com.mypet.doogie.member.command.domain.Request.RegisterRequest;
import com.mypet.doogie.member.query.RegisterResponse;

public interface MemberService {

    RegisterResponse createMember(RegisterRequest registerRequest);

}
