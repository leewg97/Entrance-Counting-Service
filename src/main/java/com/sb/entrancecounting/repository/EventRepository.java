package com.sb.entrancecounting.repository;

import com.sb.entrancecounting.constant.EventStatus;
import com.sb.entrancecounting.dto.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// TODO : 인스턴스 생성 편의를 위해 임시로 default 사용. repository layer 구현이 완성되면 삭제할 것
public interface EventRepository {

    default List<EventDto> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) {
        return List.of();
    }

    default Optional<EventDto> findEvent(Long eventId) {
        return Optional.empty();
    }

    default boolean insertEvent(EventDto eventDTO) {
        return false;
    }

    default boolean updateEvent(Long eventId, EventDto dto) {
        return false;
    }

    default boolean deleteEvent(Long eventId) {
        return false;
    }

}
