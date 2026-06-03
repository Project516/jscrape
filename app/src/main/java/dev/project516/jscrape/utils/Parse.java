package dev.project516.jscrape.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parse {

    public String scrape(String URL) {

        String content = "";

        if (URL.isBlank() || URL.equals("https://") || URL.equals("https:// ")) {
            content = "Empty URL!";
            return content;
        }

        try {

            Document doc = Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .timeout(10_000)
                    .get();

            content = doc.text();

        } catch (Exception e) {
            System.err.println("Failed to fetch: " + e.getMessage());
            content = "Failed to fetch - check your URL!";
            return content;
        }

        return content;
    }
}
