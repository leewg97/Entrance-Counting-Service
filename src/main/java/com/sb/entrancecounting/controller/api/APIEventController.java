package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.constant.EventStatus;
import com.sb.entrancecounting.dto.APIDataResponse;
import com.sb.entrancecounting.dto.EventRequest;
import com.sb.entrancecounting.dto.EventResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class APIEventController {

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents() {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2022, 11, 3, 19, 0, 0),
                LocalDateTime.of(2022, 11, 3, 21, 0, 0),
                0,
                24,
                "스트랩 챙겨요"
        )));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@RequestBody EventRequest eventRequest) {
        return APIDataResponse.empty();
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Long eventId) {
        if (eventId.equals(2L)) {
            return APIDataResponse.empty();
        }

        return APIDataResponse.of(EventResponse.of(
                1L,
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2022, 11, 3, 19, 0, 0),
                LocalDateTime.of(2022, 11, 3, 21, 0, 0),
                0,
                24,
                "스트랩 챙겨요"
        ));
    }

    @PutMapping("/events/{eventId}")
    public APIDataResponse<Void> modifyEvent(@PathVariable Long eventId, @RequestBody EventRequest eventRequest) {
        return APIDataResponse.empty();
    }

    @DeleteMapping("/events/{eventId}")
    public APIDataResponse<Void> removeEvent(@PathVariable Long eventId) {
        return APIDataResponse.empty();
    }


}
