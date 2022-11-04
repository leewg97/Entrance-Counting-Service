package com.sb.entrancecounting.controller;

import com.querydsl.core.types.Predicate;
import com.sb.entrancecounting.constant.ErrorCode;
import com.sb.entrancecounting.domain.Place;
import com.sb.entrancecounting.dto.PlaceResponse;
import com.sb.entrancecounting.exception.GeneralException;
import com.sb.entrancecounting.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ModelAndView places(@QuerydslPredicate(root = Place.class) Predicate predicate) {
        Map<String, Object> map = new HashMap<>();
        List<PlaceResponse> places = placeService.getPlaces(predicate)
                .stream()
                .map(PlaceResponse::from)
                .toList();

        map.put("places", places);
        return new ModelAndView("place/index", map);
    }

    @GetMapping("/{placeId}")
    public ModelAndView placeDetail(@PathVariable Long placeId) {
        Map<String, Object> map = new HashMap<>();
        PlaceResponse place = placeService.getPlace(placeId)
                .map(PlaceResponse::from)
                .orElseThrow(() -> new GeneralException(ErrorCode.NOT_FOUND));

        map.put("place", place);
        return new ModelAndView("place/detail", map);
    }

}
