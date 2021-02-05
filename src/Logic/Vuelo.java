/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
@XmlRootElement (name = "vuelo")
public class Vuelo extends Observable  {

    public Vuelo() {
    }
    
    

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }
    
    @XmlElement(name ="numeroVuelo")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
        setChanged();
        notifyObservers(this);
    }
    @XmlElement(name = "origen")
    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
         setChanged();
        notifyObservers(this);
    }
    @XmlElement(name = "destino")
    public Ciudad getDestino() {
        return destino;
    }
    public void addEscala(Escala e){
        escalas.add(e);
        setChanged();
        notifyObservers(this);
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
        setChanged();
        notifyObservers(this);
    }
    @XmlElement(name = "llegada")
    public int getLlegada() {
        return llegada;
    }

    public void setLlegada(int llegada) {
        this.llegada = llegada;
        setChanged();
        notifyObservers(this);
    }
    @XmlElement (name = "salida")
    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
        setChanged();
        notifyObservers(this);
    }

    public Vuelo(String num, Ciudad origen, Ciudad destino,int llegada , int salida) {
        this.num=num;
        this.destino=destino;
        this.origen=origen;
        this.llegada=llegada;
        this.salida=salida;
        this.escalas=new ArrayList<>();
    }
    public String descipcion(){
        return new String(new StringBuilder().append(origen.getNombre()).append("-").append(destino.getNombre()));
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append(num).append(",").append(descipcion()).append(salida).append(llegada);
        return sb.toString();
    }
    private String num;
    private Ciudad origen;
    private Ciudad destino;
    private int llegada;
    private int salida;
    private List<Escala> escalas;
}
