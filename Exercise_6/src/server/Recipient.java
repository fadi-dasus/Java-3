package server;

import requestreply.Message;

public interface Recipient {

   byte[] interpret(Message message);

}