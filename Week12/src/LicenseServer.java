//import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LicenseServer {
	public LicenseServer() {
		try {
			License license = new LicenseImpl();
			Registry registry = LocateRegistry.createRegistry(4000);
			registry.rebind("LicenseService", license);
			System.out.println("LicenseService Bound to registry");
		} catch( Exception  e) {
			System.err.println(e);
			System.exit(1);
		}

	}


	public static void main(String args[]) {
		new LicenseServer();
		System.out.println("LicenseService is running");

	}




}