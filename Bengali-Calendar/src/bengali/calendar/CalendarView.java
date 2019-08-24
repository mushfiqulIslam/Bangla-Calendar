/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;
import java.io.File;
import java.net.MalformedURLException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javafx.scene.text.Font;
/**
 *
 * @author mushfiqul
 */
public class CalendarView {
    
    private YearMonth yearMonth;
    private Text monthName;
    private VBox view;
    private ArrayList<AnchorPaneNode> Days = new ArrayList<>(35);
    
    public CalendarView(YearMonth yearmonth) throws MalformedURLException{
        
        yearMonth = yearmonth;
        
        monthName = new Text();
        monthName.setText("বৈশাখ, ১৪২৬");
        Font font = Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 30);
        monthName.setFont(font);
        
        //Button to see previous month
        Button previousMonth = new Button("<");
        previousMonth.setMinWidth(40);
        //previousMonth.setOnAction(e -> previousMonth());
        
        //Button to see next month
        Button nextMonth = new Button(">");
        nextMonth.setMinWidth(40);
        //nextMonth.setOnAction(e -> nextMonth());
        
        //Marging the buttons and title
        HBox titleBar = new HBox(previousMonth, monthName, nextMonth);
        titleBar.setSpacing(50);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        
        //Creating a Grid Pane for Calendar Days
        GridPane calendar = new GridPane();
        calendar.setMinSize(600, 400);
        calendar.setGridLinesVisible(true);
        
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(200, 200);
                calendar.add(ap,j,i);
                Days.add(ap);
            }
        }
        
        // Days of the week
        Text[] dayNames = new Text[]{ new Text(" রবিবার"), new Text(" সোমবার"), new Text(" মঙ্গলবার"),
                                        new Text(" বুধবার"), new Text(" বৃস্পতিবার"), new Text(" শুক্রবার"),
                                        new Text(" শনিবার") };
        
        Font dayFont = Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 20);
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(600);
        dayLabels.setGridLinesVisible(true);
        
        int col = 0;
        for (Text txt : dayNames) {
            txt.setFont(dayFont);
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(200, 8);
            ap.setBottomAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        
        
        view = new VBox(titleBar, dayLabels, calendar);
        view.setSpacing(3);
    }
    
    /**
     * 
     * @return view of the calendar
     */
    public VBox getView() {
        return view;
    }

    
}
