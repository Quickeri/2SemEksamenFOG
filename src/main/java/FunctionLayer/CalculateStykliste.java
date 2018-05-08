/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;



/**
 *
 * @author Mads
 */
public class CalculateStykliste {
    
    public ArrayList<Item> makeStykliste(Order o){
        ArrayList<Item> stykliste = new ArrayList();
        int antalStolper = (o.getLength()/200 * 2) + (o.getWidth()/200);   
        stykliste.add(new Item("97x97 mm. trykimp. Stolpe", o.getHeight()+90, antalStolper, "stk", "Stolper nedgraves 90cm i jord"));
        stykliste.add(new Item("45x195 mm. Spær", o.getWidth(), o.getLength()/100, "stk", "Monteres på rem"));
        return stykliste;
    }
}
