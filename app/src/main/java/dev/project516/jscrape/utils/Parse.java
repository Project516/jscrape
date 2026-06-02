package dev.project516.jscrape.utils;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parse {

    public String scrape(String URL) {

        String quotes = "";

        try {

            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .timeout(10_000)
                    .get();

            quotes = doc.text();

        } catch (IOException e) {
            System.err.println("Failed to fetch: " + e.getMessage());
        }

        return quotes;
    }
}
