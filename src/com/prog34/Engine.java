package com.prog34;

import com.prog34.lib.messageservice.MessageService;

public class Engine {
    boolean damaged = false;

    public void damage() {
        this.damaged = true;
        MessageService.showMessageWithNewLineEnding("Основной двигатель ракеты поврежден!");
    }
}
