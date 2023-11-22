package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.MainControl;

public class MainView extends JFrame{
    public JButton closeButton, startButton, defaultButton, aboutButton;
    public JLabel title, workLabel, breakLabel;
    public JPanel panel;
    public ImageIcon close;
    public JTextField workTextField, breakTextField;
    public JComboBox<String> workComboBox, breakComboBox;

    public MainView(){
        setSize(800, 600);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        GUI();
    }

    public void GUI(){

        panel = new JPanel();
        panel.setBackground(Color.decode("#09C4FB"));

        //----------- Close Button ---------------------------

        close = new ImageIcon(getClass().getResource("../images/close.png"));
        closeButton = new JButton(close);
        closeButton.setBounds(750, 5, 45, 45);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        panel.add(closeButton);
        panel.setLayout(null);

        //----------- Title ---------------------------

        title = new JLabel("Pomodoro Timer");
        title.setBounds(280, 20, 300, 80);
        title.setFont(new Font("Tahoma", Font.BOLD, 32));
        title.setForeground(Color.decode("#09374e"));
        panel.add(title);

        //----------- Work Time section ---------------------------

        workLabel = new JLabel("Work Time");
        workLabel.setBounds(240, 150, 300, 80);
        workLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        workLabel.setForeground(Color.decode("#09374e"));
        panel.add(workLabel);
      
        workTextField = new JTextField();
        workTextField.setBounds(400, 180, 100, 30);
        workTextField.setEditable(false);
        panel.add(workTextField);
             
        workComboBox = new JComboBox<>(new String[]{"10", "20", "30", "Personalizar"});
        workComboBox.setBounds(510, 180, 80, 30);
        panel.add(workComboBox);

        //----------- Break Time section ---------------------------

        breakLabel = new JLabel("Break Time");
        breakLabel.setBounds(240, 220, 300, 80);
        breakLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        breakLabel.setForeground(Color.decode("#09374e"));
        panel.add(breakLabel);

        breakTextField = new JTextField();
        breakTextField.setBounds(400, 250, 100, 30);
        breakTextField.setEditable(false);
        panel.add(breakTextField);

        breakComboBox = new JComboBox<>(new String[]{"5", "10", "15", "Personalizar"});
        breakComboBox.setBounds(510, 250, 80, 30);
        panel.add(breakComboBox);

        //----------- Buttons section ------------------------------

        //-About button---------------------------------------------
        aboutButton = new JButton("About");
        aboutButton.setBounds(340, 420, 140, 40);
        aboutButton.setFont(new Font("Arial", Font.BOLD, 20));
        aboutButton.setBackground(Color.decode("#8a8a8a"));
        aboutButton.setForeground(Color.decode("#ededed"));
        Border aboutButtonbBorder = BorderFactory.createLineBorder(Color.decode("#ccd4d9"));
        aboutButton.setBorder(aboutButtonbBorder);
        panel.add(aboutButton);

        //-Start Button---------------------------------------------
        startButton = new JButton("Start");
        startButton.setBounds(260, 350, 140, 40);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBackground(Color.decode("#02ba05"));
        startButton.setForeground(Color.decode("#ededed"));
        Border startButtonBorder = BorderFactory.createLineBorder(Color.decode("#ededed"));
        startButton.setBorder(startButtonBorder);
        panel.add(startButton);

        //-Default Button---------------------------------------------
        defaultButton = new JButton("Default");
        defaultButton.setBounds(430, 350, 140, 40);
        defaultButton.setFont(new Font("Arial", Font.BOLD, 20));
        defaultButton.setBackground(Color.decode("#ba2d02"));
        defaultButton.setForeground(Color.decode("#ededed"));
        Border defaultButtonBorder = BorderFactory.createLineBorder(Color.decode("#ededed"));
        defaultButton.setBorder(defaultButtonBorder);
        panel.add(defaultButton);


        add(panel);
    }


    public static void main(String[] args) {
        MainView mainView = new MainView();
        MainControl mainControl = new MainControl(mainView);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.setVisible(true);
    }
}
