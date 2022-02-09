
public class LicenseImpl extends java.rmi.server.UnicastRemoteObject implements License {
	//constructor
	public LicenseImpl() throws java.rmi.RemoteException{
		super();
	}

	//generates License plate implmentation
	public Car generateLicense(Car car) throws java.rmi.RemoteException{

		car.setPlate(car.hashCode());

		return car;

	}

}
