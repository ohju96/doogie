package com.mypet.doogie.member.query;

import com.mypet.doogie.member.command.domain.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record RegisterResponse(
        @Schema(description = "회원가입한 멤버의 닉네임", example = "doogie")
        String nickname,

        @Schema(description = "회원가입한 멤버의 이름", example = "오주현")
        String name
) {
        public static RegisterResponse of(Member member) {
                return RegisterResponse.builder()
                        .nickname(member.getNickname())
                        .name(member.getName())
                        .build();
        }
}
