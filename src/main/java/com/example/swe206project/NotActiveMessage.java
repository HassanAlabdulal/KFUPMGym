package com.example.swe206project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NotActiveMessage {
  
  static boolean answer;

  // this method is used to show a confirmation box or window given the title of the box and the desired confirmation message
  public static boolean display(String title, String message) {
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
      window.setTitle(title);
      window.setResizable(false);

      Label label = new Label(message);
      label.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
      Button backButton = new Button("Back");
      backButton.setStyle("-fx-background-radius: 10px; -fx-background-color: #43896B; -fx-cursor: hand;");

      backButton.setOnAction(e -> {
          answer = true;
          window.close();
      });

      VBox layout = new VBox(20);
      layout.getChildren().addAll(label, backButton);
      layout.setAlignment(Pos.CENTER);

      Scene scene = new Scene(layout,375, 175);
      window.setScene(scene);
      window.showAndWait();

      return answer;
  }
}
