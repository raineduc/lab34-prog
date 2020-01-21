package com.prog34.entries;

import com.prog34.entries.lib.messageservice.MessageService;

public class Engine {
    boolean damaged = false;

    public void damage() {
        this.damaged = true;
        MessageService.showMessageWithNewLineEnding("Основной двигатель ракеты поврежден!");
    }
}
