package com.trelloApi.TrelloApi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @ElementCollection
  private List<String> checkItemStates;
  private boolean closed;
  private Date dateLastActivity;
  private String desc;
  private boolean dueReminder;
  private String idBoard;
  private String idList;
  @ElementCollection
  private List<String> idMembersVoted;
  private String idShort;
  private String idAttachmentCover;
  @ElementCollection
  private List<String> idLabels;
  private boolean manualCoverAttachment;
  private String name;
  private long pos;
  private String shortLink;
  private boolean isTemplate;
  private String cardRole;
  private boolean dueComplete;
  private Date due;
  private String email;
  @ElementCollection
  private List<String> labels;
  private String shortUrl;
  private Date start;
  private String url;
  @ElementCollection
  private List<String> idMembers;
  private boolean subscribed;
  @ElementCollection
  private List<String> idChecklists;
  @ManyToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  @JsonBackReference(value = "cardReference")
  private User userCard;

  public Card() {
  }

  public Card(String id, List<String> checkItemStates, boolean closed,
      Date dateLastActivity, String desc, boolean dueReminder, String idBoard,
      String idList, List<String> idMembersVoted, String idShort, String idAttachmentCover,
      List<String> idLabels, boolean manualCoverAttachment, String name, long pos,
      String shortLink, boolean isTemplate, String cardRole, boolean dueComplete, Date due,
      String email, List<String> labels, String shortUrl, Date start, String url,
      List<String> idMembers, boolean subscribed,
      List<String> idChecklists) {
    this.id = id;
    this.checkItemStates = checkItemStates;
    this.closed = closed;
    this.dateLastActivity = dateLastActivity;
    this.desc = desc;
    this.dueReminder = dueReminder;
    this.idBoard = idBoard;
    this.idList = idList;
    this.idMembersVoted = idMembersVoted;
    this.idShort = idShort;
    this.idAttachmentCover = idAttachmentCover;
    this.idLabels = idLabels;
    this.manualCoverAttachment = manualCoverAttachment;
    this.name = name;
    this.pos = pos;
    this.shortLink = shortLink;
    this.isTemplate = isTemplate;
    this.cardRole = cardRole;
    this.dueComplete = dueComplete;
    this.due = due;
    this.email = email;
    this.labels = labels;
    this.shortUrl = shortUrl;
    this.start = start;
    this.url = url;
    this.idMembers = idMembers;
    this.subscribed = subscribed;
    this.idChecklists = idChecklists;
  }
}
