package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ThreadTempo;
import view.BreakTimeView;

public class BreakTimeControl implements ActionListener {
    BreakTimeView bv;
    ThreadTempo tempo;

    boolean paused = false;

    public BreakTimeControl(BreakTimeView bv) {
        this.bv = bv;
        tempo = new ThreadTempo(0, 1, 10);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bv.stop_button) {
            if (paused) {
                tempo.evento_btnPause();
            } else {
                tempo.evento_btnStart();
            }
            paused = !paused;
        }

        bv.break_time.setText(tempo.actualizarLabel());
    }
    
}
