package dev.project516.jscrape.screen;

import dev.project516.jscrape.utils.*;
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
                            saveLayout.setDisable(false);
                        });
                    })
                    .start();
        });

        saveButton.setOnAction(event -> {
            new Thread(() -> {
                        String textToSave = resultArea.getText();
                        String fileName = nameSaveFile.getText();

                        Save.saveFile(fileName, textToSave);
                    })
                    .start();

            saveLayout.setDisable(true);
        });

        Scene scene = new Scene(rootLayout, 600, 400);

        // scene.getStylesheets()
        //        .add(Objects.requireNonNull(GUI.class.getResource("style.css")).toExternalForm());

        primaryStage.setScene(scene);

        primaryStage.setTitle("JScrape GUI");

        primaryStage.show();
    }
}
