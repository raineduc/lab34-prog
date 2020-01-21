package com.prog34.entries;

import com.prog34.entries.lib.messageservice.MessageService;

public class RocketTail {
    public boolean isBrokenOff = false;

    public void brokeOff() {
        this.isBrokenOff = true;
        MessageService.showMessageWithNewLineEnding("Силой взрыва ракете оторвало хвост!");
    }
}
