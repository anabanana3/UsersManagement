package es.uv.adiez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.uv.adiez.api.FileAPI;
import es.uv.adiez.api.UserAPI;
import es.uv.adiez.entities.File;
import es.uv.adiez.entities.User;

@SpringBootApplication
public class UsersManagementApplication implements CommandLineRunner {

	@Autowired
	private UserAPI api;
	@Autowired
	private FileAPI fapi;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersManagementApplication.class, args);
	}
	
	@Override
	public void run(String...strings) throws Exception {
		
		generateValidators();
		//generateFiles();
		//System.exit(0);
	}
	
	public void generateValidators() {
		User v1 = api.userById("123456F");
		if(v1 == null) {
				v1 = new User("123456F", "Anabel Diez", "diezmara@alumni.uv.es", "diezmara", User.PersonType.F, User.Status.A, 20 );
				v1.setPassword(new BCryptPasswordEncoder().encode(v1.getPassword()));
				api.createValidator(v1);
		}
		User v2 = api.userById("678912F");
		if(v2 == null) {
				v2 = new User("678912F", "Santiago Lopez", "slopez@alumni.uv.es", "slopez", User.PersonType.F, User.Status.A, 10 );
				v2.setPassword(new BCryptPasswordEncoder().encode(v2.getPassword()));
				api.createValidator(v2);
		}
	}
	
	/*public void generateFiles() {
		File f1 = fapi.getById(1);
		if(f1 == null) {
			User v1 = api.userById("123456F");
			f1 = new File(1, v1, v1, 0, 0);
			fapi.create(f1);
		}
		File f2 = fapi.getById(2);
		if(f2 == null) {
			User v2 = api.userById("678912F");
			f2 = new File(2, v2, v2, 0, 0);
			fapi.create(f2);
		}
	}*/

}
