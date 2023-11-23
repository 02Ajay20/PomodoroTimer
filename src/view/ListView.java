package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ListControl;

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
    }

    public void getTimes(String work_time, String break_time) {
        String[] row = {work_time, break_time};
        model.addRow(row);
    }
}