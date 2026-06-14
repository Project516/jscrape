package dev.project516.jscrape.screen;

import dev.project516.jscrape.utils.*;
import java.util.Objects;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    public void start(Stage primaryStage) throws Exception {

        TextField urlField = new TextField();
        urlField.setPromptText("Enter website URL here...");

        Button startButton = new Button("Start");
        Button saveButton = new Button("Save to File");
        saveButton.setPrefWidth(150);

        TextArea resultArea = new TextArea();
        resultArea.setWrapText(true);
        resultArea.setEditable(false);
        resultArea.setPromptText("Output will appear here");

        TextField nameSaveFile = new TextField();
        nameSaveFile.setPromptText("Enter the name of the save file");
        nameSaveFile.setPrefWidth(500);

        HBox saveLayout = new HBox();
        saveLayout.setDisable(true);
        saveLayout.getChildren().addAll(saveButton, nameSaveFile);

        VBox rootLayout = new VBox(15);

        rootLayout.getChildren().addAll(urlField, startButton, resultArea, saveLayout);
        rootLayout.setPadding(new Insets(20));

        Parse parser = new Parse();

        // start scraper button
        startButton.setOnAction(event -> {
            startButton.setDisable(true);

            final String urlInput = urlField.getText();
            new Thread(() -> {
                        String userInput = urlInput;

                        if (!userInput.startsWith("http")) {
                            userInput = "https://" + userInput;
                        }

                        String scrapedText = parser.scrape(userInput);

                        Platform.runLater(() -> {
                            resultArea.setText(scrapedText);
                            startButton.setDisable(false);
                            saveLayout.setDisable(false);
                        });
                    })
                    .start();
        });

        // save scrape content
        saveButton.setOnAction(event -> {
            final String textToSave = resultArea.getText();
            String tempFileName = nameSaveFile.getText();

            final String finalFileName;

            if (tempFileName.isBlank()) {
                finalFileName = "scraped_data.txt";
            } else if (!tempFileName.endsWith(".txt")) {
                finalFileName = tempFileName + ".txt";
            } else {
                finalFileName = tempFileName;
            }

            saveLayout.setDisable(true);

            new Thread(() -> {
                        Save.saveFile(finalFileName, textToSave);

                        Platform.runLater(() -> {
                            saveLayout.setDisable(false);
                        });
                    })
                    .start();
        });

        Scene scene = new Scene(rootLayout, 600, 400);

        scene.getStylesheets()
                .add(Objects.requireNonNull(GUI.class.getResource("/style.css")).toExternalForm());

        primaryStage.setScene(scene);

        primaryStage.setTitle("JScrape GUI " + Version.getVersion());

        primaryStage.show();
    }
}
