package com.trelloApi.TrelloApi.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardCheckItem {
  private String idCheckItem;
  private String state;

  public CardCheckItem(String idCheckItem, String state) {
    this.idCheckItem = idCheckItem;
    this.state = state;
  }

  public CardCheckItem() {
  }
}
