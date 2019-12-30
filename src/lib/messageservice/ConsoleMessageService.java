package lib.messageservice;
import lib.messageservice.MessageService;

public class ConsoleMessageService implements MessageService {
  public void showMessage(String mes) {
    System.out.print(mes);
  }
  public void showMessageWithNewLineEnding(String mes) {
    System.out.println(mes);
  }
}
