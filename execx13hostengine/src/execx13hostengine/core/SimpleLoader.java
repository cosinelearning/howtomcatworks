package execx13hostengine.core;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import org.apache.catalina.Container;
import org.apache.catalina.Loader;
import org.apache.catalina.DefaultContext;

public class SimpleLoader implements Loader {

	public static final String WEB_ROOT = System.getProperty("user.home") + File.separator + "webroot";
	
	ClassLoader classLoader = null;
	Container container = null;
	
	public SimpleLoader(){
		try {
		      URL[] urls = new URL[1];
		      URLStreamHandler streamHandler = null;
		      File classPath = new File(WEB_ROOT);
		      String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
		      urls[0] = new URL(null, repository, streamHandler);
		      classLoader = new URLClassLoader(urls);
		    }
		    catch (IOException e) {
		      System.out.println(e.toString() );
		    }
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRepository(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] findRepositories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return this.classLoader;
	}

	@Override
	public Container getContainer() {
		// TODO Auto-generated method stub
		return this.container;
	}

	@Override
	public DefaultContext getDefaultContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getDelegate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "a simple classloader";
	}

	@Override
	public boolean getReloadable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContainer(Container arg0) {
		// TODO Auto-generated method stub
		this.container = arg0;
	}

	@Override
	public void setDefaultContext(DefaultContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDelegate(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReloadable(boolean arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
