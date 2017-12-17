/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
/**
 *
 * @author PowerUser
 */
public class PHotos extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("oPen");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                FileChooser chooser = new FileChooser();
                File    file =   chooser.showOpenDialog(primaryStage);
                if(file!= null){
                    ImageView myimage = new ImageView();
                    try {
                        BufferedImage buf = ImageIO.read(file);
                        WritableImage image = SwingFXUtils.toFXImage(buf, null);
                        myimage.setImage(image);
                    } catch (IOException ex) {
                        Logger.getLogger(PHotos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("pMusic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
