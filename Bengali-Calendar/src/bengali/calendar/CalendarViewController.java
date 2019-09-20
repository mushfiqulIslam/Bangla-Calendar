/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;
import java.time.LocalDate;
import java.time.YearMonth;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Window;
/**
 *
 * @author mushfiqul
 */
public class CalendarViewController{
    final char[] bn ={'০','১','২','৩','৪','৫','৬','৭','৮','৯'};
    
    //accessing year
    @FXML private Label yar;
    
    //accessing month
    @FXML private Label mnt;
    final String [] months = {"বৈশাখ", "জ্যৈষ্ঠ", "আষাঢ়", "শ্রাবণ", "ভাদ্র", "আশ্বিন", "কার্তিক", "অগ্রহায়ণ",
        "পৌষ", "মাঘ", "ফাল্গুন", "চৈত্র"};
    final int [] mntLE = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final int [] mntLB = {31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30, 30};
    
    //tracking last day
    private String last;
    
    //accessing saterday columns
    @FXML private Label sat0, sat1, sat2, sat3, sat4, sat5;
    
    //accessing sunday columns
    @FXML private Label sun0, sun1, sun2, sun3, sun4, sun5;
    
    //accessing monday columns
    @FXML private Label mon0, mon1, mon2, mon3, mon4, mon5;
    
    //accessing tuesday columns
    @FXML private Label tue0, tue1, tue2, tue3, tue4, tue5;
    
    //accessing wednessday columns
    @FXML private Label wed0, wed1, wed2, wed3, wed4, wed5;
    
    //accessing thursday columns
    @FXML private Label thu0, thu1, thu2, thu3, thu4, thu5;
    
    //accessing friday columns
    @FXML private Label fri0, fri1, fri2, fri3, fri4, fri5;
    
