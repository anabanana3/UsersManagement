package es.uv.adiez.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.uv.adiez.entities.File;
import es.uv.adiez.entities.User;

@Service
public interface FileRepository extends JpaRepository<File, String>{
	
	Optional<File> findByFileId(String fileId);
	List<File> findByOwner(User owner);
	List<File> findByValidator(String validator);

}
