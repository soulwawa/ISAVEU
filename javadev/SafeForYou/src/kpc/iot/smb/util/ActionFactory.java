package kpc.iot.smb.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public class ActionFactory {
	private static ActionFactory instance;
	private HashMap<String, Action> map;
	private Properties prop;
	
	private ActionFactory() {
		map = new HashMap<String, Action>();
		InputStream in = null;
		try{
			in = getClass().getClassLoader().getResourceAsStream("mvc.properties");
			prop = new Properties();
			prop.load(in);
		}catch(Exception ex){
			ex.printStackTrace();
//			System.out.println(ex);
		}finally{
			if(in != null){
				try{ in.close(); } catch(Exception ex){}
			}
		}
	} // ������
	
	public synchronized static ActionFactory getInstance(){
		if(instance == null){
			instance = new ActionFactory();
		}
		return instance;
	}
	
	public Action getAction(String path){
		Action act = map.get(path);
		if(act == null){
			String className = prop.getProperty(path);
			System.out.println("prop : " + prop);
			System.out.println("path : " + path);			
			System.out.println("className : " + className);
			className = className.trim();
			try{
				Class c = Class.forName(className);
				Object obj = c.newInstance();
				if(obj instanceof Action){
					map.put(path, (Action)obj);
					act = (Action)obj;
				}else{
					throw new ClassCastException("ClassCastException");
				}
			}catch(Exception ex){
				System.out.println(ex);
				throw new RuntimeException("RuntimeException : " + ex);
			}
		}
		return act;
	}
	
	public static void main(String args[]){
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.getAction("/*.do");
		if(action != null)
			System.out.println("ok");
		else
			System.out.println("error");
	}
}
