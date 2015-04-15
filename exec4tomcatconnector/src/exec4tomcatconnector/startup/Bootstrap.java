package exec4tomcatconnector.startup;

import exec4tomcatconnector.core.SimpleContainer;
import org.apache.catalina.connector.http.HttpConnector;

public class Bootstrap {
	public static void main(String[] args){
		HttpConnector connector = new HttpConnector();
		SimpleContainer container  = new SimpleContainer();
		connector.setContainer(container);
		
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
