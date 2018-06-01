package PresentationLayer;

import FunctionLayer.Item;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        
        int customerId = user.getId();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dt);
        
        Order order = LogicFacade.createOrder(customerId, length, width, height, date);
        ArrayList<Item> itemList = LogicFacade.makeItemList(order);
        LogicFacade.createItemList(order, itemList);
        request.setAttribute("order", order);
        
        return "drawcarport";
    }
    
}
