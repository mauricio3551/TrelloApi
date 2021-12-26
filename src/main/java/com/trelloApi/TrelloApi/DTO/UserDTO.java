package com.trelloApi.TrelloApi.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.trelloApi.TrelloApi.Entity.Card;
import com.trelloApi.TrelloApi.Entity.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class UserDTO extends User {

  private Long idUser;
  private String name;
  private String pass;
  private String key;
  private String token;
  private boolean isDev = true;
  private List<CardDTO> cardListDTO;

  public UserDTO(User user){
    this.idUser = user.getIdUser();
    this.name = user.getName();
    this.pass = user.getPass();
    this.key = user.getKey();
    this.token = user.getToken();
    this.isDev = isDev();
    this.cardListDTO = takeCard(user);
  }

  private List<CardDTO> takeCard(User user){
    return user.getCardList().stream().map((Card cardList) -> new CardDTO(
        cardList.getId(), cardList.getCheckItemStates(), cardList.isClosed(),
        cardList.getDateLastActivity(), cardList.getDesc(), cardList.isDueReminder(),
        cardList.getIdBoard(), cardList.getIdList(), cardList.getIdMembersVoted(),
        cardList.getIdShort(), cardList.getIdAttachmentCover(), cardList.getIdLabels(),
        cardList.isManualCoverAttachment(), cardList.getName(), cardList.getPos(),
        cardList.getShortLink(), cardList.isTemplate(), cardList.getCardRole(),
        cardList.isDueComplete(), cardList.getDue(), cardList.getEmail(), cardList.getLabels(),
        cardList.getShortUrl(), cardList.getStart(), cardList.getUrl(), cardList.getIdMembers(),
        cardList.isSubscribed(), cardList.getIdChecklists(),
        new UserDTO(cardList.getUserCard().getIdUser()))).collect(Collectors.toList());
  }

  public UserDTO(Long idUser){
    this.idUser = idUser;
  }

}
