package com.mypet.doogie.member.command.domain;

import com.mypet.doogie.common.domain.BaseTimeEntity;
import com.mypet.doogie.member.query.dto.MemberDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
@Schema(name = "member", description = "멤버 상세 정보를 위한 도메인 객체")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(title = "이메일", description = "이메일 가입자를 위한 컬럼", example = "test@test.com")
    private String email;

    @Schema(title = "프로바이더 아이디", description = "provider가 none이 아닌 경우에만 사용됩니다.")
    private String providerId;

    @Enumerated(EnumType.STRING)
    @Schema(title = "제공자", description = "제공자는 kakao, google, none 중 하나여야 합니다.", example = "none")
    private Provider provider;

    @Schema(title = "닉네임", description = "닉네임은 2자 이상 20자 이하로 입력해주세요.", example = "두기")
    @Size(min = 2, max = 20, message = "닉네임은 2자 이상 20자 이하로 입력해주세요.")
    private String nickname;

    @Schema(title = "이름", description = "이름은 2자 이상 10자 이하로 입력해주세요.", example = "두기")
    @Size(min = 2, max = 10, message = "이름은 2자 이상 10자 이하로 입력해주세요.")
    private String name;

    @Schema(title = "비밀번호", description = "비밀번호는 8자 이상 20자 이하로 입력해주세요.", example = "12345678")
    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
    private String password;

    @Schema(title = "권한", description = "권한은 USER, ADMIN 중 하나여야 합니다.", example = "ROLE_USER")
    @Enumerated(EnumType.STRING)
    private Role role;


    public MemberDto toDto() {
        return MemberDto.builder()
                .id(this.id)
                .providerId(this.providerId)
                .nickname(this.nickname)
                .name(this.name)
                .provider(this.provider)
                .password(this.password)
                .role(this.role)
                .build();
    }

}
