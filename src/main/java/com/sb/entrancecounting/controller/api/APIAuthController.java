package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.dto.APIDataResponse;
import com.sb.entrancecounting.dto.AdminRequest;
import com.sb.entrancecounting.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@Deprecated
//@RestController
//@RequestMapping("/api")
public class APIAuthController {

    @PostMapping("/sign-up")
    public APIDataResponse<String> signUp(@RequestBody AdminRequest adminRequest) {
        return APIDataResponse.empty();
    }

    @PostMapping("/login")
    public APIDataResponse<String> login(@RequestBody LoginRequest loginRequest) {
        return APIDataResponse.empty();
    }

}
