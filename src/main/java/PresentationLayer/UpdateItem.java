package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Item;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateItem extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int itemid = Integer.parseInt(request.getParameter("itemid"));
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        Item item = new Item(itemid, name, unit, price, description);
        
        if(LogicFacade.getItem(itemid) != null){
            LogicFacade.updateItem(item);
            request.setAttribute("itemupdated", "success");
        }
        Item i = LogicFacade.getItem(itemid);
        
        request.setAttribute("item", i);
           
        return "viewsingleitem";
    }
    
}
