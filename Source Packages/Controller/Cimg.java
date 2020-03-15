/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "cimg")
@SessionScoped
public class Cimg implements Serializable {

private List<String> images;
 
 @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        
       for(int i = 1; i<= 7; i++){
           images.add("bebida" + i + ".jpg");
       }
    }
 
    public List<String> getImages() {
        return images;
    }
    
}
