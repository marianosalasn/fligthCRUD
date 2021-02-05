/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelos;

import java.rmi.server.UID;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
public class ExamenVuelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                new XMLModels.XmlModel().toXML();
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VistaGeneral("Adminitracion de Vuelos by Mariano Salas").setVisible(true);
            }
        });
    }

}
