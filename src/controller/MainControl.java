package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;

public class MainControl {
    MainView objMainView;

    public MainControl(MainView objMainView){
        this.objMainView = objMainView;

        objMainView.closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                objMainView.dispose();
            }
        });
    }
}
