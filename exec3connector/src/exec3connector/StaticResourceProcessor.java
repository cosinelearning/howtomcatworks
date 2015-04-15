package exec3connector;

import java.io.IOException;
import exec3connector.connector.http.HttpRequest;
import exec3connector.connector.http.HttpResponse;


public class StaticResourceProcessor {

	public void process(HttpRequest request, HttpResponse response){
		try{
			response.sendStaticResource();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
