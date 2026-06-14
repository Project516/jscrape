package dev.project516.jscrape.utils;

import dev.project516.jscrape.Main;

public class Version {
    public static String getVersion() {
        String appVersion = Main.class.getPackage().getImplementationVersion();

        if (appVersion == null) {
            appVersion = "Unknown";
        }
        return appVersion;
    }
}
