package com.sb.entrancecounting.service;

import com.sb.entrancecounting.constant.EventStatus;
import com.sb.entrancecounting.dto.EventDto;
import com.sb.entrancecounting.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDto> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) {
        return eventRepository.findEvents(placeId, eventName, eventStatus, eventStartDatetime, eventEndDatetime);
    }

    public Optional<EventDto> getEvent(Long eventId) {
        return eventRepository.findEvent(eventId);
    }

    public boolean createEvent(EventDto eventDto) {
        return eventRepository.insertEvent(eventDto);
    }

    public boolean modifyEvent(Long eventId, EventDto eventDto) {
        return eventRepository.updateEvent(eventId, eventDto);
    }

    public boolean removeEvent(Long eventId) {
        return eventRepository.deleteEvent(eventId);
    }

}
