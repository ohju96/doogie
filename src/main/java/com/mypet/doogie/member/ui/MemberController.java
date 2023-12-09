package com.mypet.doogie.member.ui;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Member", description = "멤버 관리 API")
@RestController
@RequestMapping("/api/auth/members")
public class MemberController {

    @GetMapping("/register")
    public String createMember() {
        return "register";
    }

    @GetMapping("/login")
    public String authenticate() {
        return "login";
    }
}
