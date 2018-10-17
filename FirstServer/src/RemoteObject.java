import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObject extends Remote
{
   public void addMessage(String msg,ReplyTo obj) throws RemoteException;
}
