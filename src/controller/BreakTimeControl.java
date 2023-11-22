package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.alarm;
import view.BreakTimeView;
import view.WorkTimeView;

public class BreakTimeControl implements ActionListener {
    BreakTimeView bv;
    Timer timer;
    boolean paused = false;
    int h, m, s = 5;

    public BreakTimeControl(BreakTimeView bv) {
        this.bv = bv;
        timer = new Timer(1000, acciones);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bv.stop_button) {
            if (paused) {
                timer.stop();
            } else {
                timer.start();
            }
            paused = !paused;
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
                System.out.println(s);
                alarm.alarm_tempo();
                timer.stop();
                WorkTimeView wv = new WorkTimeView();
                wv.setVisible(true);
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
    
}
