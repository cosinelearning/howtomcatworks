package exec5container.valves;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletException;
import org.apache.catalina.Request;
import org.apache.catalina.Response;
import org.apache.catalina.Valve;
import org.apache.catalina.ValveContext;
import org.apache.catalina.Contained;
import org.apache.catalina.Container;

public class ClientIPLoggerValve implements Valve, Contained {

	protected Container container;
	
	public void invoke(Request request, Response response, ValveContext valveContext)
		throws IOException, ServletException
	{
		valveContext.invokeNext(request,  response); //that's why the chain can continue.
		System.out.println("Client IP Logger Valve");
		ServletRequest sreq = request.getRequest();
		System.out.println(sreq.getRemoteAddr());
		System.out.println("---------------------------------");
	}
	
	public String getInfo(){
		return null;
	}
	
	public Container getContainer(){
		return container;
	}
	
	public void setContainer(Container container){
		this.container = container;
	}
	
}
