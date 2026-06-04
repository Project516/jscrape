package dev.project516.jscrape;

import static dev.project516.jscrape.utils.Flags.printHelp;

import dev.project516.jscrape.screen.Launcher;
import dev.project516.jscrape.utils.Parse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url;

        Parse parse = new Parse();

        Scanner scan = new Scanner(System.in);

        if (args.length == 0) {
            while (true) {

                System.out.print("Enter site url: ");

                url = scan.nextLine();

                if (url.equalsIgnoreCase("exit") || url.equalsIgnoreCase("quit")) {
                    scan.close();
                    return;
                } else if (!url.startsWith("http")) {
                    url = "https://" + url;
                }

                System.out.println(parse.scrape(url));
            }
        }

        if (args[0].equalsIgnoreCase("--help")) {
            printHelp();
        } else if (args[0].equalsIgnoreCase("--gui")) {
            Launcher.launch();
        } else {
            System.out.println("Unknown command. Use --help to see available commands");
        }

        scan.close();
    }
}
