package com.ronak.gui;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class StatusPanel extends Panel {

    //2 Label to show in that score and time
    private Label timeLabel;

    private int seconds = 0;

    //for calculate time
    private Timer timer;

    public StatusPanel() {

        setLayout(new FlowLayout());

        timeLabel = new Label("Time: 00:00");

        add(timeLabel);
    }

    //start time
    public void startTimer() {
        //if timer is already running then stop it
        if(timer != null){
            timer.cancel();
        }

        seconds = 0;
        timer = new Timer();

        //calculate time at each second
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                seconds++;

                int min = seconds / 60;
                int sec = seconds % 60;

                timeLabel.setText(
                        String.format("Time: %02d:%02d", min, sec)
                );
            }

        },1000,1000);
    }


    public String getTime(){

        int min = seconds / 60;
        int sec = seconds % 60;

        return String.format("%02d:%02d",min,sec);
    }

    public  int getSeconds(){
        return seconds;
    }
}