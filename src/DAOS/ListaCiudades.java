/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import Logic.Ciudad;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author masan
 */
public class ListaCiudades extends Observable implements Observer{
    
    public ListaCiudades() {
        ciudades= new ArrayList<>();
    }
    public void addCity(Ciudad city){
        if(!ciudades.stream().anyMatch(c->c.getCode().equals(city.getCode()))){
            getCiudades().add(city);
            setChanged();
            notifyObservers(this);
            city.addObserver(this);
            
        }else{
            int x=ciudades.indexOf(city);
            Ciudad c =ciudades.get(x);
            c.setNombre(city.getNombre());
            c.setGmt(city.getGmt());
            c.setCode(city.getCode());
            setChanged();
            notifyObservers(this);
        }
        
    }
    public List<Ciudad> searchBy(String entrada){
        List<Ciudad> retorno = new ArrayList<>();
        for(Ciudad c : getCiudades()){
            String nombre = c.getNombre().toLowerCase(Locale.getDefault());
            if(nombre.contains(entrada.toLowerCase(Locale.getDefault()))){
                retorno.add(c);
            }
        }
        return retorno;
    }
    public static ListaCiudades getInstance(){
        if(instance==null){
            instance = new ListaCiudades();
        }
        return instance;
    }
    
    private List<Ciudad> ciudades;
    private static ListaCiudades instance;
    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
}
