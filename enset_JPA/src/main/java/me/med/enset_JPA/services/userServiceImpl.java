package me.med.enset_JPA.services;

import lombok.AllArgsConstructor;
import me.med.enset_JPA.entities.Role;
import me.med.enset_JPA.entities.User;
import me.med.enset_JPA.repositories.RoleRepository;
import me.med.enset_JPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class userServiceImpl implements userService {

    //@Autowired field injection is not recommended

    private UserRepository userRepository;
    //@Autowired field injection is not recommended
    private RoleRepository roleRepository;
    //attention ne mettre pas le constructure sans param ça va créer une confusion pour le spring
    /*public userServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }*/

    @Override
    public User addNewUser(User user) {
        user.setUserid(UUID.randomUUID().toString());
        return  userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
      User user=findUserByUserName(userName);
      Role role=findRoleByRoleName(roleName);
      if(user.getRoles()!=null) {
          user.getRoles().add(role);
          //userRepository.save(user); déja fait commit par @Transactional
      }
        if(role.getUsers()!=null) {
          role.getUsers().add(user);
            //roleRepository.save(role); déja fait commit par @Transactional
        }
          }

    }

