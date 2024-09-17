package com.example.demo4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AlarmCurrentTime {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public AlarmCurrentTime(){
    }

    public String currentTime() { return dtf.format(now);}
}
