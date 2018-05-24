package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "rolepage", new RolePage() );
        commands.put( "vieworders", new ViewOrders() );
        commands.put( "createorder", new CreateOrder() );
        commands.put( "logout", new LogOut() );
        commands.put("ordercarportpage", new OrderCarportPage());
        commands.put("customerorders", new CustomerOrders());
        commands.put("searchorder", new SearchOrder());
        commands.put("updateorder", new UpdateOrder());
        commands.put("deleteorder", new DeleteOrder());
        commands.put("gotoupdateuser", new GoToUpdateUser());
        commands.put("updateuser", new UpdateUser());
        commands.put("searchitem", new SearchItem());
        commands.put("updateitem", new UpdateItem());
        commands.put("viewitems", new ViewItems());
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
