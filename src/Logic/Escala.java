/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Observable;

/**
 *
  * @author Mariano Salas Nuñez
 * @version 1.0
 */
@XmlRootElement(name ="Escala")
public class Escala extends Observable{

    public Escala() {
    }
    
    

    public Escala(int duracion, int salida, int llegada , Ciudad escalacity) {
        this.duracion=duracion;
        this.llegada = llegada;
        this.salida=salida;
        this.escalaCity= escalacity;
    }
    
    @XmlElement(name ="duracion")
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    @XmlElement(name = "llegada")
    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }
    @XmlElement(name = "salida")
    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }
    @XmlElement(name = "CiudadEscala")
    public Ciudad getEscalaCity() {
        return escalaCity;
    }

    public void setEscalaCity(Ciudad escalaCity) {
        this.escalaCity = escalaCity;
    }
    
    
    private int duracion;
    private int llegada;
    private int salida;
    private Ciudad escalaCity;
            
}
