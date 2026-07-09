# jscrape

A Java web scraper made with jsoup. GUI made with JavaFX.

## Setup

You need Java 25 to run this. I recommend [Eclipse Temurin](https://adoptium.net/temurin) or [SDKMAN](https://sdkman.io).

#### Make sure Java is on your system path!!!

### Quick Setup

1. Download the latest release from the `Releases` page
2. Run the jar

### Building from source

1. Clone this repository: `git clone https://github.com/Project516/jscrape.git`
2. Run `./gradlew build` to build the project
3. Run the project: `java -jar jscrape/build/libs/jscrape-1.0.0-all.jar`

   You can also use the included helper scripts, which build and run for you:
   - `./run.sh` — builds and runs the CLI
   - `./testGUI.sh` — builds and runs with the `--gui` flag

## Misc

The online Javadoc can be found [here](https://project516.dev/jscrape).