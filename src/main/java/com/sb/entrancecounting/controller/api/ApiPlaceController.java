package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.constant.PlaceType;
import com.sb.entrancecounting.dto.ApiDataResponse;
import com.sb.entrancecounting.dto.PlaceRequest;
import com.sb.entrancecounting.dto.PlaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring Data REST 로 API 를 만들어서 당장 필요가 없어진 컨트롤러이기에 deprecated
 */
@Deprecated
//@RequestMapping("/api")
//@RestController
public class ApiPlaceController {

    @GetMapping("/places")
    public ApiDataResponse<List<PlaceResponse>> getPlaces() {
        return ApiDataResponse.of(List.of(PlaceResponse.of(
                1L,
                PlaceType.COMMON,
                "버터짐 역삼",
                "서울시 강남구 역삼동",
                "010-1234-5678",
                300,
                "신장개업"
        )));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/places")
    public ApiDataResponse<Void> createPlace(@RequestBody PlaceRequest placeRequest) {
        return ApiDataResponse.empty();
    }

    @GetMapping("/places/{placeId}")
    public ApiDataResponse<PlaceResponse> getPlace(@PathVariable Long placeId) {
        if (placeId.equals(2L)) {
            return ApiDataResponse.empty();
        }

        return ApiDataResponse.of(PlaceResponse.of(
                placeId,
                PlaceType.COMMON,
                "버터짐 역삼",
                "서울시 강남구 역삼동",
                "010-1234-5678",
                300,
                "신장개업"
        ));
    }

    @PutMapping("/places/{placeId}")
    public ApiDataResponse<Void> modifyPlace(
            @PathVariable Long placeId,
            @RequestBody PlaceRequest placeRequest
    ) {
        return ApiDataResponse.empty();
    }

    @DeleteMapping("/places/{placeId}")
    public ApiDataResponse<Void> removePlace(@PathVariable Long placeId) {
        return ApiDataResponse.empty();
    }

}
