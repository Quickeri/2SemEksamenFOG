package PresentationLayer;

import FunctionLayer.Item;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        Order order = new Order(orderid, length, width, height);
        
        if(LogicFacade.getOrder(orderid) != null){
            LogicFacade.updateOrder(order);
            LogicFacade.deleteItemList(orderid);
            ArrayList<Item> itemList = LogicFacade.makeItemList(order);
            LogicFacade.createItemList(order, itemList);
        }
        
        return "employeepage";
    }
    
}
