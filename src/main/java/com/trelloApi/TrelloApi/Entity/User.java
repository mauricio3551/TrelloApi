package com.trelloApi.TrelloApi.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUser;
  @NotBlank (message = "Ingresar usuario")
  private String name;
  @NotBlank (message = "Ingresar contraseña")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String pass;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String key;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String token;
  @NotNull
  private boolean isDev = true;
  @OneToMany(mappedBy = "userCard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference(value = "cardReference")
  private List<Card> cardList = new ArrayList<>();


  public User(String key, String token) {
    this.key = key;
    this.token = token;
  }

  public User() {

  }
}
