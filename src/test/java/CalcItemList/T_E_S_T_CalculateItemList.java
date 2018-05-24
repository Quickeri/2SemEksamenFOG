/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcItemList;

import FunctionLayer.CalculateItemList;
import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mads
 */
public class T_E_S_T_CalculateItemList {
    
    CalculateItemList cil = new CalculateItemList();
    public T_E_S_T_CalculateItemList() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testCalcPoles() throws LoginSampleException{
        ArrayList<Item> itemList = new ArrayList();
        Order order = new Order(1, itemList);
        Item item = cil.calcPoles(order);
    }
    @Test
    public void testCalcRafts(){
        
    }
    @Test
    public void testCalcBracketsLeft(){
        
    }
    @Test
    public void testCalcBracketsRight(){
        
    }
    @Test
    public void testCalcBracketScrews(){
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
