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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchItem extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int itemid = Integer.parseInt(request.getParameter( "itemid" ));
        if (LogicFacade.getItem(itemid) != null){
            Item item = LogicFacade.getItem(itemid);
            request.setAttribute("item", item);
            return "viewsingleitem";
        }
        else {
            ArrayList<Item> items = LogicFacade.getAllItemsByID(1);
            int count = LogicFacade.countItems();
            int totalPages = (int) Math.ceil((double)count / 10);
            request.setAttribute("list", items);
            request.setAttribute("count", count);
            request.setAttribute("page", 1);
            request.setAttribute("orderby", "itemid");
            request.setAttribute("totalpages", totalPages);
            request.setAttribute("searcherror", "notfound");
            return "viewitems";
        }
//        
//        else {
//            throw new LoginSampleException( "Kunne ikke finde et item med dette itemid" );
//        }
    }
    
}
