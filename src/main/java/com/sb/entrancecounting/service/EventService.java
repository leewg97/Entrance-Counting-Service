package com.sb.entrancecounting.service;

import com.querydsl.core.types.Predicate;
import com.sb.entrancecounting.constant.ErrorCode;
import com.sb.entrancecounting.domain.Place;
import com.sb.entrancecounting.dto.EventDto;
import com.sb.entrancecounting.exception.GeneralException;
import com.sb.entrancecounting.repository.EventRepository;
import com.sb.entrancecounting.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final PlaceRepository placeRepository;

    public List<EventDto> getEvents(Predicate predicate) {
        try {
            return StreamSupport.stream(eventRepository.findAll(predicate).spliterator(), false)
                    .map(EventDto::of)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public Optional<EventDto> getEvent(Long eventId) {
        try {
            return eventRepository.findById(eventId).map(EventDto::of);
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean createEvent(EventDto eventDto) {
        try {
            if (eventDto == null) {
                return false;
            }

            Place place = placeRepository.findById(eventDto.placeDto().id()).orElseThrow(
                    () -> new GeneralException(ErrorCode.NOT_FOUND)
            );
            eventRepository.save(eventDto.toEntity(place));
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean modifyEvent(Long eventId, EventDto eventDto) {
        try {
            if (eventId == null || eventDto == null) {
                return false;
            }
            eventRepository.findById(eventId)
                    .ifPresent(event -> eventRepository.save(eventDto.updateEntity(event)));
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean removeEvent(Long eventId) {
        try {
            if (eventId == null) {
                return false;
            }
            eventRepository.deleteById(eventId);
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

}
