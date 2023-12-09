package com.mypet.doogie.member.command.domain;

import com.mypet.doogie.common.domain.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id
    private Long id; // 멤버 아이디
    private String loginId; // 로그인 아이디
    private String nickname; // 닉네임
    private String name; // 이름
    private String provider; // 제공자 :  kakao, google, none
    private String password; // 비밀번호
    private String role; // 권한 : ROLE_USER, ROLE_ADMIN
}
