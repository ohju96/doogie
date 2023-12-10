package com.mypet.doogie.member.ui;

import com.mypet.doogie.common.application.CustomResponseUtils.CustomResponse;
import com.mypet.doogie.member.command.application.MemberService;
import com.mypet.doogie.member.command.domain.Request.RegisterRequest;
import com.mypet.doogie.member.query.RegisterResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mypet.doogie.common.application.CustomResponseUtils.success;

@Tag(name = "Member", description = "멤버 관리 API")
@RestController
@RequestMapping("/api/auth/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<CustomResponse<RegisterResponse>> createMember(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(success(memberService.createMember(registerRequest)));
    }

    @GetMapping("/login")
    public String authenticate() {
        return "login";
    }
}
