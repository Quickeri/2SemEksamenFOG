/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alber
 */
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        
        int customerId = user.getId();
        int carportId = Integer.parseInt(request.getParameter("carportid"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
        Order order = LogicFacade.createOrder(customerId, carportId, length, width, height);
        
        request.setAttribute("order", order);
        
        return "ordercarportpage";
    }
    
}
