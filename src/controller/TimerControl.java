package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Alarm;
import view.TimerView;
import view.MainView;
// import view.WorkTimeView;

public class TimerControl implements ActionListener {
    boolean work_or_break = true;
    TimerView timer_view;
    Timer timer;
    boolean paused = false;
    int h, m, s;

    public TimerControl(TimerView timer_view) {
        h = MainView.getWorkHours();
        m = MainView.getWorkMinutes();
        s = 1;

        this.timer_view = timer_view;
        timer = new Timer(1000, acciones);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer_view.stop_button) {
            if (paused == false) {
                timer.stop();
                timer_view.stop_button.setText("Play");
            } else {
                timer.start();
                timer_view.stop_button.setText("Pause");
            }
            paused = !paused;
        }
        if (e.getSource() == timer_view.skip_button) {
            nextWindow();
        }
        if (e.getSource() == timer_view.back_button) {
            timer.stop();
            timer_view.setVisible(false);
            MainControl.objMainView.panel.setVisible(true);
            MainControl.objMainView.remove(timer_view);
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
            timer_view.timer_time.setText(actualizarLabel());
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
        timer_view.timer_time.setText("00:00:00");
        s = 1;
        if (work_or_break) {
            timer_view.breakPomodoro();
            h = MainView.getBreakHours();
            m = MainView.getBreakMinutes();
        } else {
            timer_view.workPomodoro();
            h = MainView.getWorkHours();
            m = MainView.getWorkMinutes();
        }
        work_or_break = !work_or_break;
        timer.start();

        // MainView mv = new MainView();
        // MainControl mc = new MainControl(mv);
        // mv.getContentPane().removeAll();
        // mv.add(new WorkTimeView());
        // mv.revalidate();
    }

}
