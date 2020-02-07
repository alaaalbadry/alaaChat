
package view;

import chatserver2.ChatServerInt;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ModelImpl;

public class FXMLController implements Initializable {

    Stage stage = new Stage();
    private String name = new String();
    private Image img;
   // ModelImpl m;
    View v;
   // Registry reg;
    public ChatServerInt server;

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public Image getImg() {
        return img;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private ImageView image;

    @FXML
    private TextField nameField;

    
    @FXML
    private void handleChooseButton(ActionEvent event) {
        System.out.println("alaa choose");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (fileChooser != null) {
            Image image1 = new Image(file.toURI().toString());//.toURL()
            //ImageView ip = new ImageView(image1);
            image.setImage(image1);
            // ImageIO.write(image, "jpg", new File("C:\\Users\\Jakub\\Pictures\\test2.jpg"));

        } else {
            Image imag = new Image("download.png");
            setImg(imag);
        }
    }

    @FXML
    private Label errorLabel;

    @FXML
    private void handleYallaButton(ActionEvent event) throws IOException {

        if (!nameField.getText().isEmpty()) {
            System.out.println("alaa yalla");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat2.fxml"));
            System.out.println("ana hena");
            Parent root = loader.load();
            System.out.println("5lst load");
            v = loader.getController();
            v.setImage(image);
            v.setText(nameField.getText());
            stage.setScene(new Scene(root));
             stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Chat2 App");
            stage.show();
        } else {
            // text.setText("error : please enter your name");
            errorLabel.setText("please enter your name");
            System.out.println("error");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
