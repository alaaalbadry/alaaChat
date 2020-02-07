
package view;

import controller.Controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author ALaa
 */
public class View implements ViewInt, Initializable {

    @FXML
    private TextField textMsg;

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;
    @FXML
    public VBox vBox;
    String msg;
    public Controller c;

    public View() {
        // this.c = c;
        System.out.println("ana fe view  def");
    }

    @Override
    public void display(String msg) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                HBox hbox = new HBox();
                Text text = new Text(msg + "\n");
                hbox.getChildren().add(text);
                vBox.getChildren().add(hbox);
                System.out.println(msg + "\n");
            }
        });
    }

    public void setImage(ImageView img) {
        this.img.setImage(img.getImage());

    }

    public void setText(String text) {
        this.nameLabel.setText(text);
    }

    @FXML
    void handleTextMsg(ActionEvent event) {
        HBox hbox = new HBox();
        Text text = new Text(textMsg.getText());
        hbox.alignmentProperty().setValue(Pos.TOP_RIGHT);
        ImageView nImg = new ImageView(img.getImage());
        nImg.setFitWidth(40);
        nImg.setFitHeight(20);
        msg = "[" + nameLabel.getText().trim() + "]: " + textMsg.getText().trim() + "";
        textMsg.clear();
        hbox.getChildren().add(new Label(nameLabel.getText()));
        hbox.getChildren().add(text);
        hbox.getChildren().add(nImg);
        hbox.getChildren().add(new Label("   "));
        vBox.getChildren().add(hbox);
        System.out.println("Ana Here");
        if (c == null) {
            System.out.println("Ana Null");
        }
        c.sendMsg(msg);
        System.out.println("ana ba3t elmsg");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            c=new Controller();
        } catch (RemoteException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
