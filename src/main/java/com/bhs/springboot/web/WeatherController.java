package com.bhs.springboot.web;


import com.bhs.springboot.domain.WeatherStats;
import com.bhs.springboot.service.WeatherDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class WeatherController {

    private final WeatherDataService weatherDataService;

    @GetMapping("/weather")
    public String weather(Model model) throws IOException {


        List<WeatherStats> weatherStatsList = weatherDataService.getWeatherDatas();

        model.addAttribute("weatherStats", weatherStatsList);

        return "weather";
    }



}