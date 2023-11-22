package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Alarm;
import view.BreakTimeView;
import view.MainView;
import view.WorkTimeView;

public class WorkTimeControl implements ActionListener {
    WorkTimeView wv;
    Timer timer;
    boolean paused = false;
    int h, m, s = 5;

    public WorkTimeControl(WorkTimeView wv) {
        this.wv = wv;
        timer = new Timer(1000, acciones);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == wv.button_pause_continue) {
            if (!paused) {
                timer.stop();
            } else {
                timer.start();
            }
            paused = !paused;
        }
        if (e.getSource() == wv.button_skip) {
            nextWindow();
        }
        if (e.getSource() == wv.button_volver) {
            timer.stop();
            wv.setVisible(false);
            MainView mv = new MainView();
            MainControl mc = new MainControl(mv);
            mv.panel.setVisible(true);
        }
    }

    private ActionListener acciones = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {            
            --s;
            if(s==0){
                if (m > 0) {
                    s = 59;
                    --m;
                }
            }
            if(m==0){
                if (h > 0) {
                    m = 59;
                    --h;
                }
            }
            wv.label_time.setText(actualizarLabel());
            if (s==0&&m==0&&h==0) {
                Alarm.alarm_tempo();
                nextWindow();
            }
        }
        
    };

    private String actualizarLabel() {
        String tiempo = "";
        
        if (h < 10) {
            tiempo = "0" + h + ":";
        } else {
            tiempo = h + ":";
        }

        if (m < 10) {
            tiempo += "0" + m + ":";
        } else {
            tiempo += m + ":";
        }

        if (s < 10) {
            tiempo += "0" + s;
        } else {
            tiempo += s;
        }
        
        return tiempo;
    }

    public void nextWindow() {
        timer.stop();
        MainView mv = new MainView();
        MainControl mc = new MainControl(mv);
        mv.getContentPane().removeAll();
        mv.add(new BreakTimeView());
        mv.revalidate();
    }

}
