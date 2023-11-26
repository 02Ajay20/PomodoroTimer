package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.TimerView;
import view.ListView;
import view.About;
import view.MainView;

public class MainControl {
    public static MainView objMainView;
    TimerView objTimerView;
    public ListView objListView = new ListView();

    public MainControl(MainView objMainView){
        MainControl.objMainView = objMainView;

        objMainView.closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
                objMainView.dispose();
            }
        });

        objMainView.workComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();
                    if (item.equals("Personalizar")) {
                        objMainView.workTextField.setEnabled(true);
                    } else {
                        objMainView.workTextField.setEnabled(false);
                        objMainView.workTextField.setText(item);
                    }
                }
            }
        });

        objMainView.breakComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String item = (String) e.getItem();
                    if (item.equals("Personalizar")) {
                        objMainView.breakTextField.setEnabled(true);
                    } else {
                        objMainView.breakTextField.setEnabled(false);
                        objMainView.breakTextField.setText(item);
                    }
                }
            }
        });

        objMainView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objMainView.setTempo();
                
                objTimerView = new TimerView();
                objMainView.panel.setVisible(false);
                objMainView.add(objTimerView);
                objTimerView.setVisible(true);

                //Fill table of report
                // objListView = new ListView();
                Date date_regist = new Date();
                SimpleDateFormat format_date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date_text = format_date.format(date_regist);
                objListView.fillTable(date_text,objMainView.workTextField.getText(), objMainView.breakTextField.getText());
            }
        });

        objMainView.defaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objMainView.workComboBox.setSelectedItem("25");
                objMainView.breakComboBox.setSelectedItem("5");
            }
        });

        objMainView.reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ListView listview = new ListView(); // si creas dos instancias se crea dos veces y da error de logica
                ListControl objListControl = new ListControl(objListView);
                objMainView.panel.setVisible(false);
                objMainView.add(objListView);
                objListView.setVisible(true);
            }
        });

        objMainView.aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About obj_about = new About();
                obj_about.setVisible(true);
                AboutControl obj_about_control = new AboutControl(obj_about);
            }
        });
    }
}
