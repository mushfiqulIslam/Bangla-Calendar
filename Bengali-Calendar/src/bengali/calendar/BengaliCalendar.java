/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;

import java.io.File;
import java.util.Calendar;
import java.net.MalformedURLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Humayun
 */
public class BengaliCalendar extends Application {
    
    GridPane buttons = new GridPane();
    
    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        
        Button lbutton = new Button();
        lbutton.setText("<");
        
        Label label = new Label();
        label.setGraphic(lbutton);
        label.setContentDisplay(ContentDisplay.RIGHT);
        
        label.setText("বৈশাখ");
        label.setFont(Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 30));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setContentDisplay(ContentDisplay.LEFT);
        
        label.setMinWidth(50);
        label.setMinHeight(40);
        
        Text t = new Text();
        t.setText("না");
        Font font = Font.loadFont(new File("Bangla.ttf").toURL().toExternalForm(), 20);
        t.setFont(font);
        
        Button b1 = new Button();
        b1.setText("Button1");
        b1.prefWidthProperty().bind(buttons.widthProperty());
        b1.prefHeightProperty().bind(buttons.heightProperty());
        
        buttons.addColumn(0, label, b1, t);
        
        
        StackPane root = new StackPane();
        root.getChildren().add(buttons);
        
        Scene scene = new Scene(root, 750, 550);
        
        primaryStage.setTitle("বাংলা বর্ষপঞ্জি");
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
