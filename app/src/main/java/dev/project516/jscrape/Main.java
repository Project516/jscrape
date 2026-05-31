package dev.project516.jscrape;

import dev.project516.jscrape.utils.Parse;

public class Main {

    public static void main(String[] args) {

        Parse parse = new Parse();

        System.out.println(parse.scrape("https://quotes.toscrape.com/"));

        //System.out.println("Hello, World");


    }
}
