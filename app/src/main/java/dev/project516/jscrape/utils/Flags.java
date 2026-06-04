package dev.project516.jscrape.utils;

public class Flags {
    public static void printHelp() {
        System.out.println("jscrape: A web scraper writen in Java and powered by jsoup");
        System.out.println("Version 1.0.0\n");
        System.out.println("Usage:");
        System.out.println("    java -jar jscrape.jar                     Start interactive CLI mode");
        System.out.println("    java -jar jscrape.jar --gui               Launch GUI application");
        System.out.println("    java -jar jscrape.jar --help              Show this help menu");
        System.out.println("    java -jar jscrape.jar --version           Show jscrape version"); //TODO: add version flag
        System.out.println("    java -jar jscrape.jar <url>               Scrape the URL and print output to console");
        System.out.println("    java -jar jscrape.jar <url> --save        Scrape and auto-save");
        System.out.println("    java -jar jscrape.jar <url> --save <file> Scrape and save to a custom file location");
    }
}
