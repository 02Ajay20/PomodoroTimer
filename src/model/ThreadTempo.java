package model;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.swing.Timer;

public class ThreadTempo {
    // JButton btnPause, btnStart, btnStop;
    // JLabel etiquetaTiempo;
    static private boolean work_or_break = true;
    Timer t;
    int h, m, s;
    public ActionListener acciones = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {            
            actualizarLabel();
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
            if (s==0&&m==0&&h==0) {
                evento_btnStop();
                alarma();
            }
        }
    };
    
    public ThreadTempo(int hours, int minutes, int seconds) {
        h = hours;
        m = minutes;
        s = seconds;
        t = new Timer(1000, acciones);


        // super();
        // setSize(500, 200);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLayout(null);
        
        // crearGUI();
        // setVisible(true);
    }
    
    public String actualizarLabel() {
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
        
        // etiquetaTiempo.setText(tiempo);
        return tiempo;
    }

    public void alarma() {
        for (int i = 0; i <= 4; i++) {
            Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*private void crearGUI() {
        etiquetaTiempo = new JLabel();
        etiquetaTiempo.setBounds(130, 30, 200, 40);
        etiquetaTiempo.setHorizontalAlignment(JLabel.CENTER);
        etiquetaTiempo.setText("00:00:00");
        etiquetaTiempo.setFont(new Font("Tahoma", 0, 45));
        add(etiquetaTiempo);
                
        btnStart = new JButton("Iniciar");
        btnStart.setBounds(50, 90, 120, 30);
        btnStart.addActionListener((e) -> evento_btnStart());
        add(btnStart);
        
        btnPause = new JButton("Pausar");
        btnPause.setBounds(180, 90, 120, 30);
        btnPause.setEnabled(false);
        btnPause.addActionListener((e) -> evento_btnPause());
        add(btnPause);
        
        btnStop = new JButton("Detener");
        btnStop.setBounds(310, 90, 120, 30);
        btnStop.setEnabled(false);
        btnStop.addActionListener((e) -> evento_btnStop());
        add(btnStop);
    }*/
    
    public void evento_btnStart() {
        t.start();
        // btnStart.setEnabled(false);
        // btnStart.setText("Reanudar");
        // btnPause.setEnabled(true);
        // btnStop.setEnabled(true);
    }
    
    public void evento_btnPause() {
        t.stop();
        // btnStart.setEnabled(true);
        // btnPause.setEnabled(false);
    }
    
    private void evento_btnStop() {
        if(t.isRunning()){
            t.stop();
            // btnStart.setEnabled(true);
        }
        // btnStart.setText("Iniciar");
        // btnPause.setEnabled(false);
        // btnStop.setEnabled(false);
        h=0; m=0; s=0;
        actualizarLabel();
    }
    
    public void setWorkOrBreak(boolean state) {
        work_or_break = state;
    }

    // public static void main(String[] args) {
    //     ThreadTempo cr = new ThreadTempo();
    //     cr.alarma();
    // }
}
