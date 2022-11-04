package com.sb.entrancecounting.controller.api;

import com.sb.entrancecounting.constant.EventStatus;
import com.sb.entrancecounting.constant.PlaceType;
import com.sb.entrancecounting.dto.APIDataResponse;
import com.sb.entrancecounting.dto.EventRequest;
import com.sb.entrancecounting.dto.EventResponse;
import com.sb.entrancecounting.dto.PlaceDto;
import com.sb.entrancecounting.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Deprecated
@RequiredArgsConstructor
//@Validated
//@RestController
//@RequestMapping("/api")
public class APIEventController {

    private final EventService eventService;

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents(
            @Positive Long placeId,
            @Size(min = 2) String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    ) {
        return APIDataResponse.of(List.of(EventResponse.of(
                1L,
                PlaceDto.of(
                        1L,
                        PlaceType.SPORTS,
                        "헬스장",
                        "서울시 가나구 다라동",
                        "010-1111-2222",
                        0,
                        null,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                ),
                "오후 운동",
                EventStatus.OPENED,
                LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                0,
                24,
                "마스크 꼭 착용하세요"
        )));
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public APIDataResponse<String> createEvent(@Valid @RequestBody EventRequest eventRequest) {
        boolean result = eventService.createEvent(eventRequest.toDto());
        return APIDataResponse.of(Boolean.toString(result));
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@Positive @PathVariable Long eventId) {
        EventResponse eventResponse = EventResponse.from(eventService.getEvent(eventId).orElse(null));
        return APIDataResponse.of(eventResponse);
    }

    @PutMapping("/events/{eventId}")
    public APIDataResponse<String> modifyEvent(@Positive @PathVariable Long eventId,
                                             @Valid @RequestBody EventRequest eventRequest) {
        boolean result = eventService.modifyEvent(eventId, eventRequest.toDto());
        return APIDataResponse.of(Boolean.toString(result));
    }

    @DeleteMapping("/events/{eventId}")
    public APIDataResponse<String> removeEvent(@Positive @PathVariable Long eventId) {
        boolean result = eventService.removeEvent(eventId);
        return APIDataResponse.of(Boolean.toString(result));
    }


}
