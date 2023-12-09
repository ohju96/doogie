package com.mypet.doogie.common.ui;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Health", description = "서버 상태 체크")
@RestController
@RequestMapping("/defaults/health")
public class HealthCheckController {

    @Operation(summary = "서버 상태 체크")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping
    public String healthCheck() {
        return "OK";
    }
}
