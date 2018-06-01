package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        
        if(LogicFacade.getOrder(orderid) != null){
            LogicFacade.deleteOrder(orderid);       
        }
        return "employeepage";
    }
    
}
