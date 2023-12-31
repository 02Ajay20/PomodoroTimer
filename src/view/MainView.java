package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

import controller.MainControl;

public class MainView extends JFrame{
    public JButton closeButton, startButton, defaultButton, aboutButton, reportButton;
    public JLabel title, workLabel, breakLabel;
    public JPanel panel;
    public ImageIcon close;
    public JTextField workTextField, breakTextField;
    public JComboBox<String> workComboBox, breakComboBox;

    public static int work_hours = 0;
    public static int work_minutes = 0;
    public static int break_hours = 0;
    public static int break_minutes = 0;

    public MainView(){
        setSize(600, 450);
        setUndecorated(true);
        setLocationRelativeTo(null);
        GUI();

        setVisible(true);
    }

    public void GUI(){

        panel = new JPanel();
        panel.setBackground(Color.decode("#09C4FB"));

        //----------- Close Button ---------------------------

        close = new ImageIcon("src/images/close.png");
        closeButton = new JButton(close);
        closeButton.setBounds(550, 5, 45, 45);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        panel.add(closeButton);
        panel.setLayout(null);

        //----------- Title ---------------------------

        title = new JLabel("Pomodoro Timer");
        title.setBounds(160, 20, 300, 80);
        title.setFont(new Font("Tahoma", Font.BOLD, 34));
        title.setForeground(Color.decode("#09374e"));
        panel.add(title);

        //----------- Work Time section ---------------------------

        workLabel = new JLabel("Work Time");
        workLabel.setBounds(140, 140, 300, 80);
        workLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        workLabel.setForeground(Color.decode("#09374e"));
        panel.add(workLabel);
      
        workTextField = new JTextField("25");
        workTextField.setBounds(300, 165, 100, 30);
        workTextField.setEnabled(false);
        panel.add(workTextField);
             
        workComboBox = new JComboBox<>(new String[]{"25", "1", "10", "30", "Personalizar"});
        workComboBox.setBounds(410, 165, 80, 30);
        panel.add(workComboBox);

        //----------- Break Time section ---------------------------

        breakLabel = new JLabel("Break Time");
        breakLabel.setBounds(140, 190, 300, 80);
        breakLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        breakLabel.setForeground(Color.decode("#09374e"));
        panel.add(breakLabel);

        breakTextField = new JTextField("5");
        breakTextField.setBounds(300, 215, 100, 30);
        breakTextField.setEnabled(false);
        panel.add(breakTextField);

        breakComboBox = new JComboBox<>(new String[]{"5", "1", "10", "15", "Personalizar"});
        breakComboBox.setBounds(410, 215, 80, 30);
        panel.add(breakComboBox);

        //----------- Buttons section ------------------------------

        //-About button---------------------------------------------
        aboutButton = new JButton("About");
        aboutButton.setBounds(330, 380, 140, 40);
        aboutButton.setFont(new Font("Arial", Font.BOLD, 20));
        aboutButton.setBackground(Color.decode("#8a8a8a"));
        aboutButton.setForeground(Color.decode("#ededed"));
        Border aboutButtonbBorder = BorderFactory.createLineBorder(Color.decode("#ccd4d9"));
        aboutButton.setBorder(aboutButtonbBorder);
        panel.add(aboutButton);

        //-Start Button---------------------------------------------
        startButton = new JButton("Start");
        startButton.setBounds(160, 320, 140, 40);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(Color.decode("#02ba05"));
        startButton.setForeground(Color.decode("#ededed"));
        Border startButtonBorder = BorderFactory.createLineBorder(Color.decode("#ededed"));
        startButton.setBorder(startButtonBorder);
        panel.add(startButton);

        //-Report Button----------------------------------------------
        reportButton = new JButton("Report");
        reportButton.setBounds(160, 380, 140, 40);
        reportButton.setFont(new Font("Arial", Font.BOLD, 20));
        reportButton.setBackground(Color.decode("#422185"));
        reportButton.setForeground(Color.decode("#ededed"));
        Border reportButtonborder = BorderFactory.createLineBorder(Color.decode("#ededed"));
        reportButton.setBorder(reportButtonborder);
        panel.add(reportButton);

        //-Default Button---------------------------------------------
        defaultButton = new JButton("Default");
        defaultButton.setBounds(330, 320, 140, 40);
        defaultButton.setFont(new Font("Arial", Font.BOLD, 20));
        defaultButton.setBackground(Color.decode("#0298ba"));
        defaultButton.setForeground(Color.decode("#ededed"));
        Border defaultButtonBorder = BorderFactory.createLineBorder(Color.decode("#ededed"));
        defaultButton.setBorder(defaultButtonBorder);
        panel.add(defaultButton);


        add(panel);
    }

    public void setTempo() {
        String worktime = workTextField.getText();
        String breaktime = breakTextField.getText();
        int worknum = Integer.parseInt(worktime);
        int breaknum = Integer.parseInt(breaktime);

        if (worknum > 60) {
            work_hours = worknum / 60;
            work_minutes = worknum % 60;
        } else {
            work_minutes = worknum;
        }
        if (breaknum > 60) {
            break_hours = breaknum / 60;
            break_minutes = breaknum % 60;
        } else {
            break_minutes = breaknum;
        }
    }

    public static int getWorkHours() {
        return work_hours;
    }
    public static int getWorkMinutes() {
        return work_minutes;
    }
    public static int getBreakHours() {
        return break_hours;
    }
    public static int getBreakMinutes() {
        return break_minutes;
    }


    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainControl mainControl = new MainControl(mainView);
    }
}
