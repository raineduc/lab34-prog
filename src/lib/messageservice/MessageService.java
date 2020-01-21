package lib.messageservice;

public class MessageService {
  protected static MessageStrategy strategy = new ConsoleMessageStrategy();
  public static void showMessage(String mes) {
    strategy.showMessage(mes);
  }
  public static void showMessageWithNewLineEnding(String mes) {
    strategy.showMessageWithNewLineEnding(mes);
  }

  public static void setStrategy(MessageStrategy mes) {
    strategy = mes;
  }
}
