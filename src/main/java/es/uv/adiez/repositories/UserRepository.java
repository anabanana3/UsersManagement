package es.uv.adiez.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.uv.adiez.entities.User;

@Service
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByName(String username);
	Optional<User> findByNameAndPassword(String username, String password);
	Optional<User> findByNif(String nif);
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndStatus(String email, User.Status status);
	List<User> findByUserType(User.UserType type);

}