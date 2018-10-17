import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReplyTo extends Remote
{
   public void replyTo(String msg2) throws RemoteException;
}
