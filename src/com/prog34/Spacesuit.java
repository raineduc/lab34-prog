package com.prog34;


import com.prog34.lib.messageservice.MessageService;

public class Spacesuit implements Cargo {
  protected String name;
  public Spacesuit(String name) {
    this.name = name;
  }

  public void takeByShorty(Shorty shorty) {
    shorty.takeCargo(this);
  }

  public void checkByShorty(Shorty shorty) {
    MessageService.showMessageWithNewLineEnding(shorty.getName() + " проверяет целостность скафандра " + name);
  }

  public String getName() {
    return this.name;
  }
}
