package com.bhs.springboot.service;


import com.bhs.springboot.domain.WearStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class WearDataService {

    private static String WEAR_DATA_URL = "https://www.musinsa.com/index.php?m=street&_mon=";

    @PostConstruct
    public void getWearDatas() throws IOException {
        Document doc = Jsoup.connect(WEAR_DATA_URL).get();
        Elements contents = doc.select("ul.snap-article-list.boxed-article-list.article-list.center.list");


        for(Element content : contents) {

            WearStats wearStats = WearStats.builder()
                    .photo(content.select("img").text())
                    .build();

            System.out.println(photo);
            System.out.println(wearStats.toString());
        }

    }

}
