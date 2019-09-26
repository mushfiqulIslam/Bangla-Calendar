/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengali.calendar;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 *
 * @author mushfiqul
 */
public class CalendarViewController{
    int year;
    int month;
    int day;
    int [] bangla;
    
    final char[] bn ={'০','১','২','৩','৪','৫','৬','৭','৮','৯'};
    
    //accessing year
    @FXML private Label yar;
    
    //accessing month
    @FXML private Label mnt;
    final String [] months = {"বৈশাখ", "জ্যৈষ্ঠ", "আষাঢ়", "শ্রাবণ", "ভাদ্র", "আশ্বিন", "কার্তিক", "অগ্রহায়ণ",
        "পৌষ", "মাঘ", "ফাল্গুন", "চৈত্র"};
    final int [] mntLE = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final int [] mntLB = {31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 30, 30};
    
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
    
    //initializing all the values to load on the frame
    @FXML private void initialize(){
        //Getting local date as a string and spliting it into corresponding values
        String today = LocalDate.now().toString();
        String [] s = today.split("-");
        year = Integer.parseInt(s[0]);
        month = Integer.parseInt(s[1]);
        day = Integer.parseInt(s[2]);
        //getting the right bangla year and adding it into the frame
        populateYear(year, month);
        bangla = populateMonth(year, month, day);
        populateDays(bangla[0], bangla[1], year, month, day);
    }
    
    
    
    @FXML protected void leftButton(ActionEvent event){
        if(month <=1){
            year--;
            month = 12;  
        }
        else
            month--;
        
        if(bangla[0]==1)
            populateYear(year, month);
        bangla = populateMonth(year, month, 20);
        populateDays(bangla[0], bangla[1], year, month, 20);
        
    }
    
