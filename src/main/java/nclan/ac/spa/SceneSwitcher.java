package nclan.ac.spa;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;

public class SceneSwitcher {
    private static Stage primaryStage;
    private static StackPane contentArea;

    private static Label txtMessage;

    public static void setMessageField(Label field) {
        txtMessage = field;
    }

    public static void displayError(String message) {
        if (txtMessage != null) {
            txtMessage.setText(message);
            // Optional: style it red for errors
            txtMessage.setStyle("-fx-text-fill: red;");
        }
    }

    public static void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Encountered");
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Create the icon and set it as the dialog's graphic
        FontIcon icon = new FontIcon("far-sad-cry");
        icon.setIconSize(40);
        icon.setIconColor(Color.RED);
        alert.setGraphic(icon);

        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();

// Removes everything: title, icon, and the OS close button
        dialogStage.initStyle(StageStyle.TRANSPARENT);

// Ensure the DialogPane itself has a nice border or shadow in CSS
// so it doesn't blend into the background.
        alert.getDialogPane().setStyle("-fx-border-color: #2d3436; -fx-border-width: 2;");
        // Need this code because the app hides the normal window decorators
        // Get the Window of the dialog and cast it to a Stage
        //Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        // Add your custom logo to the dialog's title bar
        //dialogStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/college/app/logo.png")));

        alert.showAndWait(); // This stops the program flow until the user clicks OK
    }

    // Call this once in your MainApp start method
  public static void setStage(Stage stage) {
       primaryStage = stage;
   }
    public static void setContentArea(StackPane cArea) {
        contentArea = cArea;
    }

    public static void changeCenter(String fxmlFile) {
        try {
            // Load the new FXML file from the resources folder
            Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFile));
            contentArea.getChildren().setAll(root);
        } catch (IOException e) {
            System.err.println("Could not load FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }

    public static void changeScene(String fxmlFile) {
        try {
            // Load the new FXML file from the resources folder
            Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFile));

            // If a scene doesn't exist, create one; otherwise, swap the root
            if (primaryStage.getScene() == null) {
                primaryStage.setScene(new Scene(root, 800, 600));
            } else {
                primaryStage.getScene().setRoot(root);
            }

            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Could not load FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}