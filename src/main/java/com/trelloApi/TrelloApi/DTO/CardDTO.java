package com.trelloApi.TrelloApi.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.trelloApi.TrelloApi.Entity.Card;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CardDTO extends Card {

  private String id;
  private List<String> checkItemStates;
  private boolean closed;
  private Date dateLastActivity;
  private String desc;
  private boolean dueReminder;
  private String idBoard;
  private String idList;
  private List<String> idMembersVoted;
  private String idShort;
  private String idAttachmentCover;
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
  private List<String> labels;
  private String shortUrl;
  private Date start;
  private String url;
  private List<String> idMembers;
  private boolean subscribed;
  private List<String> idChecklists;
  private UserDTO userCard;

  public CardDTO(Card card) {
    this.id = card.getId();
    this.checkItemStates = card.getCheckItemStates();
    this.closed = card.isClosed();
    this.dateLastActivity = card.getDateLastActivity();
    this.desc = card.getDesc();
    this.dueReminder = card.isDueReminder();
    this.idBoard = card.getIdBoard();
    this.idList = card.getIdList();
    this.idMembersVoted = card.getIdMembersVoted();
    this.idShort = card.getIdShort();
    this.idAttachmentCover = card.getIdAttachmentCover();
    this.idLabels = card.getIdLabels();
    this.manualCoverAttachment = card.isManualCoverAttachment();
    this.name = card.getName();
    this.pos = card.getPos();
    this.shortLink = card.getShortLink();
    this.isTemplate = card.isTemplate();
    this.cardRole = card.getCardRole();
    this.dueComplete = card.isDueComplete();
    this.due = card.getDue();
    this.email = card.getEmail();
    this.labels = card.getLabels();
    this.shortUrl = card.getShortUrl();
    this.start = card.getStart();
    this.url = card.getUrl();
    this.idMembers = card.getIdMembers();
    this.subscribed = card.isSubscribed();
    this.idChecklists = card.getIdChecklists();
    this.userCard = new UserDTO(card.getUserCard());
  }

  public CardDTO(String id, List<String> checkItemStates, boolean closed, Date dateLastActivity,
      String desc, boolean dueReminder, String idBoard, String idList, List<String> idMembersVoted,
      String idShort, String idAttachmentCover, List<String> idLabels, boolean manualCoverAttachment,
      String name, long pos, String shortLink, boolean isTemplate, String cardRole,
      boolean dueComplete, Date due, String email, List<String> labels, String shortUrl, Date start,
      String url, List<String> idMembers, boolean subscribed, List<String> idChecklists,
      UserDTO userCard){
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
    this.userCard = userCard;
  }
}
