package com.asayama.gwt.angular.client.q;

import com.google.gwt.user.client.Timer;


public class TimerProgress extends Progress {

    protected final Timer timer;
    
    public TimerProgress(String message, Timer timer) {
        super(message);
        this.timer = timer;
    }
    
    @Override
    public void cancel() {
        timer.cancel();
    }
}
