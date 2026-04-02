package nclan.ac.spa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // This removes the title bar, REMEMBER to have an exit button if you do this!!
        stage.initStyle(StageStyle.UNDECORATED);

        //SceneSwitcher.setStage(stage);


            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/nclan/ac/spa/home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 480);


            // The leading slash starts the search from the root of the resources folderSS
            String cssPath = getClass().getResource("/style.css").toExternalForm();

            scene.getStylesheets().add(cssPath);
            stage.setScene(scene);
            stage.setTitle("Computer Science App");
            stage.setScene(scene);
            stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}