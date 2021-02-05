/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Logic.Ciudad;
import Logic.Escala;
import Logic.Vuelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author masan
 */
@XmlRootElement(name = "vuelos")
public class ListaVuelos extends Observable implements Observer{
    
    
    public void setVuelos(List<Vuelo> newVuelos){
        for(Vuelo v: newVuelos){
            addFly(v);
            
        }
    }
    @XmlTransient
    public Map<String, Vuelo> getVuelosMap() {
        return vuelosMap;
    }

    public void setVuelosMap(Map<String, Vuelo> vuelos) {
        this.vuelosMap = vuelos;
    }
    @XmlElement(name ="vuelo")
    @XmlElementWrapper(name ="ListaVuelos")
    public List<Vuelo> getVuelos(){
        
        return new ArrayList<>(vuelosMap.values());
    }
    public ListaVuelos() {
        //vuelos = new ArrayList<>();
       
    }
    public void updateFly(Vuelo v,Ciudad origen, Ciudad destino, int llegada, int salida){
        v.setDestino(destino);
        v.setLlegada(llegada);
        v.setOrigen(origen);
        v.setSalida(salida);
      //ya los set del vuelo notifican // setChanged();
       // notifyObservers(this);
    }
    public void addEscale(Vuelo v, Escala e){
        
      
    }
    public void addFly(Vuelo vuelo){
       if(!vuelosMap.containsKey(vuelo.getNum())){
            getVuelosMap().put(vuelo.getNum(), vuelo);
            setChanged();
            notifyObservers(this);
            vuelo.addObserver(this);
       }
    }
    public static ListaVuelos getInstance(){
        if(instance==null){
            instance= new ListaVuelos();
        }
        return instance;
    }
    private Map<String, Vuelo> vuelosMap= new HashMap<>();

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }
    
    static ListaVuelos instance;
}
