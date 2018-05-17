package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
       int page;
       int count = LogicFacade.countOrders();
       int totalPages = (int) Math.ceil((double)count / 10);
       if(request.getParameter("page") != null){
           page = Integer.parseInt(request.getParameter("page"));  
       }
       else {
           page = 1;
       }
//       if(page < 1){
//           page = 1;
//       }    
//       if(page > totalPages){
//           page = totalPages;
//       }
//       
       ArrayList<Order> orders = new ArrayList();
       if (request.getParameter("orderby") != null){
           String orderby = request.getParameter("orderby");
           switch (orderby){
               case "orderid":
                   orders = LogicFacade.getAllOrdersByOrderid(page);
//                   Collections.sort(items, Item.CompareByItemid);
//                   items.sort((o1,o2) -> o1.getItemid().compareTo(o2.getItemid()));
                   break;
               case "customerid":
                   orders = LogicFacade.getAllOrdersByCustomerid(page);
//                   Collections.sort(items, Item.CompareByName);
//                   items.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
                   break;
               case "name":
                   orders = LogicFacade.getAllOrdersByName(page);
//                   Collections.sort(items, Item.CompareByUnit);
//                   items.sort((o1,o2) -> o1.getUnit().compareTo(o2.getUnit()));
                   break;
               case "date":
                   orders = LogicFacade.getAllOrdersByDate(page);
//                   Collections.sort(items, Item.CompareByPrice);
//                   items.sort((o1,o2) -> o1.getPrice().compareTo(o2.getPrice()));
                   break;
           }
       }
       request.setAttribute("list", orders);
       request.setAttribute("count", count);
       request.setAttribute("page", page);
       request.setAttribute("totalpages", totalPages);
       return "vieworders";
    }
    
}
