import lib.messageservice.ConsoleMessageService;
import lib.messageservice.MessageService;

public class World {
    public DayPhase dayPhase = DayPhase.NIGHT;

    public World() {

    }

    public void startAction() {
        MessageService msg = new ConsoleMessageService();
        Rocket rocket = new Rocket();
    }
}
