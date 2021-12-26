package com.trelloApi.TrelloApi.Repository;

import com.trelloApi.TrelloApi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
