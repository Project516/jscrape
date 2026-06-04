package dev.project516.jscrape;

import static dev.project516.jscrape.utils.Flags.printHelp;

import dev.project516.jscrape.screen.Launcher;
import dev.project516.jscrape.utils.Parse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Parse parse = new Parse();

        if (args.length == 0) {
            Scanner scan = new Scanner(System.in);
            while (true) {

                System.out.print("Enter site url: ");
                String url = scan.nextLine();

                if (url.equalsIgnoreCase("exit") || url.equalsIgnoreCase("quit")) {
                    break;
                }

                if (url.isBlank()) {
                    continue;
                }

                if (!url.startsWith("http")) {
                    url = "https://" + url;
                }

                System.out.println(parse.scrape(url));
            }
            scan.close();
            return;
        }

        if (args[0].equalsIgnoreCase("--help")) {
            printHelp();
        } else if (args[0].equalsIgnoreCase("--gui")) {
            Launcher.launch();
        } else {
            System.out.println("Unknown command. Use --help to see available commands");
        }
    }
}
