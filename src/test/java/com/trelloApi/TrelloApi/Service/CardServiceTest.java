package com.trelloApi.TrelloApi.Service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import com.trelloApi.TrelloApi.Entity.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

  @InjectMocks CardService cardService;
  @Mock RestTemplate restTemplate;
  @Mock Card card;
  private String KEY_ID = "dummy key";
  private String TOKEN_ID = "dummy token";
  private String CARD_ID = "dummy idCard";

  @Test
  void shouldReturnCardWhenCall(){
    when(restTemplate.getForObject("dummy url", Card.class)).thenReturn(card);

    Card result = cardService.getCard(KEY_ID, TOKEN_ID, CARD_ID);

    assertThat(result).isEqualTo(card);
  }
}
