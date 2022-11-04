package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.dto.AdminRequest;
import com.sb.entrancecounting.dto.ApiDataResponse;
import com.sb.entrancecounting.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Spring Data REST 로 API 를 만들어서 당장 필요가 없어진 컨트롤러이기에 deprecated
 */
@Deprecated
//@RequestMapping("/api")
//@RestController
public class ApiAuthController {

    @PostMapping("/sign-up")
    public ApiDataResponse<String> signUp(@RequestBody AdminRequest adminRequest) {
        return ApiDataResponse.empty();
    }

    @PostMapping("/login")
    public ApiDataResponse<String> login(@RequestBody LoginRequest loginRequest) {
        return ApiDataResponse.empty();
    }

}
