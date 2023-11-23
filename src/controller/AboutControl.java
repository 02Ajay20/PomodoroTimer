package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.About;
import view.MainView;

public class AboutControl {
  
  About obj_about;
  
  public AboutControl(About obj_about) {
    this.obj_about = obj_about;

    
    // Evento volver
    obj_about.button_back.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        MainView obj_main_view = new MainView();
        MainControl obj_main_control = new MainControl(obj_main_view);
        obj_about.setVisible(false);
        obj_about.dispose();
        obj_main_view.setVisible(true);
      }
      
    });
  }
}
