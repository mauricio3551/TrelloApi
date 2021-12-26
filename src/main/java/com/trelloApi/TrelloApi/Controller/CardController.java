package com.trelloApi.TrelloApi.Controller;

import com.trelloApi.TrelloApi.Entity.Card;
import com.trelloApi.TrelloApi.Service.CardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

  @Autowired
  private CardService cardService;

  private BoardControlller boardControlller;

  //Get a specific card
  @GetMapping("api/v1/{key}/{token}/cards/{idCard}")
  public ResponseEntity<Card> getCard
  (@PathVariable String key, @PathVariable String token, @PathVariable String idCard){
    return new ResponseEntity<>(cardService.getCard(key, token, idCard), HttpStatus.ACCEPTED);
  }

  //Update a specific card
  @PutMapping("api/v1/{key}/{token}/cards/{idCard}")
  public HttpStatus updateCard
  (@RequestBody Card card, @PathVariable String key,
      @PathVariable String token, @PathVariable String idCard){
    cardService.updateCard(card, key, token, idCard);
    return HttpStatus.OK;
  }

  //delete a specific card
  @DeleteMapping("api/v1/{key}/{token}/cards/{idCard}")
  public HttpStatus deleteCard
  (@PathVariable String key, @PathVariable String token, @PathVariable String idCard){
    cardService.deleteCard(key, token, idCard);
    return HttpStatus.OK;
  }

  //Post a single card in a board in a list
  @PostMapping("api/v1/{key}/{token}/cards/post")
  public HttpStatus postCard(@RequestBody Card card, @PathVariable String key, @PathVariable String token) {
    cardService.postCard(card, key, token);
    return HttpStatus.OK;
  }

  //post multiple cards in a list
  @PostMapping("api/v1/{key}/{token}/cards/postList")
  public HttpStatus postCardList(@RequestBody List<Card> cards, @PathVariable String key, @PathVariable String token) {
    cardService.postCardList(cards, key, token);
    return HttpStatus.OK;
  }
}
