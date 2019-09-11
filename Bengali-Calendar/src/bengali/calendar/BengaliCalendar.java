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
import java.time.YearMonth;
import javafx.scene.Parent;
import javafx.scene.text.Font;

/**
 *
 * @author Humayun
 */
public class BengaliCalendar extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        //Setting title to the Stage
        Parent root = FXMLLoader.load(getClass().getResource("calenderView.fxml"));
        Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 30);
        primaryStage.setTitle("বাংলা বর্ষপঞ্জি");
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
