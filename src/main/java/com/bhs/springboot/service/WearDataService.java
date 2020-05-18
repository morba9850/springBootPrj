package com.bhs.springboot.service;


import com.bhs.springboot.domain.WearStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WearDataService {

    private static String WEAR_DATA_URL = "https://www.musinsa.com/index.php?m=street&_mon=";


    public List<WearStats> getWearDatas() throws IOException {

        List<WearStats> wearStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(WEAR_DATA_URL).get();

        Elements contents = doc.select("ul.snap-article-list.boxed-article-list.article-list.center.list");

        for(Element content : contents) {

            WearStats wearStats = WearStats.builder()
                    .photo(content.select("img").attr("src"))
                    .build();

        wearStatsList.add(wearStats);
            System.out.println(wearStats.toString());
        }

        return wearStatsList;

    }

}
