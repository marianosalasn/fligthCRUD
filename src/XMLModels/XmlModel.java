/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLModels;

import DAOS.ListaCiudades;
import DAOS.ListaVuelos;
import Logic.*;
import java.io.Serializable;
import Utility.Utility;
import java.io.File;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
@XmlRootElement
public class XmlModel implements Serializable{

    @XmlElement(name = "ciudades")
    public ListaCiudades getCitys() {
        return citys;
    }

    public void setCitys(ListaCiudades citys) {
        this.citys = citys;
        for( Ciudad c : citys.getCiudades()){
            ListaCiudades.getInstance().addCity(c);
        }
    }

    @XmlElement(name = "vuelos")
    public ListaVuelos getFliesxml() {
        return fliesxml;
    }

    public void setFliesxml(ListaVuelos fliesxml) {
        this.fliesxml = fliesxml;
        for(Vuelo v : fliesxml.getVuelos()){
            ListaVuelos.getInstance().addFly(v);
        }
    }

    public XmlModel() {
        citys = new ListaCiudades();
        fliesxml = new ListaVuelos();
    }
    
    public void toXML(){
        this.citys = ListaCiudades.getInstance();
        this.fliesxml = ListaVuelos.getInstance();
        
        File f=new File("data.xml");
        Utility.jaxbMarshaller(f, XmlModel.class, this);
    }
    public void fromXml(){
        XmlModel model = Utility.jaxbUnmarshall(new File("data.xml"), XmlModel.class);
        if(model!=null){
        this.setCitys(model.citys);
        this.setFliesxml(model.fliesxml);
        }else{
         this.setCitys(new ListaCiudades());
         this.setFliesxml(new ListaVuelos());
        }
    }
    
    private ListaCiudades citys;
    private ListaVuelos fliesxml;
}
