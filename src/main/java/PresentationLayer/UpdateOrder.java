/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CalculateItemList;
import FunctionLayer.Item;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mads
 */
public class UpdateOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        Order order = new Order(orderid, length, width, height);
        
        if(LogicFacade.getOrder(orderid) != null){
            CalculateItemList cs = new CalculateItemList();
            LogicFacade.updateOrder(order);
            LogicFacade.deleteItemList(orderid);
            ArrayList<Item> itemList = cs.makeItemList(order);
            LogicFacade.createItemList(order, itemList);
        }
        
        return "employeepage";
    }
    
}
