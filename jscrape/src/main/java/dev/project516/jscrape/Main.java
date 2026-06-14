package dev.project516.jscrape;

import static dev.project516.jscrape.utils.Flags.printHelp;
import static dev.project516.jscrape.utils.Flags.printVersion;

import dev.project516.jscrape.screen.Launcher;
import dev.project516.jscrape.utils.Parse;
import dev.project516.jscrape.utils.Save;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Parse parse = new Parse();

        // cli interactive mode
        if (args.length == 0) {

            printVersion();
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

        // passing arguments
        String firstArg = args[0];

        if (args[0].equalsIgnoreCase("--help")) {
            printHelp();
            return;
        } else if (args[0].equalsIgnoreCase("--gui")) {
            Launcher.launch();
            return;
        } else if (args[0].equalsIgnoreCase("--version")) {
            printVersion();
            return;
        }

        String url = firstArg;
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }

        String scrapedText = parse.scrape(url);

        boolean shouldSave = false;
        String safeUrl = url.replaceAll("[^a-zA-Z0-9]", "_");
        String fileName = safeUrl + ".txt";

        for (int i = 1; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("--save")) {
                shouldSave = true;
                if (i + 1 < args.length && !args[++i].startsWith("-")) {
                    fileName = args[i];
                }
                break;
            }
        }

        if (shouldSave) {
            Save.saveFile(fileName, scrapedText);
        } else {
            System.out.println(scrapedText);
        }
    }
}
