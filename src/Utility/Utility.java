/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Mariano Salas Nuñez
 * @version 1.0
 */
public class Utility {
     public static <T> T jaxbUnmarshall(File f, Class<T> clazz) {
        try {
            T c;
            try (FileInputStream input = new FileInputStream(f)) {
                JAXBContext contexto = JAXBContext.newInstance(clazz);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();
                c = (T) unmarshaller.unmarshal(input);
            }
            return c;
        } catch (IOException | JAXBException e) {
            return null;
        }
    }
     public static <T> boolean jaxbMarshaller(File f ,Class<T> clase, T objeto){
          try {
            FileOutputStream fileout = new FileOutputStream(f);
            JAXBContext contexto = JAXBContext.newInstance(clase);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objeto,fileout);
             fileout.close();
             return true;

        } catch (IOException | JAXBException ex) {
            ex.printStackTrace();
            return false;

        }
     
     } 
     public static boolean isDigit(String s){
         for(int i=0;i<s.length();i++ ){
             if(!Character.isDigit(s.charAt(i))){
                 return false;
             }
         }
         return true;
     }
}
