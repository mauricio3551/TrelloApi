package com.trelloApi.TrelloApi.Entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Badges {

  private int votes;
  private boolean viewingMemberVoted;
  private boolean subscribed;
  private String fogbugz;
  private Date due;
  private boolean description;
  private int comments;
  private int checkItemsChecked;
  private int checkItems;
  private int attachments;

  public Badges(int votes, boolean viewingMemberVoted, boolean subscribed, String fogbugz,
      Date due, boolean description, int comments, int checkItemsChecked, int checkItems,
      int attachments) {
    this.votes = votes;
    this.viewingMemberVoted = viewingMemberVoted;
    this.subscribed = subscribed;
    this.fogbugz = fogbugz;
    this.due = due;
    this.description = description;
    this.comments = comments;
    this.checkItemsChecked = checkItemsChecked;
    this.checkItems = checkItems;
    this.attachments = attachments;
  }

  public Badges() {
  }
}
