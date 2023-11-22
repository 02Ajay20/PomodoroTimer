package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WorkTimeView extends JFrame {
  
  JLabel label_title, label_time;
  JButton button_pause_continue, button_skip, button_volver;

  public WorkTimeView() {
    setUndecorated(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(600, 450);
    setLayout(null);
    setLocationRelativeTo(null);
    createGUI();

    setVisible(true);
  }

  public void createGUI() {
    button_volver = new JButton("<");
    button_volver.setBounds(20, 20, 50, 40);
    add(button_volver);

    label_title = new JLabel("Work Time");
    label_title.setFont(new Font("Tahoma", Font.PLAIN, 40));
    label_title.setBounds(200, 40, 200, 100);
    add(label_title);

    label_time = new JLabel("00:00:00");
    label_time.setFont(new Font("Tahoma", Font.PLAIN, 80));
    label_time.setBounds(140, 165, 350, 100);
    add(label_time);

    button_pause_continue = new JButton("Pause");
    button_pause_continue.setBounds(180, 320, 70, 50);
    add(button_pause_continue);

    button_skip = new JButton("Skip");
    button_skip.setBounds(350, 320, 70, 50);
    add(button_skip);
  }

  public static void main(String[] args) {
    new WorkTimeView();
  }
}
