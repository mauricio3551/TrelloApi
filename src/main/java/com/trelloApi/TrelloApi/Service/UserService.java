package com.trelloApi.TrelloApi.Service;

import com.trelloApi.TrelloApi.DTO.UserDTO;
import com.trelloApi.TrelloApi.Entity.User;
import com.trelloApi.TrelloApi.Repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  //Create user
  public UserDTO createUser(User newUser){
    return new UserDTO(userRepository.save(newUser));
  }

  //Get single user
  public UserDTO getUser(Long idUser){
    return new UserDTO(userRepository.getById(idUser));
  }

  //Get list of users
  public List<UserDTO> getListUser(){
    return userRepository.findAll().stream().map(UserDTO :: new).collect(Collectors.toList());
  }

  //Update user
  public UserDTO updateUser(User newUser){
    return new UserDTO(userRepository.save(newUser));
  }

  //Delete user
  public Boolean deleteUser(Long idUser){
    userRepository.deleteById(idUser);
    return true;
  }
}
