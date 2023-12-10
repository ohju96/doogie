package com.mypet.doogie.member.query.dto;

import com.mypet.doogie.member.command.domain.Member;
import com.mypet.doogie.member.command.domain.Provider;
import com.mypet.doogie.member.command.domain.Role;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class MemberDto {
    private Long id;
    private String email;
    private Provider provider;
    private String providerId;
    private String nickname;
    private String name;
    private String password;
    private Role role;

    public static MemberDto of(
            Long id,
            String email,
            Provider provider,
            String providerId,
            String nickname,
            String name,
            String password,
            Role role
    ) {
        return MemberDto.builder()
                .id(id)
                .email(email)
                .provider(provider)
                .providerId(providerId)
                .nickname(nickname)
                .name(name)
                .password(password)
                .role(role)
                .build();
    }

    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .email(member.getName())
                .provider(member.getProvider())
                .providerId(member.getProviderId())
                .nickname(member.getNickname())
                .name(member.getName())
                .password(member.getPassword())
                .role(member.getRole())
                .build();
    }

    public Member to() {
        return Member.builder()
                .id(this.getId())
                .email(this.getEmail())
                .provider(this.getProvider())
                .providerId(this.getProviderId())
                .nickname(this.getNickname())
                .name(this.getName())
                .password(this.getPassword())
                .role(this.getRole())
                .build();
    }

}
