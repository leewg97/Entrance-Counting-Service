package com.sb.entrancecounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {

    @GetMapping("/")
    public String adminEvents() {
        return "event/index";
    }

    @GetMapping("/{eventId}")
    public String adminEventDetail(@PathVariable Integer eventId) {
        return "event/detail";
    }

}
