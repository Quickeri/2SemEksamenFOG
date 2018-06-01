package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUser extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        int id = Integer.parseInt(request.getParameter("userid"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        User user = new User (id, email, password);
        
            LogicFacade.updateUser(user);
            request.setAttribute("userupdated", "success");
        
        return "update" + request.getSession().getAttribute("role");
    }
    
}
