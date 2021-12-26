package com.trelloApi.TrelloApi.Service;

import com.trelloApi.TrelloApi.DTO.CardDTO;
import com.trelloApi.TrelloApi.DTO.UserDTO;
import com.trelloApi.TrelloApi.Entity.Card;
import com.trelloApi.TrelloApi.Repository.CardRepository;
import com.trelloApi.TrelloApi.Repository.UserRepository;
import java.util.Random;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardService {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private UserService userService;
  @Autowired
  private CardRepository cardRepository;
  Random random = new Random();


  //Get a specific card
  public Card getCard(String key, String token, String idCard){
    return restTemplate.getForObject(
        "https://api.trello.com/1/cards/"+ idCard + "?key=" + key + "&token=" + token,
        Card.class);
  }

  //Update a specific card
  public void updateCard(Card card, String key, String token, String idCard){
    restTemplate.put(
        "https://api.trello.com/1/cards/" + idCard + "?key=" + key + "&token=" + token, card,
        Card.class);
  }

  //Delete a single card
  public void deleteCard(String key, String token, String idCard){
    restTemplate.delete(
        "https://api.trello.com/1/cards/" + idCard + "?key=" + key + "&token=" + token);
  }

  //Post a single card in a board in a list
  public void postCard(Card card, String key, String token){
    String url =
        "https://api.trello.com/1/cards?key=" + key +
            "&token=" + token +
            "&name="+card.getName()+"&idBoard="+card.getIdBoard()+"&idList="+card.getIdList();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Object> entity = new HttpEntity<Object>(headers);

    CardDTO out = restTemplate.postForObject(url, entity, CardDTO.class);

    List<UserDTO> userList = userService.getListUser();

    UserDTO user = userList.get(random.nextInt(userList.size()));

    user.getCardList().add(out);
    out.setUserCard(user);

    new CardDTO(cardRepository.save(out));
    userService.updateUser(user);

  }

  //post multiple cards in a list
  public void postCardList(List<Card> cards, String key, String token) {
    for (Card c : cards) {
      String url =
          "https://api.trello.com/1/cards?key=" + key +
              "&token=" + token +
              "&name=" + c.getName() + "&idBoard=" + c.getIdBoard() + "&idList=" + c.getIdList();

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      HttpEntity<Object> entity = new HttpEntity<Object>(headers);

      ResponseEntity<String> out = restTemplate.postForEntity(url, entity, String.class);
    }
  }
}
