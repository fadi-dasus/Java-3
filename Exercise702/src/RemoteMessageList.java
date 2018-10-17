import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
   public void addMessage(String msg, ReplyTo who) throws RemoteException;
}
