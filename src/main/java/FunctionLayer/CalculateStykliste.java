/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;



/**
 *
 * @author Mads
 */
public class CalculateStykliste {
    
    public Stykliste makeStykliste(Order o){
        int stolper = (o.getLength()/100) + (o.getWidth()/100);
        Stykliste stykliste = new Stykliste(stolper);
        
        return stykliste;
    }
}
