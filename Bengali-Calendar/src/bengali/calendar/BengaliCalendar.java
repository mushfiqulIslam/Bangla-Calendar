/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.text.Font;

/**
 *
 * @author Humayun
 */
public class BengaliCalendar extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        //Loading the fxml file
        Parent root = FXMLLoader.load(getClass().getResource("calenderView.fxml"));
        //Loading bangla font
        Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 30);
        //setting title
        primaryStage.setTitle("বাংলা বর্ষপঞ্জি");
        //adding scene to the stage to load on the frame
        final Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("custom-font-styles.css").toExternalForm());
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
