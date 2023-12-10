package com.mypet.doogie.member.command.domain.Request;

import com.mypet.doogie.member.command.domain.Provider;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(

        @Nullable
        @Schema(description = "프로바이더가 제공하는 유저의 아이디, provider가 있을 때만 존재", example = "239fe92jf0ewf2390")
        String providerId,

        @Schema(description = "프로바이더", example = "GOOGLE, KAKAO, NONE")
        Provider provider,

        @Schema(title = "이메일", description = "이메일 가입자를 위한 컬럼", example = "test@test.com")
        String Email,

        @Schema(description = "회원가입할 유저의 닉네임", example = "doogie")
        @NotNull
        String nickname,

        @Schema(description = "회원가입할 유저의 이름", example = "두기")
        String name,

        @Schema(description = "회원가입할 유저의 비밀번호", example = "12345678")
        String password
) {
}
