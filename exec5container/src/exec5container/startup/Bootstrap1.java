package exec5container.startup;

import exec5container.core.SimpleLoader;
import exec5container.core.SimpleWrapper;
import exec5container.valves.ClientIPLoggerValve;
import exec5container.valves.HeaderLoggerValve;
import org.apache.catalina.Loader;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.http.HttpConnector;

public class Bootstrap1 {

	public static void main(String[] args){
		HttpConnector connector = new HttpConnector();
		Wrapper wrapper = new SimpleWrapper();
		wrapper.setServletClass("ModernServlet");
		//wrapper.setServletClass("PrimitiveServlet");
		Loader loader = new SimpleLoader();
		Valve valve1 = new HeaderLoggerValve();
		Valve valve2 = new ClientIPLoggerValve();
		
		wrapper.setLoader(loader);
		((Pipeline) wrapper).addValve(valve1);
		((Pipeline) wrapper).addValve(valve2);
		
		connector.setContainer(wrapper);
		
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
