package exec3connector.startup;

import exec3connector.connector.http.HttpConnector;

public class Bootstrap {

	public static void main (String[] args){
		
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
	
}
