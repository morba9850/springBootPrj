package com.bhs.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class WeatherStats {



    private int temperature;
    private int rain;

    private String ulray;
    private String weather;
    private String ondo;

    private String weathericon;








}
