package com.trelloApi.TrelloApi.Repository;

import com.trelloApi.TrelloApi.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
