package app.forge.twice.animationtest.handlers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;

import java.util.TimerTask;

import app.forge.twice.animationtest.models.Logic;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        h.sendEmptyMessage(555);
    }


    @SuppressLint("HandlerLeak")
    private final Handler h = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 555) {
                Log.d("my", "test");
                Logic.getInstance().update();
            }

        }
    };
}
