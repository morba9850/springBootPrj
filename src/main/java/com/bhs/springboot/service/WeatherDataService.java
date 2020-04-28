package com.bhs.springboot.service;

import com.bhs.springboot.domain.WeatherStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherDataService {

    private static String WEATHER_DATA_URL = "http://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%98%A4%EB%8A%98%EB%82%A0%EC%94%A8";

    @PostConstruct
    public void getWeatherDatas() throws IOException {


        Document doc = Jsoup.connect(WEATHER_DATA_URL).get();

        Elements contents = doc.select("div.info_data");


            WeatherStats weatherStats = WeatherStats.builder()
                    .country(contents.select("p.info_temperature").text())
                    .todayam(contents.select("p.cast_txt").text())
                    .todaypm(contents.select("span.indicator").text())
                    .build();
            System.out.println(weatherStats.toString());








        }
    }
