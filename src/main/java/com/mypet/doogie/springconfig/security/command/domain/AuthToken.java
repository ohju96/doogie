package com.mypet.doogie.springconfig.security.command.domain;

public interface AuthToken <T> {
    final static String AUTHORITIES_TOKEN_KEY = "role";

    boolean validate();

    T getDate();
}
