package app.forge.twice.animationtest.models;

import android.annotation.SuppressLint;
import android.os.Handler;

import java.util.ArrayList;
import java.util.Timer;

import app.forge.twice.animationtest.handlers.IManager;
import app.forge.twice.animationtest.handlers.MyTimerTask;

public class Manager implements IManager {

    Timer timer;

    private Manager() {
        Logic.getInstance().setManager(this);
    }

    public static Manager getInstance() {
        return ManagerHolder.INSTANCE;
    }

    public static class ManagerHolder {
        private final static Manager INSTANCE = new Manager();
    }

    public ArrayList<Contact> data = new ArrayList<>();

    @SuppressLint("HandlerLeak")
    private final Handler h = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0) {
                if (timer == null) {
                    timer = new Timer();
                    timer.scheduleAtFixedRate(new MyTimerTask(), 0, 1000);
                }

            } else {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
            }

        }
    };

    public void start(Contact contact) {
        Thread t = new Thread(() -> {
            for (int i = 10; i >= 0; i--) {
                contact.name = "Privet" + i;
                h.sendEmptyMessage(0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 0) {
                    h.sendEmptyMessage(1);
                }
            }
        });
        t.start();
    }


}
