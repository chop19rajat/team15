import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ebondtrader.ejb.EBondBeanRemote;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Properties for JNDI InitialContext.
				Properties prop = new Properties();
				prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
				prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
				prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
				prop.put("jboss.naming.client.ejb.context", true);

				// Create the JNDI InitialContext.
				
				Context context = null;
				try{
				context=	new InitialContext(prop);
					
				// Formulate the full JNDI name for the OnlineRetailer session bean.
				String appName     = "StudentOnlineRetailer";
				String moduleName  = "StudentOnlineRetailerEJB";
				String beanName    = "OnlineRetailerBean";
				String packageName = "student.onlineretailer.ejb";
				String className   = "OnlineRetailerBeanRemote";
				System.out.println("Hello");

				// Lookup the bean using the full JNDI name.
				String fullJndiName = String.format("%s/%s/%s!%s.%s", appName, moduleName, beanName, packageName, className);
				EBondBeanRemote bean = (EBondBeanRemote) context.lookup("EBondTrader/EBondTraderEJB/EBondBean!ebondtrader.ejb.EBondBeanRemote");
				System.out.println("second");
				
				bean.printing();
				
				}
				
				catch(Exception e){		
					System.out.println("error");
					e.printStackTrace();
				}
				
				
			}
	public Main() {
		super();
	}

}