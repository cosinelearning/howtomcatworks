package exec5container.startup;

import exec5container.core.SimpleContext;
import exec5container.core.SimpleContextMapper;
import exec5container.core.SimpleLoader;
import exec5container.core.SimpleWrapper;
import exec5container.valves.ClientIPLoggerValve;
import exec5container.valves.HeaderLoggerValve;
import org.apache.catalina.Context;
import org.apache.catalina.Loader;
import org.apache.catalina.Mapper;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;


public final class Bootstrap2 {
	
	public static void main(String[] args){
		HttpConnector connector = new HttpConnector();
		Wrapper wrapper1 = new SimpleWrapper();
		wrapper1.setName("Primitive");
		wrapper1.setServletClass("PrimitiveServlet");
		Wrapper wrapper2 = new SimpleWrapper();
		wrapper2.setName("Modern");
		wrapper2.setServletClass("ModernServlet");
		
		Context context = new SimpleContext();
		context.addChild(wrapper1);
		context.addChild(wrapper2);
		
		Valve valve1 = new HeaderLoggerValve();
		Valve valve2 = new ClientIPLoggerValve();
		
		((Pipeline)context).addValve(valve1);
		((Pipeline)context).addValve(valve2);
		
		Mapper mapper = new SimpleContextMapper();
		mapper.setProtocol("http");
		context.addMapper(mapper);
		Loader loader = new SimpleLoader();
		context.setLoader(loader);
		
		context.addServletMapping("/Primitive",  "Primitive");
		context.addServletMapping("/Modern", "Modern");
		
		connector.setContainer(context);
		
		try{
			connector.initialize();
			connector.start();
			
			System.in.read();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
