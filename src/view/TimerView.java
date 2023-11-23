package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
// import java.awt.Toolkit;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import controller.TimerControl;

public class TimerView extends JPanel {
    private JLabel timer_title = new JLabel();
    public JLabel timer_time = new JLabel("00:00:00");
    public JButton back_button = new JButton();
    public JButton stop_button = new JButton("Pause");
    public JButton skip_button = new JButton("Skip");

    private JPanel top_panel = new JPanel(null);
    private JPanel center_panel = new JPanel(null);

    public TimerView() {
        setLayout(new BorderLayout());
        top_panel.setPreferredSize(new Dimension(getWidth(), 50));
        workPomodoro();
        //Top
        ImageIcon back_img = new ImageIcon("src/images/back.png");
        back_button.setIcon(back_img);
        
        back_button.setBorderPainted(false);
        back_button.setBounds(10, 1, 48, 48);
        timer_title.setFont(new Font("Arial", Font.PLAIN, 32));
        timer_title.setBounds(220, 0, 200, 50);
        //Center
        timer_time.setBounds(50, 100, 500, 120);
        timer_time.setFont(new Font("Arial", Font.PLAIN, 120));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        timer_time.setBorder(border);

        stop_button.setBounds(120, 280, 150, 70);
        stop_button.setFont(new Font("Arial", Font.BOLD, 24));
        stop_button.setBackground(Color.decode("#FFC9C9"));
        Border stop_border = BorderFactory.createLineBorder(Color.decode("#E03131"));
        stop_button.setBorder(stop_border);

        skip_button.setBounds(320, 280, 150, 70);
        skip_button.setBackground(Color.decode("#B2F2BB"));
        skip_button.setFont(new Font("Arial", Font.BOLD, 24));
        Border skip_border = BorderFactory.createLineBorder(Color.decode("#2F9E44"));
        skip_button.setBorder(skip_border);

        top_panel.add(back_button);
        top_panel.add(timer_title);
        center_panel.add(timer_time);
        center_panel.add(stop_button);
        center_panel.add(skip_button);
        add(top_panel, BorderLayout.NORTH);
        add(center_panel, BorderLayout.CENTER);

        TimerControl bc = new TimerControl(this);
        stop_button.addActionListener(bc);
        skip_button.addActionListener(bc);
        back_button.addActionListener(bc);
    }

    public void workPomodoro() {
        top_panel.setBackground(Color.decode("#7FC940"));
        center_panel.setBackground(Color.decode("#ABDD53"));

        back_button.setBackground(Color.decode("#7FC940"));
        timer_title.setText("Work Time");
    }
    
    public void breakPomodoro() {
        top_panel.setBackground(Color.decode("#117DB2"));
        center_panel.setBackground(Color.decode("#09C4FB"));
        
        back_button.setBackground(Color.decode("#117DB2"));
        timer_title.setText("Break Time");
    }


    // public static void main(String[] args) {
    //     BreakTimeView panel = new BreakTimeView();
    //     JFrame prueba = new JFrame();

    //     prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     prueba.setSize(600, 450);
    //     prueba.setLocationRelativeTo(null);
    //     prueba.setUndecorated(true);
    //     // prueba.setLayout(null);

    //     prueba.add(panel);
        
    //     prueba.setVisible(true);
    // }

}
