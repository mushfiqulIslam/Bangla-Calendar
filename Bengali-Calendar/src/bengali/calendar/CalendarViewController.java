/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;
import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.YearMonth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Window;
/**
 *
 * @author mushfiqul
 */
public class CalendarViewController{
    
    //accessing year
    @FXML private Label yar;
    
    //accessing month
    @FXML private Label mnt;
    
    //tracking last day
    private String last = "";
    
    //accessing saterday columns
    @FXML private Label sat0;
    @FXML private Label sat1;
    @FXML private Label sat2;
    @FXML private Label sat3;
    @FXML private Label sat4;
    @FXML private Label sat5;
    
    //accessing sunday columns
    @FXML private Label sun0;
    @FXML private Label sun1;
    @FXML private Label sun2;
    @FXML private Label sun3;
    @FXML private Label sun4;
    @FXML private Label sun5;
    
    //accessing monday columns
    @FXML private Label mon0;
    @FXML private Label mon1;
    @FXML private Label mon2;
    @FXML private Label mon3;
    @FXML private Label mon4;
    @FXML private Label mon5;
    
    //accessing tuesday columns
    @FXML private Label tue0;
    @FXML private Label tue1;
    @FXML private Label tue2;
    @FXML private Label tue3;
    @FXML private Label tue4;
    @FXML private Label tue5;
    
    //accessing wednessday columns
    @FXML private Label wed0;
    @FXML private Label wed1;
    @FXML private Label wed2;
    @FXML private Label wed3;
    @FXML private Label wed4;
    @FXML private Label wed5;
    
    //accessing thursday columns
    @FXML private Label thu0;
    @FXML private Label thu1;
    @FXML private Label thu2;
    @FXML private Label thu3;
    @FXML private Label thu4;
    @FXML private Label thu5;
    
    //accessing friday columns
    @FXML private Label fri0;
    @FXML private Label fri1;
    @FXML private Label fri2;
    @FXML private Label fri3;
    @FXML private Label fri4;
    @FXML private Label fri5;
    
    public CalendarViewController(){
        populate(YearMonth.now());
    }
    
    
    @FXML protected void leftButton(ActionEvent event){
        populate(YearMonth.now());
    }
    
    @FXML protected void rightButton(ActionEvent event) throws MalformedURLException{
        sat0.setText("৫");
        sun1.setText("৫");
        mon2.setText("৫");
        tue3.setText("৫");
        wed4.setText("৫");
        thu5.setText("৫");
        fri3.setText("৫");
        
    }
    
    private void populate(YearMonth yearMonth){
        System.out.println(yearMonth.getYear());
        System.out.println(yearMonth.getMonthValue());
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        System.out.println(calendarDate.getDayOfMonth());
        System.out.println(calendarDate.getDayOfWeek());
    }
    
    
}
