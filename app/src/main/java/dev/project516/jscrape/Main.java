package dev.project516.jscrape;

import dev.project516.jscrape.utils.Parse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url;

        Parse parse = new Parse();

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Enter site url: ");

            url = scan.nextLine();

            if (url.equalsIgnoreCase("exit") || url.equalsIgnoreCase("quit")) {
                break;
            } else if (!url.startsWith("http")) {
                url = "https://" + url;
            }

            System.out.println(parse.scrape(url));
        }

        scan.close();
    }
}
