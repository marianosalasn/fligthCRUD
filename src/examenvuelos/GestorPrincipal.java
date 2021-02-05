/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelos;

import CudadesPresentacion.ControlVistaCiudad;
import CudadesPresentacion.VistaCiudades;
import VuelosPresentacion.ControlVistaVuelo;
import VuelosPresentacion.VistaVuelos;
import XMLModels.XmlModel;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
public class GestorPrincipal {

    public GestorPrincipal() {
        vistVuelos= new VistaVuelos(controlVuelos);
        vistaCiudades = new VistaCiudades(controlCiudades);
        new XmlModel().fromXml();
        
    }
    
    public void traerVuelosAlFrente(boolean enable){
        vistVuelos.setVisible(enable);
    }
    public void traerCiudadesAlFrente(boolean enable){
        vistaCiudades.setVisible(enable);
    }
    
    VistaVuelos vistVuelos;
    VistaCiudades vistaCiudades;
    ControlVistaVuelo controlVuelos= new ControlVistaVuelo();
    ControlVistaCiudad controlCiudades= new ControlVistaCiudad();
}
