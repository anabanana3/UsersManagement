package es.uv.adiez.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.uv.adiez.entities.File;
import es.uv.adiez.entities.User;
import es.uv.adiez.repositories.FileRepository;
import es.uv.adiez.repositories.UserRepository;

@RestController
@RequestMapping("/fileAPI")
public class FileAPI {
	@Autowired
	private FileRepository fileRepo;
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<File> getFiles() {
		return fileRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public File getById(@PathVariable("id") String id) {
		Optional<File> file = fileRepo.findByFileId(id);
		if(file.isEmpty()) return null;
		return file.get();
	}
	
	@GetMapping("/owner/{owner}")
	public List<File> getByOwner(@PathVariable("owner") String owner) {
		Optional<User> o = userRepo.findByNif(owner);
		List<File> files = fileRepo.findByOwner(o != null ? o.get() : null);
		return files;
	}
	
	@GetMapping("/validator/{validator}")
	public List<File> getByValidator(@PathVariable("validator") String validator) {
		List<File> files = fileRepo.findByValidator(validator);
		return files;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public File create(@RequestBody File file) {
		return fileRepo.save(file);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		fileRepo.deleteById(id);
	}
}
