package ProjetoGen.BlogPessoal.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoGen.BlogPessoal.Model.Postagem;
import ProjetoGen.BlogPessoal.Repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PostagemController {
	
	
	
@Autowired
private PostagemRepository repository; 


@GetMapping
public ResponseEntity<List<Postagem>> GetAll(){
	
	return ResponseEntity.ok(repository.findAll());
	
	
}

	
@GetMapping("/{id}")	
public Postagem GetById (@PathVariable long id){
return repository.findById(id).get();
	
}
	
	 
@GetMapping("titulo/{titulo}")	
public List <Postagem> GetByTitulo (@PathVariable String titulo){
return repository.findAllByTituloContainingIgnoreCase(titulo);
	
	
}
	
@PostMapping
public Postagem post (@Valid @RequestBody Postagem postagem ){
return repository.save(postagem);
	  
	
}

@PutMapping
public Postagem put (@Valid @RequestBody Postagem postagem ){
return repository.save(postagem);
	  
}


@DeleteMapping ("id/{id}")
public void delete(@PathVariable long id) {
repository.deleteById(id);
}



}