    @FXML private void initialize(){
        String today = LocalDate.now().toString();
        String [] s = today.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);       
        populateYear(year, month);
        int [] bangla = populateMonth(year, month, day);
        populateDays(bangla[0], bangla[1], year, month, day);
    }
    
    
    
    @FXML protected void leftButton(ActionEvent event){
        //populateYear(YearMonth.now());
    }
    
    @FXML protected void rightButton(ActionEvent event){
        sat0.setText("৫");
        sun1.setText("৫");
        mon2.setText("৫");
        tue3.setText("৫");
        wed4.setText("৫");
        thu5.setText("৫");
        fri3.setText("৫");    
    }
    
    private void populateYear(int year, int month){
        
        if(month>=4){
            year = year - 593;
            yar.setText(BanglaNumber(year));
        }
        
        else{
            year = year - 594;
            yar.setText(BanglaNumber(year));
        }       
    }
    
    private int [] populateMonth(int year, int month, int day){
        int banglamonth = 0;
        int [] bangla = new int[2];
        if(month >= 4){
            for(int i=0;i<month-1;i++){
                day = day + mntLE[i];
            }
            day = day - 103;
            for(int i=0;i<mntLB.length;i++){
                if((day<=30 && banglamonth>5) || (day<=31 && banglamonth<=5)){
                    banglamonth ++;
                    mnt.setText(months[banglamonth-1]);
                    break;
                }
                banglamonth = i+1;
                day = day - mntLB[i];
            }
        }
        
        else{
            for(int i=0;i<month-1;i++){
                if((year%4==0) && (mntLE[i]==28))
                    day = day + 29;
                else
                    day = day + mntLE[i];  
            }
            day = day + 262;
            for(int i=0;i<mntLB.length;i++){
                if((year%4==0) && (i==10) && day<=31){
                    banglamonth ++;
                    mnt.setText(months[banglamonth-1]);
                    break;
                }
                else if((day<=30 && banglamonth>5) || (day<=31 && banglamonth<=5)){
                    banglamonth ++;
                    mnt.setText(months[banglamonth-1]);
                    break;
                }
                banglamonth = i+1;
                if((year%4==0) && (i==10))
                    day = day - 31;
                else
                    day = day - mntLB[i];
            } 
        }
        bangla[0] = banglamonth;
        bangla[1] = day;
        return bangla;
    }
    
    private void populateDays(int banglamonth, int bangladay, int engyear, int engmonth, int engday){
        if(bangladay>engday){
            
        }
        else{
            int firstday = engday - (bangladay-1);
            LocalDate calenderdate = LocalDate.of(engyear, engmonth, firstday);
            int start = FindWeek(calenderdate.getDayOfWeek().toString());
            if(start == 1){
                populateFirst(banglamonth, engyear);
            }
            else if(start == 2){
                
            }
            else if(start == 3){
                populateThird(banglamonth, engyear);
            }
            else if(start == 4){
                
            }
            else if(start == 5){
                
            }
            else if(start == 6){
                
            }
            else if(start == 7){
                
            }
        }
    }
    
    //English to Bangla
    private String BanglaNumber(int num){
        String number = "" + num;
        StringBuilder builder = new StringBuilder();
        
        try{
            for(int i =0;i<number.length();i++){
                if(Character.isDigit(number.charAt(i))){
                    if(((int)(number.charAt(i))-48)<=9){
                        builder.append(bn[(int)(number.charAt(i))-48]);
                    }
                    
                    else{
                      builder.append(number.charAt(i));
                    }
                }
                
                else{
                   builder.append(number.charAt(i));
                }
            }
        }
        
        catch(Exception e){
         //logger.debug("getDigitBanglaFromEnglish: ",e);
         return new String("");
       }

        return builder.toString();
    }
    
    private int FindWeek(String s){
        String [] week = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
        for(int i=0;i<week.length;i++){
            if(s.equals(week[i]))
                return i+1;
        }
        return 0;
    }

    //adding days value from monday to the label
    private void populateThird(int banglamonth, int engyear) {
        //assinging default days limit 30 as all months after no 5 is 30
        int days = 30;
        
        //assinging days limit 31 as all months before no 5 is 31
        if(banglamonth<=5){
            days = 31;
        }
        //if its leapyear setting days limit 31 for 11 no month
        else if((engyear%2==0) && (banglamonth==11)){
            days = 31;
        }
        
        //setting text in right position
        mon0.setText("১");
        tue0.setText("২");
        wed0.setText("৩");
        thu0.setText("৪");
        fri0.setText("৫");
        sat1.setText("৬");
        sun1.setText("৭");
        mon1.setText("৮");
        tue1.setText("৯");
        wed1.setText("১০");
        thu1.setText("১১");
        fri1.setText("১২");
        sat2.setText("১৩");
        sun2.setText("১৪");
        mon2.setText("১৫");
        tue2.setText("১৬");
        wed2.setText("১৭");
        thu2.setText("১৮");
        fri2.setText("১৯");
        sat3.setText("২০");
        sun3.setText("২১");
        mon3.setText("২২");
        tue3.setText("২৩");
        wed3.setText("২৪");
        thu3.setText("২৫");
        fri3.setText("২৬");
        sat4.setText("২৭");
        sun4.setText("২৮");
        mon4.setText("২৯");
        tue4.setText("৩০");
        if(days==31){
            wed4.setText("৩১");
        }
    }
    
    //adding days value from saturday to the label
    private void populateFirst(int banglamonth, int engyear) {
        //assinging default days limit 30 as all months after no 5 is 30
        int days = 30;
        
        //assinging days limit 31 as all months before no 5 is 31
        if(banglamonth<=5){
            days = 31;
        }
        //if its leapyear setting days limit 31 for 11 no month
        else if((engyear%2==0) && (banglamonth==11)){
            days = 31;
        }
        
        //setting text in right position
        sat0.setText("১");
        sun0.setText("২");
        mon0.setText("৩");
        tue0.setText("৪");
        wed0.setText("৫");
        thu0.setText("৬");
        fri0.setText("৭");
        sat1.setText("৮");
        sun1.setText("৯");
        mon1.setText("১০");
        tue1.setText("১১");
        wed1.setText("১২");
        thu1.setText("১৩");
        fri1.setText("১৪");
        sat2.setText("১৫");
        sun2.setText("১৬");
        mon2.setText("১৭");
        tue2.setText("১৮");
        wed2.setText("১৯");
        thu2.setText("২০");
        fri2.setText("২১");
        sat3.setText("২২");
        sun3.setText("২৩");
        mon3.setText("২৪");
        tue3.setText("২৫");
        wed3.setText("২৬");
        thu3.setText("২৭");
        fri3.setText("২৮");
        sat4.setText("২৯");
        sun4.setText("৩০");
        if(days==31){
            mon4.setText("৩১");
        }
    }

    
    
}
