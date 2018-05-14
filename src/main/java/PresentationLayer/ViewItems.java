/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Item;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mads
 */
public class ViewItems extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
       int page;
       int count = LogicFacade.countItems();
       int totalPages = count / 10;
       if(request.getParameter("page") != null){
           page = Integer.parseInt(request.getParameter("page"));  
       }
       else {
           page = 1;
       }
       if(page < 1){
           page = 1;
       }    
       if(page > totalPages){
           page = totalPages;
       }
        
       ArrayList<Item> items = new ArrayList();
       if (request.getParameter("orderby") != null){
           String orderby = request.getParameter("orderby");
           switch (orderby){
               case "itemid":
                   items = LogicFacade.getAllItemsByID(page);
//                   Collections.sort(items, Item.CompareByItemid);
//                   items.sort((o1,o2) -> o1.getItemid().compareTo(o2.getItemid()));
                   break;
               case "name":
                   items = LogicFacade.getAllItemsByName(page);
//                   Collections.sort(items, Item.CompareByName);
//                   items.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
                   break;
               case "unit":
                   items = LogicFacade.getAllItemsByUnit(page);
//                   Collections.sort(items, Item.CompareByUnit);
//                   items.sort((o1,o2) -> o1.getUnit().compareTo(o2.getUnit()));
                   break;
               case "price":
                   items = LogicFacade.getAllItemsByPrice(page);
//                   Collections.sort(items, Item.CompareByPrice);
//                   items.sort((o1,o2) -> o1.getPrice().compareTo(o2.getPrice()));
                   break;
           }
       }
       request.setAttribute("list", items);
       request.setAttribute("count", count);
       request.setAttribute("totalpages", totalPages);
       request.setAttribute("page", page);
       return "viewitems";
    }
    
}
