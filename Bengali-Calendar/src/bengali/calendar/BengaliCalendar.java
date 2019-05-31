/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;

import java.io.File;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Humayun
 */
public class BengaliCalendar extends Application {
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        Text text = new Text();
        text.setText("না");
        Font font = Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 20);
        text.setFont(font);
        
        
        StackPane root = new StackPane();
        root.getChildren().add(text);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
