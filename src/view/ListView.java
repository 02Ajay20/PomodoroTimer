package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListView extends JPanel {

    public JButton boton_volver;
    public ImageIcon icono_volver;
    public DefaultTableModel model = new DefaultTableModel();
    public JTable table = new JTable(model);
    
    
    public ListView() {
        setLayout(new BorderLayout());
        
        model.addColumn("Date");
        model.addColumn("Work time");
        model.addColumn("Break time");

        table.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(table);

        icono_volver = new ImageIcon("../images/back.png");
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setBounds(5, 300, 45, 45);

        add(boton_volver, BorderLayout.WEST); 
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        GUI();
    }

    public void GUI(){
        String lista[] = {"hola", "1", "2"};

        model.addRow(lista);
    }
}