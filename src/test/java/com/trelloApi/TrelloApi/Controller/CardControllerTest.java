package com.trelloApi.TrelloApi.Controller;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.trelloApi.TrelloApi.Entity.Card;
import com.trelloApi.TrelloApi.Service.CardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CardControllerTest {

  @InjectMocks private CardController cardController;
  @Mock private CardService cardService;
  @Mock private Card card;
  private String KEY_ID = "dummy key";
  private String TOKEN_ID = "dummy token";
  private String CARD_ID = "dummy idCard";


  @Test
  void shouldReturnAcceptedWhenGetCardHasAllParams(){
    when(cardService.getCard(KEY_ID, TOKEN_ID, CARD_ID))
        .thenReturn(card);

    ResponseEntity<Card> responseEntity =
        new ResponseEntity<>(card, HttpStatus.ACCEPTED);

    ResponseEntity<Card> result = cardController.getCard(KEY_ID, TOKEN_ID, CARD_ID);

    assertThat(responseEntity).isEqualTo(result);
  }
}
