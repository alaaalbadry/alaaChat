package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author ALaa
 */
public class MyChat extends Application {

 
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        stage.setTitle("Chat App");
        FXMLController controller = new FXMLController();
        controller.setStage(stage);
        loader.setController(controller);
        Parent root = loader.load(getClass().getResource("chat.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }

}
