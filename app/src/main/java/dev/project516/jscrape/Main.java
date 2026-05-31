package dev.project516.jscrape;

import dev.project516.jscrape.utils.Parse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url;

        Parse parse = new Parse();

        System.out.print("Enter site url: https://");

        Scanner scan = new Scanner(System.in);

        url = scan.nextLine();

        System.out.println(parse.scrape("https://" + url));

        scan.close();
    }
}
