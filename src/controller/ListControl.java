/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0
*/

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

public class ListControl {
    MainView obj_mainview;
    ListView obj_listview;
    
    public ListControl (MainView obj_mainview, ListView obj_listview) {
        this.obj_mainview = obj_mainview;
        this.obj_listview= obj_listview;


        obj_listview.boton_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainView obj_mainview = new MainView();
                MainControl objMainControl = new MainControl(obj_mainview);
                obj_listview.setVisible(false);
                obj_mainview.setVisible(true);
            }
        });
    }
    
}