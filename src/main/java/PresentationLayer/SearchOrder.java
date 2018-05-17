/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CalculateStykliste;
import FunctionLayer.Item;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        CalculateStykliste cs = new CalculateStykliste();
        int orderid = Integer.parseInt(request.getParameter( "orderid" ));
        if (LogicFacade.getOrder(orderid) != null){
            Order order = LogicFacade.getOrder(orderid);
            List<Item> stykliste = cs.makeStykliste(order).getItems();
            request.setAttribute("order", order);
            request.setAttribute("stykliste", stykliste);
            return "viewsingleorder";
        }
        else {
            ArrayList<Order> orders = LogicFacade.getAllOrdersByOrderid(1);
            int count = LogicFacade.countOrders();
            int totalPages = count / 10;
            request.setAttribute("totalpages", totalPages);
            request.setAttribute("count", count);
            request.setAttribute("page", 1);
            request.setAttribute("list", orders);
            request.setAttribute("searchError", "Order not found");
            return "vieworders";
        }
    }
    
}
