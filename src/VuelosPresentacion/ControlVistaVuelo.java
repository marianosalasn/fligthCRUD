/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VuelosPresentacion;

import DAOS.ListaCiudades;
import DAOS.ListaVuelos;
import Logic.Escala;
import Logic.Vuelo;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
public class ControlVistaVuelo implements Observer{

    public ListaVuelos getFlies() {
        return flies;
    }

    public void setFlies(ListaVuelos flies) {
        this.flies = flies;
    }

    public ListaCiudades getCities() {
        return cities;
    }

    public void setCities(ListaCiudades cities) {
        this.cities = cities;
    }

    public Integer[] getHoras() {
        return Horas;
    }

    public void setHoras(Integer[] Horas) {
        this.Horas = Horas;
    }

    public ControlVistaVuelo() {
        flies.addObserver(this);
        cities.addObserver(this);
        
    }
    public Vuelo actualiza(Vuelo v){
        Map<String, Vuelo> vuelos = getFlies().getVuelosMap();
        if(vuelos.containsKey(v.getNum())){
            getFlies().updateFly(vuelos.get(v.getNum()), v.getOrigen(), v.getDestino(), v.getLlegada(), v.getSalida());
        } else {
             getFlies().addFly(v);
        }
        return vuelos.get(v.getNum());
    }
    
    public Vuelo agregar(Vuelo v){
      return actualiza(v);
    }
    
    public void addEscala(String num , Escala v){
        
        getFlies().getVuelosMap().get(num).addEscala(v);
       
        
    }
    @Override
    public void update(Observable o, Object arg) {
       
    }
    private ListaVuelos flies = ListaVuelos.getInstance();
    private ListaCiudades cities= ListaCiudades.getInstance();
    private Integer Horas[]=new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
}