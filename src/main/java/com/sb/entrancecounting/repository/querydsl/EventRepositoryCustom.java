package com.sb.entrancecounting.repository.querydsl;

import com.sb.entrancecounting.constant.EventStatus;
import com.sb.entrancecounting.dto.EventViewResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface EventRepositoryCustom {
    Page<EventViewResponse> findEventViewPageBySearchParams(
            String placeName,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Pageable pageable
    );
}
