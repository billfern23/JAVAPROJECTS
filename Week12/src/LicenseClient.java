import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LicenseClient {

	public static void main(String [] args) {
		//create arraylist of Car objects
		ArrayList<Car> cars = new ArrayList<Car>();
		Car car1 = new Car("Ford", "red", 100000);
		Car car2 = new Car("BMW", "white", 3000);
		Car car3 = new Car("Toyota", "grey", 30000000);
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		//for each one add license plates by passing to server. 
		cars.stream().forEach(car -> {
			try {
				//before adding a plate
				System.out.print("Before Adding License" +  "\n"  + car +  "\n" );
				License license = (License) Naming.lookup("rmi://localhost:4000/LicenseService");
				//after adding a plate
				car = license.generateLicense(car);
				System.out.print("After Adding License " + "\n" + car +  "\n");
				System.out.print("-------------------------------------------------------------" + "\n" );
			} catch (MalformedURLException mue) {
				System.out.println(mue);
			}  catch (RemoteException re) {
				System.out.println(re);
			} catch (NotBoundException nbe) {
				System.out.println(nbe);
			} catch (ArithmeticException ae) {
				System.out.println(ae);
			}


		});

	}

}
