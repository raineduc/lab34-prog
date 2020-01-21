package lib.messageservice;

public class ConsoleMessageStrategy implements MessageStrategy {
  public void showMessage(String mes) {
    System.out.print(mes);
  }
  public void showMessageWithNewLineEnding(String mes) {
    System.out.println(mes);
  }
}
