package com.trelloApi.TrelloApi.Controller;

import com.trelloApi.TrelloApi.Entity.User;
import com.trelloApi.TrelloApi.Service.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  //Create user
  @PostMapping("api/v1/user")
  public ResponseEntity<User> createUser(@RequestBody User user){
    return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
  }

  //show single user
  @GetMapping("api/v1/user/{idUser}")
  public ResponseEntity<User> getUser(@PathVariable Long idUser){
    return new ResponseEntity<>(userService.getUser(idUser), HttpStatus.OK);
  }

  //Show list of user
  @GetMapping("api/v1/user")
  public ResponseEntity<List> getListUser(){
    return new ResponseEntity<>(userService.getListUser(), HttpStatus.OK);
  }

  @PutMapping("api/v1/use/{idUser}")
  public ResponseEntity<User> updateUser(@RequestParam Long idUser, @RequestBody User user){
    User newUser = userService.getUser(idUser);
    newUser.setIdUser(idUser);
    newUser.setName(user.getName());
    newUser.setPass(user.getPass());
    newUser.setToken(user.getToken());
    newUser.setKey(user.getKey());

    return new ResponseEntity<>(userService.updateUser(newUser), HttpStatus.CREATED);
  }

  @DeleteMapping("api/v1/use/{idUser}")
  public ResponseEntity<Boolean> deleteUser(@RequestParam Long idUser){
    return new ResponseEntity<>(userService.deleteUser(idUser), HttpStatus.OK);
  }

}
