package me.med.enset_JPA;

import me.med.enset_JPA.entities.Role;
import me.med.enset_JPA.entities.User;
import me.med.enset_JPA.repositories.RoleRepository;
import me.med.enset_JPA.repositories.UserRepository;
import me.med.enset_JPA.services.userService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class EnsetJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsetJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner start(userService userService){
		return args -> {
			User user1=new User();
			user1.setUserName("Medo");
			user1.setPassword("password1");
			userService.addNewUser(user1);

			User user2=new User();
			user2.setUserName("Ahmed");
			user2.setPassword("password2");
			userService.addNewUser(user2);


			Stream.of("ADMIN","USER").forEach(
					roleStr->{

						Role role=new Role();
						role.setRoleName(roleStr);
						userService.addNewRole(role);
					}
			);
			userService.addRoleToUser("Ahmed","ADMIN");
			userService.addRoleToUser("Medo","USER");
		};
	}

}
