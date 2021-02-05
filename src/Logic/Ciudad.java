/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Observable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
@XmlRootElement(name = "ciudad")
public class Ciudad extends Observable implements Comparable<Ciudad>{

    public Ciudad() {
    }
    
    
    
    
    @XmlElement(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @XmlElement(name ="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name = "gmt")
    public int getGmt() {
        return gmt;
    }

    public void setGmt(int gmt) {
        this.gmt = gmt;
    }

    public Ciudad(String code, String nombre, int gmt) {
        this.code= code;
        this.nombre=nombre;
        this.gmt=gmt;
    }
    
    @Override
    public String toString(){
        StringBuilder r= new StringBuilder();
        r.append(code);
        r.append(",");
        r.append(nombre).append("").append(gmt);
        return  r.toString();
    }
   
    private String code;
    private String nombre;
    private int gmt;
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Ciudad){
            return ((Ciudad)o).compareTo(this)==0;
        }
        return false;
    }

    @Override
    public int compareTo(Ciudad o) {
      return o.getCode().compareTo(this.getCode());
    }
}
