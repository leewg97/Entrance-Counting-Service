package com.sb.entrancecounting.service;

import com.querydsl.core.types.Predicate;
import com.sb.entrancecounting.constant.ErrorCode;
import com.sb.entrancecounting.dto.PlaceDto;
import com.sb.entrancecounting.exception.GeneralException;
import com.sb.entrancecounting.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<PlaceDto> getPlaces(Predicate predicate) {
        try {
            return StreamSupport.stream(placeRepository.findAll(predicate).spliterator(), false)
                    .map(PlaceDto::of)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public Optional<PlaceDto> getPlace(Long placeId) {
        try {
            return placeRepository.findById(placeId).map(PlaceDto::of);
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean createPlace(PlaceDto placeDto) {
        try {
            if (placeDto == null) {
                return false;
            }
            placeRepository.save(placeDto.toEntity());
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean modifyPlace(Long placeId, PlaceDto placeDto) {
        try {
            if (placeId == null || placeDto == null) {
                return false;
            }
            placeRepository.findById(placeId)
                    .ifPresent(place -> placeRepository.save(placeDto.toEntity()));
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean removePlace(Long placeId) {
        try {
            if (placeId == null) {
                return false;
            }
            placeRepository.deleteById(placeId);
            return true;
        } catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

}
