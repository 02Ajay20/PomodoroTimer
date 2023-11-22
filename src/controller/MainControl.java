package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import view.BreakTimeView;
import view.MainView;
import view.WorkTimeView;

public class MainControl {
    MainView objMainView;
    BreakTimeView objBreakTimeView;
    WorkTimeView objWorkTimeView;

    public MainControl(MainView objMainView){
        this.objMainView = objMainView;

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
                objWorkTimeView = new WorkTimeView();
                objMainView.panel.setVisible(false);
                objMainView.add(objWorkTimeView);
                objWorkTimeView.setVisible(true);
            }
        });

        objMainView.defaultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objMainView.workTextField.setText("25");
                objMainView.breakTextField.setText("5");
            }
        });

        objMainView.aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JDialog
            }
        });
    }
}
