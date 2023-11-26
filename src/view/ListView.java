package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListView extends JPanel {

    public JButton boton_volver;
    public ImageIcon icono_volver;
    public static DefaultTableModel model = new DefaultTableModel();
    public static JTable table = new JTable(model);
    
    
    public ListView() {
        setLayout(new BorderLayout());
        if (table.getColumnCount() == 0) {
            model.addColumn("Date");
            model.addColumn("Work time");
            model.addColumn("Break time");
        }

        table.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(table);

        icono_volver = new ImageIcon("src/images/back.png");
        boton_volver = new JButton(icono_volver);
        boton_volver.setBackground(Color.white);
        boton_volver.setPreferredSize(new Dimension(35, 35));

        add(boton_volver, BorderLayout.WEST); 
        add(scrollPane, BorderLayout.CENTER);

    }

    public void fillTable(String date_string, String work_time, String break_time) {
        String new_row[] = {date_string, work_time, break_time};

        model.addRow(new_row);
    }
}