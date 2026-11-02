package dev.project516.jscrape.utils;

import org.jsoup.Jsoup;

public class Parse {

    public String scrape(String URL) {

        if (URL.isBlank() || URL.equals("https://") || URL.equals("https:// ")) {
            return "Empty URL!";
        }

        try {
            return Jsoup.connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .timeout(10_000)
                    .get()
                    .text();
        } catch (Exception e) {
            System.err.println("Failed to fetch: " + e.getMessage());
            return "Failed to fetch - check your URL!";
        }
    }
}
