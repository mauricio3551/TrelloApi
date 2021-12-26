package com.trelloApi.TrelloApi.Entity;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Board {
  private String id;
  private String name;
  private String url;
  private Map<String, String> labelNames;

  public Board(String id, String name, String url,
      Map<String, String> labelNames) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.labelNames = labelNames;
  }

  public Board() {
  }
}
