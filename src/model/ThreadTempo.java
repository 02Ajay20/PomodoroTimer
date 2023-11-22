package model;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ThreadTempo extends JFrame {
    JButton btnPause, btnStart, btnStop;
    JLabel etiquetaTiempo;
    Timer t;
    int h, m = 1, s = 10;
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
            if (s==0&&m==0&&h==0) {
                evento_btnStop();
            }
        }
    };
    
    public ThreadTempo() {
        super();
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t = new Timer(1000, acciones);
        setLayout(null);
        
        crearGUI();
        setVisible(true);
    }
    
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

    private void crearGUI() {
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
    }
    
    private void evento_btnStart() {
        t.start();
        btnStart.setEnabled(false);
        btnStart.setText("Reanudar");
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
    }
    
    private void evento_btnPause() {
        t.stop();
        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
    }
    
    private void evento_btnStop() {
        if(t.isRunning()){
            t.stop();
            btnStart.setEnabled(true);
        }
        btnStart.setText("Iniciar");
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
        h=0; m=0; s=0;
        actualizarLabel();
    }
    
    public static void main(String[] args) {
        ThreadTempo cr = new ThreadTempo();
    }
}
