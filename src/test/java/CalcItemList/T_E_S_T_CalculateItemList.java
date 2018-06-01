package CalcItemList;

import FunctionLayer.CalculateItemList;
import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        int length = 600;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcPoles(o);
        int expected = 6;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcPoles2() throws LoginSampleException{
        int length = 300;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcPoles(o);
        int expected = 4;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcRafts()throws LoginSampleException{
        int length = 600;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcRafts(o);
        int expected = 11;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcRafts2()throws LoginSampleException{
        int length = 300;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcRafts(o);
        int expected = 5;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketsLeft()throws LoginSampleException{
        int length = 600;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsLeft(o);
        int expected = 11;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketsLeft2()throws LoginSampleException{
        int length = 300;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsLeft(o);
        int expected = 5;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketsRight()throws LoginSampleException{
        int length = 600;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsRight(o);
        int expected = 11;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketsRight2()throws LoginSampleException{
        int length = 300;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsRight(o);
        int expected = 5;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketScrews()throws LoginSampleException{
        int length = 600;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsScrews(o);
        int expected = 1;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    @Test
    public void testCalcBracketScrews2()throws LoginSampleException{
        int length = 300;
        int height = 260;
        int width = 240;
        Order o = new Order(1, length, height, width);
        Item item = cil.calcBracketsScrews(o);
        int expected = 1;
        int actual = item.getAmount();
        assertEquals(expected, actual);
    }
    
}
