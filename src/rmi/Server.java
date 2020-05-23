
package rmi;

import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    @Override
    public String digaHola(String nombre) {
    	System.out.println("Petición recibida");
        return "Hola " + nombre + " !!!";
    }

	@Override
	public String digaChao(int i) throws RemoteException {
		System.out.println("Petición a chao recibida");
		return "Chao número " + i;
	}
	
    public static void main(String args[]) {

        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            //Obtiene una referencia a un registro activo en el puerto por defecto (1099)
            Registry registry = LocateRegistry.getRegistry();
            
            //Crea un nuevo registro local a este programa, en el puerto indicado
            //Registry registry = LocateRegistry.createRegistry(1099);
            
            //Registra el proxy (stub) del servidor (clase Server) en el registro, con una clave o nombre
            registry.rebind("HolaChao", stub); //o registry.bind("HolaChao", stub);

            System.out.println("Servidor listo !!!");
        } catch (Exception e) {
            System.err.println("Problema en servidor: " + e.toString());
            e.printStackTrace();
        }
    }

}
