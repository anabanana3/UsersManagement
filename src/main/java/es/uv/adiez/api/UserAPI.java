package es.uv.adiez.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.uv.adiez.entities.User;
import es.uv.adiez.entities.User.UserType;
import es.uv.adiez.repositories.UserRepository;

@RestController
@RequestMapping("/userAPI")
public class UserAPI {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/{id}")
	public User userById(@PathVariable("id") String nif) {
		Optional<User> user = userRepo.findByNif(nif);
		if(user.isEmpty()) return null;
		return user.get();
	}
	
	@GetMapping("/name/{name}")
	public User userByName(@PathVariable("name") String name) {
		if(name.contains("_")) name = name.replace("_", " ");
		Optional<User> user = userRepo.findByName(name);
		if(user.isEmpty()) return null;
		return user.get();
	}
	
	
	@GetMapping("/email/{email}")
	public User userByEmail(@PathVariable("email") String email) {
		Optional<User> user = userRepo.findByEmail(email);
		if(user.isEmpty()) return null;
		return user.get();
	}
	@GetMapping("/emailActive/{email}")
	public User userByEmailActive(@PathVariable("email") String email) {
		Optional<User> user = userRepo.findByEmailAndStatus(email, User.Status.A);
		if(user.isEmpty()) return null;
		return user.get();
	}
	
	@GetMapping("/type/{type}")
	public List<User> userByType(@PathVariable("type") UserType type) {
		List<User> users = userRepo.findByUserType(type);
		return users;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") String nif) {
		userRepo.deleteById(nif);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody @Valid User user) {
		return userRepo.save(user);
	}
	
	public User createValidator(User user) {
		user.setUserType(UserType.V);
		User u = userRepo.save(user);
		return u;
	}
	public User createProducer(User user) {
		user.setUserType(UserType.P);
		User u = userRepo.save(user);
		return u;
	}
}
