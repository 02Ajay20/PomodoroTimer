package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Alarm;
import view.BreakTimeView;
import view.MainView;
import view.WorkTimeView;

public class BreakTimeControl implements ActionListener {
    BreakTimeView bv;
    Timer timer;
    boolean paused = false;
    int h, m, s;

    public BreakTimeControl(BreakTimeView bv, int hours, int minutes) {
        h = hours;
        m = minutes;
        s = 1;

        this.bv = bv;
        timer = new Timer(1000, acciones);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bv.stop_button) {
            if (paused == false) {
                timer.stop();
            } else {
                timer.start();
            }
            paused = !paused;
        }
        if (e.getSource() == bv.skip_button) {
            nextWindow();
        }
        if (e.getSource() == bv.back_button) {
            timer.stop();
            bv.setVisible(false);
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
            bv.break_time.setText(actualizarLabel());
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
        mv.add(new WorkTimeView());
        mv.revalidate();
    }

}