    @FXML protected void rightButton(ActionEvent event){
        if(month >=12){
            year++;
            month = 1;
        }
        else
            month++;
           
        if(bangla[0]==12)
            populateYear(year, month);
        bangla = populateMonth(year, month, 20);
        populateDays(bangla[0], bangla[1], year, month, 20);
           
           
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
            switch (start) {
                case 1:
                    populateFirst(banglamonth, engyear);
                    break;
                case 2:
                    populateSecond(banglamonth, engyear);
                    break;
                case 3:
                    populateThird(banglamonth, engyear);
                    break;
                case 4:
                    populateFourth(banglamonth, engyear);
                    break;
                case 5:
                    populateFifth(banglamonth, engyear);
                    break;
                case 6:
                    populateSixth(banglamonth, engyear);
                    break;
                case 7:
                    populateSeventh(banglamonth, engyear);
                    break;
                default:
                    break;
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
    
    //finding the exact week name of the day
    private int FindWeek(String s){
        String [] week = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
        for(int i=0;i<week.length;i++){
            if(s.equals(week[i]))
                return i+1;
        }
        return 0;
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
        mon4.setText("");
        tue4.setText("");
        wed4.setText("");
        thu4.setText("");
        fri4.setText("");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            mon4.setText("৩১");
        }
    }
    
    //adding days value from sunday to the label
    private void populateSecond(int banglamonth, int engyear) {
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
        sat0.setText("");
        sun0.setText("১");
        mon0.setText("২");
        tue0.setText("৩");
        wed0.setText("৪");
        thu0.setText("৫");
        fri0.setText("৬");
        sat1.setText("৭");
        sun1.setText("৮");
        mon1.setText("৯");
        tue1.setText("১০");
        wed1.setText("১১");
        thu1.setText("১২");
        fri1.setText("১৩");
        sat2.setText("১৪");
        sun2.setText("১৫");
        mon2.setText("১৬");
        tue2.setText("১৭");
        wed2.setText("১৮");
        thu2.setText("১৯");
        fri2.setText("২০");
        sat3.setText("২১");
        sun3.setText("২২");
        mon3.setText("২৩");
        tue3.setText("২৪");
        wed3.setText("২৫");
        thu3.setText("২৬");
        fri3.setText("২৭");
        sat4.setText("২৮");
        sun4.setText("২৯");
        mon4.setText("৩০");
        tue4.setText("");
        wed4.setText("");
        thu4.setText("");
        fri4.setText("");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            tue4.setText("৩১");
        }
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
        sat0.setText("");
        sun0.setText("");
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
        wed4.setText("");
        thu4.setText("");
        fri4.setText("");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            wed4.setText("৩১");
        }
    }
    
    //adding days value from tuesday to the label
    private void populateFourth(int banglamonth, int engyear) {
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
        sat0.setText("");
        sun0.setText("");
        mon0.setText("");
        tue0.setText("১");
        wed0.setText("২");
        thu0.setText("৩");
        fri0.setText("৪");
        sat1.setText("৫");
        sun1.setText("৬");
        mon1.setText("৭");
        tue1.setText("৮");
        wed1.setText("৯");
        thu1.setText("১০");
        fri1.setText("১১");
        sat2.setText("১২");
        sun2.setText("১৩");
        mon2.setText("১৪");
        tue2.setText("১৫");
        wed2.setText("১৬");
        thu2.setText("১৭");
        fri2.setText("১৮");
        sat3.setText("১৯");
        sun3.setText("২০");
        mon3.setText("২১");
        tue3.setText("২২");
        wed3.setText("২৩");
        thu3.setText("২৪");
        fri3.setText("২৫");
        sat4.setText("২৬");
        sun4.setText("২৭");
        mon4.setText("২৮");
        tue4.setText("২৯");
        wed4.setText("৩০");
        thu4.setText("");
        fri4.setText("");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            thu4.setText("৩১");
        }
    }
    
    //adding days value from wednessday to the label
    private void populateFifth(int banglamonth, int engyear) {
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
        sat0.setText("");
        sun0.setText("");
        mon0.setText("");
        tue0.setText("");
        wed0.setText("১");
        thu0.setText("২");
        fri0.setText("৩");
        sat1.setText("৪");
        sun1.setText("৫");
        mon1.setText("৬");
        tue1.setText("৭");
        wed1.setText("৮");
        thu1.setText("৯");
        fri1.setText("১০");
        sat2.setText("১১");
        sun2.setText("১২");
        mon2.setText("১৩");
        tue2.setText("১৪");
        wed2.setText("১৫");
        thu2.setText("১৬");
        fri2.setText("১৭");
        sat3.setText("১৮");
        sun3.setText("১৯");
        mon3.setText("২০");
        tue3.setText("২১");
        wed3.setText("২২");
        thu3.setText("২৩");
        fri3.setText("২৪");
        sat4.setText("২৫");
        sun4.setText("২৬");
        mon4.setText("২৭");
        tue4.setText("২৮");
        wed4.setText("২৯");
        thu4.setText("৩০");
        fri4.setText("");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            fri4.setText("৩১");
        }
    }
    
    //adding days value from thursday to the label
    private void populateSixth(int banglamonth, int engyear) {
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
        sat0.setText("");
        sun0.setText("");
        mon0.setText("");
        tue0.setText("");
        wed0.setText("");
        thu0.setText("১");
        fri0.setText("২");
        sat1.setText("৩");
        sun1.setText("৪");
        mon1.setText("৫");
        tue1.setText("৬");
        wed1.setText("৭");
        thu1.setText("৮");
        fri1.setText("৯");
        sat2.setText("১০");
        sun2.setText("১১");
        mon2.setText("১২");
        tue2.setText("১৩");
        wed2.setText("১৪");
        thu2.setText("১৫");
        fri2.setText("১৬");
        sat3.setText("১৭");
        sun3.setText("১৮");
        mon3.setText("১৯");
        tue3.setText("২০");
        wed3.setText("২১");
        thu3.setText("২২");
        fri3.setText("২৩");
        sat4.setText("২৪");
        sun4.setText("২৫");
        mon4.setText("২৬");
        tue4.setText("২৭");
        wed4.setText("২৮");
        thu4.setText("২৯");
        fri4.setText("৩০");
        sat5.setText("");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            sat5.setText("৩১");
        }
    }
    
    //adding days value from friday to the label
    private void populateSeventh(int banglamonth, int engyear) {
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
        sat0.setText("");
        sun0.setText("");
        mon0.setText("");
        tue0.setText("");
        wed0.setText("");
        thu0.setText("");
        fri0.setText("১");
        sat1.setText("২");
        sun1.setText("৩");
        mon1.setText("৪");
        tue1.setText("৫");
        wed1.setText("৬");
        thu1.setText("৭");
        fri1.setText("৮");
        sat2.setText("৯");
        sun2.setText("১০");
        mon2.setText("১১");
        tue2.setText("১২");
        wed2.setText("১৩");
        thu2.setText("১৪");
        fri2.setText("১৫");
        sat3.setText("১৬");
        sun3.setText("১৭");
        mon3.setText("১৮");
        tue3.setText("১৯");
        wed3.setText("২০");
        thu3.setText("২১");
        fri3.setText("২২");
        sat4.setText("২৩");
        sun4.setText("২৪");
        mon4.setText("২৫");
        tue4.setText("২৬");
        wed4.setText("২৭");
        thu4.setText("২৮");
        fri4.setText("২৯");
        sat5.setText("৩০");
        sun5.setText("");
        //if we find 31 days month
        if(days==31){
            sun5.setText("৩১");
        }
    }
    
}
