//interface class
public interface License extends java.rmi.Remote {

	Car generateLicense(Car car) throws java.rmi.RemoteException;

}
