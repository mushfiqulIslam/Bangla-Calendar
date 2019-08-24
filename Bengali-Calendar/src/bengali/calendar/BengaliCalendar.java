/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;

import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.YearMonth;

/**
 *
 * @author Humayun
 */
public class BengaliCalendar extends Application {
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException{
        
        //Setting title to the Stage
        primaryStage.setTitle("বাংলা বর্ষপঞ্জি");
        
        //Adding scene to the stage
        primaryStage.setScene(new Scene(new CalendarView(YearMonth.now()).getView(), 750, 550));
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
