package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.constant.PlaceType;
import com.sb.entrancecounting.dto.APIDataResponse;
import com.sb.entrancecounting.dto.PlaceRequest;
import com.sb.entrancecounting.dto.PlaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
//@RestController
//@RequestMapping("/api")
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceResponse.of(
                1L,
                PlaceType.SPORTS,
                "에이블짐",
                "서울시 서초구 사평대로 371",
                "010-1234-5678",
                30,
                "운영중"
        )));
    }

    @PostMapping("/places")
    @ResponseStatus(HttpStatus.CREATED)
    public APIDataResponse<Void> createPlace(@RequestBody PlaceRequest placeRequest) {
        return APIDataResponse.empty();
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceResponse> getPlace(@PathVariable Long placeId) {
        if (placeId.equals(2L)) {
            return APIDataResponse.of(null);
        }

        return APIDataResponse.of(PlaceResponse.of(
                placeId,
                PlaceType.SPORTS,
                "에이블짐",
                "서울시 서초구 사평대로 371",
                "010-1234-5678",
                30,
                "운영중"
        ));
    }

    @PutMapping("/places/{placeId}")
    public APIDataResponse<Void> modifyPlace(@PathVariable Long placeId, @RequestBody PlaceRequest placeRequest) {
        return APIDataResponse.empty();
    }

    @DeleteMapping("/places/{placeId}")
    public APIDataResponse<Void> removePlace(@PathVariable Long placeId) {
        return APIDataResponse.empty();
    }

}
