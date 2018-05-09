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
        int antalPlastmo = o.getLength()/(360-20);
        int spærLængde = 600;
        if (o.getWidth() < 480){
            spærLængde = 480;
        }
        stykliste.add(new Item("97x97 mm. trykimp. Stolpe", 300, antalStolper, "stk", "Stolper nedgraves 90cm i jord"));
        stykliste.add(new Item("45x195 mm. spærtræ ubh.", 600, 2, "stk", "Remme i sider, sadles ned i stolper"));
        stykliste.add(new Item("45x195 mm. spærtræ ubh.", spærLængde, o.getLength()/55, "stk", "Monteres på rem"));
        stykliste.add(new Item("Plastmo Ecolite blåtonet", 360, antalPlastmo, "stk", "Monteres på spær"));
        stykliste.add(new Item("Universalbeslag 190mm venstre", o.getLength()/55, "stk", "Til montering af spær på rem"));
        stykliste.add(new Item("Universalbeslag 190mm højre", o.getLength()/55, "stk", "Til montering af spær på rem"));
        return stykliste;
    }
}
