package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkTimeView extends JFrame {
  
  JPanel panel_main, panel_time;
  JLabel label_title, label_time, label_size_grid;
  JButton button_pause_continue, button_skip, button_volver;

  public WorkTimeView() {
    setUndecorated(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 300);
    setLayout(null);
    setLocationRelativeTo(null);
    createGUI();

    setVisible(true);
  }

  public void createGUI() {
    panel_main = new JPanel();
    panel_main.setBounds(100, 100, 300, 140);
    // panel_main.setBackground(Color.BLUE);
    panel_main.setLayout(new GridBagLayout());
    GridBagConstraints obj_position_grid = new GridBagConstraints();

    //panel_main.setBackground(Color.PINK);

    // label_size_grid = new JLabel("");
    // obj_position_grid.gridx = 14;
    // obj_position_grid.gridy = 9;
    // panel_main.add(label_size_grid, obj_position_grid);

    label_title = new JLabel("Work Time");
    label_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
    obj_position_grid.gridx = 6;
    obj_position_grid.gridy = 2;
    obj_position_grid.gridwidth = 4;
    obj_position_grid.gridheight = 1;
    panel_main.add(label_title, obj_position_grid);

    panel_time = new JPanel();
    panel_time.setLayout(new BorderLayout());
    obj_position_grid.gridx = 3;
    obj_position_grid.gridy = 4;
    obj_position_grid.gridwidth = 10;
    obj_position_grid.gridheight = 3;
    // panel_time.setBackground(Color.GREEN);
    panel_main.add(panel_time, obj_position_grid);

    label_time = new JLabel("00:25:00");
    label_time.setFont(new Font("Tahoma", Font.PLAIN, 40));
    panel_time.add(label_time, BorderLayout.CENTER);
    
    // panel_main.add(label_time, obj_position_grid);

    button_pause_continue = new JButton("Pause");
    obj_position_grid.gridx = 3;
    obj_position_grid.gridy = 8;
    obj_position_grid.gridwidth = 4;
    obj_position_grid.gridheight = 1;
    panel_main.add(button_pause_continue, obj_position_grid);

    button_volver = new JButton("<");
    obj_position_grid.gridx = 2;
    obj_position_grid.gridy = 2;
    obj_position_grid.gridwidth = 1;
    obj_position_grid.gridheight = 1;
    // obj_position_grid.fill = GridBagConstraints.NONE;
    panel_main.add(button_volver, obj_position_grid);

    button_skip = new JButton("Skip");
    obj_position_grid.gridx = 9;
    obj_position_grid.gridy = 8;
    obj_position_grid.gridwidth = 4;
    obj_position_grid.gridheight = 1;
    // obj_position_grid.fill = GridBagConstraints.NONE;
    panel_main.add(button_skip, obj_position_grid);

    add(panel_main);
  }

  public static void main(String[] args) {
    new WorkTimeView();
  }
}
