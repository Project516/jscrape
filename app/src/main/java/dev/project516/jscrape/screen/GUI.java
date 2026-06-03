package dev.project516.jscrape.screen;

import dev.project516.jscrape.utils.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    public void start(Stage primaryStage) throws Exception {

        TextField urlField = new TextField();
        urlField.setPromptText("Enter website URL here...");

        Button startButton = new Button("Start");
        Button saveButton = new Button("Save to File");

        TextArea resultArea = new TextArea();
        resultArea.setWrapText(true);
        resultArea.setEditable(false);

        VBox rootLayout = new VBox(15);

        rootLayout.getChildren().addAll(urlField, startButton, resultArea, saveButton);
        rootLayout.setPadding(new Insets(20));

        Parse parser = new Parse();

        startButton.setOnAction(event -> {
            startButton.setDisable(true);
            new Thread(() -> {
                        String userInput = urlField.getText();

                        if (!userInput.startsWith("http")) {
                            userInput = "https://" + userInput;
                        }

                        String scrapedText = parser.scrape(userInput);

                        Platform.runLater(() -> {
                            resultArea.setText(scrapedText);
                            startButton.setDisable(false);
                            saveButton.setDisable(false);
                        });
                    })
                    .start();
        });

        saveButton.setOnAction(event -> {
            String textToSave = resultArea.getText();
            String fileName = urlField.getText();

            Save.saveFile(fileName, textToSave);
        });

        Scene scene = new Scene(rootLayout, 600, 400);

        primaryStage.setScene(scene);

        primaryStage.setTitle("JScrape GUI");

        primaryStage.show();

        saveButton.setDisable(true);
    }
}
