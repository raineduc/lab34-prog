package places;

import entries.Illuminator;
import lib.messageservice.MessageService;

import java.util.ArrayList;

public class RocketCabine extends Place {
    protected ArrayList<Illuminator> illuminators = new ArrayList<>(4);

    public RocketCabine() {
        for (int i = 0; i < 4; i++)
            illuminators.add(new Illuminator("иллюминатор", false, this));
    }

    public void pushIlluminatorsToEntries() {
        for (int i = 0; i < 4; i++)
            illuminators.get(i).open();
    }

    public void brokeIlluminators() {
        for (int i = 0; i < 4; i++)
            illuminators.get(i).broke();
        this.pushIlluminatorsToEntries();
        MessageService.showMessageWithNewLineEnding("Вышиблены стёкла иллюминаторов!");
    }
}
