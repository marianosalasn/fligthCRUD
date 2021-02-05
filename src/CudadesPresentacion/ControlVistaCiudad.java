/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CudadesPresentacion;

import DAOS.ListaCiudades;
import DAOS.ListaVuelos;
import Logic.Ciudad;
import java.util.List;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
public class ControlVistaCiudad {

    public ListaVuelos getFliess() {
        return fliess;
    }

    public void setFliess(ListaVuelos fliess) {
        this.fliess = fliess;
    }

    public ListaCiudades getCitiess() {
        return citiess;
    }

    public void setCitiess(ListaCiudades citiess) {
        this.citiess = citiess;
    }

    public Integer[] getHorasC() {
        return HorasC;
    }

    public void setHorasC(Integer[] HorasC) {
        this.HorasC = HorasC;
    }
    
    public List<Ciudad> busqueda(String entry){
        return citiess.searchBy(entry);
         
    }
    
    private ListaVuelos fliess = ListaVuelos.getInstance();
    private ListaCiudades citiess= ListaCiudades.getInstance();
    private Integer HorasC[]=new Integer[]{-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12};
}
