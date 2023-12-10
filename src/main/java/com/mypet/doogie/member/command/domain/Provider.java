package com.mypet.doogie.member.command.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Provider {
    KAKAO("KAKAO"),
    GOOGLE("GOOGLE"),
    NONE("NONE");

    private final String value;
}
