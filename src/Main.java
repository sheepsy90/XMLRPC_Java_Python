import de.dfki.util.xmlrpc.server.XmlRpcHandlerFactory;
import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcHandler;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
	    WebServer xmlRpcServer = new WebServer( 8099 );
	    XmlRpcHandler handlerFor = XmlRpcHandlerFactory.createHandlerFor(new Impl());
	    xmlRpcServer.addHandler( "userService", handlerFor);
	    System.out.println(handlerFor.toString());
	    xmlRpcServer.start();
    }
}
