package view;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JDialog {
  
  public JLabel label_titulo, label_manuel, label_oscar, label_camilo,
                label_email_manuel, label_email_oscar, label_email_camilo,
                label_icon_manuel, label_icon_oscar, label_icon_camilo,
                label_codigo_manuel, label_codigo_oscar, label_codigo_camilo;
  public JButton button_back;
  public ImageIcon icon_back, icon_oscar, icon_camilo, icon_manuel;
  public JPanel panel_manuel, panel_oscar, panel_camilo, subpanel_manuel, subpanel_oscar, subpanel_camilo;
  
  public About() {
    setUndecorated(true);
    setSize(450, 450);
    setLocationRelativeTo(null);
    setLayout(null);
    createGUI();
    setVisible(true);
  }

  public void createGUI() {
    // LABELS
    
    label_titulo = new JLabel("About");
    label_titulo.setBounds(170, 30, 200, 40);
    label_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));
    add(label_titulo);
    
    
    // Panel Alejo
    
    // Contenedor principal, ordenada los elementos verticalmente
    
    panel_manuel = new JPanel();
    panel_manuel.setLayout(new BoxLayout(panel_manuel, BoxLayout.X_AXIS));
    //panel_manuel.setBackground(Color.red);
    panel_manuel.setBounds(50, 100, 340, 100);
    
    // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
    
    subpanel_manuel = new JPanel();
    subpanel_manuel.setLayout(new BoxLayout(subpanel_manuel, BoxLayout.Y_AXIS));
    subpanel_manuel.setSize(180, 50);
    //subpanel_manuel.setBackground(Color.BLUE);
    
    icon_manuel = new ImageIcon(getClass().getResource("../images/desarrollador.png"));
    label_icon_manuel = new JLabel(icon_manuel);
    
    label_manuel = new JLabel("Manuel Builes");
    label_manuel.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    label_codigo_manuel = new JLabel("2264325 - 2724");
    label_codigo_manuel.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    label_email_manuel = new JLabel("manuel.builes@correounivalle.edu.co");
    label_email_manuel.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    panel_manuel.add(label_icon_manuel);
    
    panel_manuel.add(Box.createHorizontalStrut(10));
    
    subpanel_manuel.add(label_manuel);
    subpanel_manuel.add(label_codigo_manuel);
    subpanel_manuel.add(label_email_manuel);
    
    panel_manuel.add(subpanel_manuel);
    
    add(panel_manuel);
    
    // -----------------------------------------------------------------------------------------------
    
    
    // Panel Oscar
    
    // Contenedor principal, ordenada los elementos verticalmente
    
    panel_oscar = new JPanel();
    panel_oscar.setLayout(new BoxLayout(panel_oscar, BoxLayout.X_AXIS));
    panel_oscar.setBounds(50, 200, 340, 100);
    
    // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
    
    subpanel_oscar = new JPanel();
    subpanel_oscar.setLayout(new BoxLayout(subpanel_oscar, BoxLayout.Y_AXIS));
    subpanel_oscar.setSize(180, 50);
    
    icon_oscar = new ImageIcon(getClass().getResource("../images/desarrollador.png"));
    label_icon_oscar = new JLabel(icon_oscar);
    
    label_oscar = new JLabel("Oscar Hernandez");
    label_oscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    label_codigo_oscar = new JLabel("2264488 - 2724");
    label_codigo_oscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    label_email_oscar = new JLabel("oscar.hernandez@correounivalle.edu.co");
    label_email_oscar.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    panel_oscar.add(label_icon_oscar);
    
    panel_oscar.add(Box.createHorizontalStrut(10));
    
    subpanel_oscar.add(label_oscar);
    subpanel_oscar.add(label_codigo_oscar);
    subpanel_oscar.add(label_email_oscar);
    
    panel_oscar.add(subpanel_oscar);
    
    add(panel_oscar);
    
    // -----------------------------------------------------------------------------------------------
    
    
    // Panel Camilo
    
    // Contenedor principal, ordenada los elementos verticalmente
    
    panel_camilo = new JPanel();
    panel_camilo.setLayout(new BoxLayout(panel_camilo, BoxLayout.X_AXIS));
    panel_camilo.setBounds(50, 300, 340, 100);
    
    // Subpanel que sirve para agrupar la informacion y ordenarla verticalmente
    
    subpanel_camilo = new JPanel();
    subpanel_camilo.setLayout(new BoxLayout(subpanel_camilo, BoxLayout.Y_AXIS));
    subpanel_camilo.setSize(180, 50);
    
    icon_camilo = new ImageIcon(getClass().getResource("../images/desarrollador.png"));
    label_icon_camilo = new JLabel(icon_camilo);
    
    label_camilo = new JLabel("Camilo Garcia");
    label_camilo.setFont(new Font("Tahoma", Font.PLAIN, 15));
    
    label_codigo_camilo = new JLabel("2264484 - 2724");
    label_codigo_camilo.setFont(new Font("Tahoma", Font.PLAIN, 12));
    
    label_email_camilo = new JLabel("camilo.avendano@correounivalle.edu.co");
    label_email_camilo.setFont(new Font("Tahoma", Font.BOLD, 12));
    
    panel_camilo.add(label_icon_camilo);
    
    panel_camilo.add(Box.createHorizontalStrut(10));
    
    subpanel_camilo.add(label_camilo);
    subpanel_camilo.add(label_codigo_camilo);
    subpanel_camilo.add(label_email_camilo);
    
    panel_camilo.add(subpanel_camilo);
    
    add(panel_camilo);
    
    
    // botón back
    
    icon_back = new ImageIcon(getClass().getResource("../images/back.png"));
    button_back = new JButton(icon_back);
    button_back.setBorderPainted(false);
    button_back.setContentAreaFilled(false);
    button_back.setBounds(380, 30, 45, 45);
    add(button_back);
  }

  public static void main(String[] args) {
    new About();
  }
}
