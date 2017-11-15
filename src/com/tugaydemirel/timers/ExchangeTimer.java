/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugaydemirel.timers;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Lerimedt
 */
public class ExchangeTimer extends TimerTask {
    
    public void timerRun(){
        Timer tm = new Timer();
        tm.schedule(this, 1000, 1000);
    }

    @Override
    public void run() {
        System.out.println("Timer Çalıştı");
    }

    
}
