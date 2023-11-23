package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.WorkTimeControl;

public class WorkTimeView extends JPanel {
    
    public JLabel label_title = new JLabel("Work Time");
    public JLabel label_time = new JLabel("00:00:00");
    public JButton button_pause_continue = new JButton("Pause");
    public JButton button_skip = new JButton("Skip");
    public JButton button_volver = new JButton();

    // public JPanel panel = new JPanel(null);

    public WorkTimeView() {
        setLayout(null);
        setBackground(Color.decode("#ABDD53"));
        createGUI();
        
        WorkTimeControl wc = new WorkTimeControl(this, MainView.getWorkHours(), MainView.getWorkMinutes());
        button_pause_continue.addActionListener(wc);
        button_skip.addActionListener(wc);
        button_volver.addActionListener(wc);
    }

    public void createGUI() {
        button_volver.setBounds(20, 20, 48, 48);
        button_volver.setBackground(Color.decode("#ABDD53"));
        button_volver.setBorderPainted(false);
        ImageIcon back_icon = new ImageIcon("src/images/back.png");
        button_volver.setIcon(back_icon);
        add(button_volver);

        label_title.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_title.setBounds(200, 40, 200, 100);
        add(label_title);

        label_time.setFont(new Font("Tahoma", Font.PLAIN, 80));
        label_time.setBounds(140, 165, 350, 100);
        add(label_time);

        button_pause_continue.setBounds(180, 320, 70, 50);
        add(button_pause_continue);

        button_skip.setBounds(350, 320, 70, 50);
        add(button_skip);

    }

    // public static void main(String[] args) {
    //     WorkTimeView panel = new WorkTimeView();
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
