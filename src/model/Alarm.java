package model;

import java.awt.Toolkit;

public class Alarm {
    public static void alarm_tempo() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Toolkit.getDefaultToolkit().beep();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
