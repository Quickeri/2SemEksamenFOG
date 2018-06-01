package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerOrders extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        ArrayList<Order> orders = LogicFacade.getOrders(user.getId());
        request.setAttribute("list", orders);
        return "customerorders";
    }
}
    

