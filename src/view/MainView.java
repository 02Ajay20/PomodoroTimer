package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainControl;

public class MainView extends JFrame{
    public JButton closeButton;
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
        panel.add(title);

        //----------- Work Time section ---------------------------

        workLabel = new JLabel("Work Time");
        workLabel.setBounds(90, 150, 300, 80);
        workLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(workLabel);
      
        workTextField = new JTextField();
        workTextField.setBounds(250, 180, 100, 30);
        panel.add(workTextField);
             
        workComboBox = new JComboBox<>(new String[]{"10", "20", "30", "Personalizar"});
        workComboBox.setBounds(360, 180, 80, 30);
        panel.add(workComboBox);

        //----------- Break Time section ---------------------------

        breakLabel = new JLabel("Break Time");
        breakLabel.setBounds(90, 250, 300, 80);
        breakLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
        panel.add(breakLabel);

        breakTextField = new JTextField();
        breakTextField.setBounds(250, 280, 100, 30);
        panel.add(breakTextField);

        breakComboBox = new JComboBox<>(new String[]{"5", "10", "15", "Personalizar"});
        breakComboBox.setBounds(360, 280, 80, 30);
        panel.add(breakComboBox);



        add(panel);
    }


    public static void main(String[] args) {
        MainView mainView = new MainView();
        MainControl mainControl = new MainControl(mainView);
        mainView.setVisible(true);
    }
}
