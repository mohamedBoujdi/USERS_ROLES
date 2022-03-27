package me.med.enset_JPA.services;

import me.med.enset_JPA.entities.Role;
import me.med.enset_JPA.entities.User;
import me.med.enset_JPA.repositories.UserRepository;

public interface userService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String rolename);
    void addRoleToUser(String userName,String rolName);

}
