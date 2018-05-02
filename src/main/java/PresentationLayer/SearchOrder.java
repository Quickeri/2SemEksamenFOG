/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderid = Integer.parseInt(request.getParameter( "orderid" ));
        if (LogicFacade.getOrder(orderid) != null){
            Order order = LogicFacade.getOrder(orderid);
            request.setAttribute("order", order);
            return "viewsingleorder";
        }
        else {
            ArrayList<Order> orders = LogicFacade.getAllOrders();
            request.setAttribute("list", orders);
            return "vieworders";
        }
    }
    
}
