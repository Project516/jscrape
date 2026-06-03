package dev.project516.jscrape.screen;

import dev.project516.jscrape.utils.Parse;
import javafx.application.Application;
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

        TextArea resultArea = new TextArea();
        resultArea.setWrapText(true);
        resultArea.setEditable(false);

        VBox rootLayout = new VBox(15);

        rootLayout.getChildren().addAll(urlField, startButton, resultArea);
        rootLayout.setPadding(new Insets(20));

        Parse parser = new Parse();

        startButton.setOnAction(event -> {
            String userInput = urlField.getText();

            if (!userInput.startsWith("http")) {
                userInput = "https://" + userInput;
            }

            String scrapedText = parser.scrape(userInput);

            resultArea.setText(scrapedText);
        });

        Scene scene = new Scene(rootLayout, 600, 400);

        primaryStage.setScene(scene);

        primaryStage.setTitle("JScrape GUI");

        primaryStage.show();
    }
}
