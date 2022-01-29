package ProjetoGen.BlogPessoal.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoGen.BlogPessoal.Model.Tema;
import ProjetoGen.BlogPessoal.Repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin (origins = "*", allowedHeaders = "*")



public class TemaController {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping 
	public List <Tema> getAll (){	
	return repository.findAll(); 
	}

	
@GetMapping("/{id}")	
public Optional<Tema> GetById (@PathVariable long id){
return repository.findById(id);
	
}	



@GetMapping("nome/{nome}")	
public List <Tema> GetByName (@PathVariable String nome){
return repository.findAllByDescricaoContainingIgnoreCase(nome);

}


	 
@GetMapping("descricao/{descricao}")	
public List <Tema> GetByTitulo (@PathVariable String descricao){
return repository.findAllByDescricaoContainingIgnoreCase(descricao);
	
}


@PostMapping
public Tema post (@Valid @RequestBody Tema tema ){
return repository.save(tema);
	  
	
}

@PutMapping
public Tema put (@Valid @RequestBody Tema tema ){
return repository.save(tema);
	  
}


@DeleteMapping ("/{id}")
public void delete(@PathVariable long id) {
repository.deleteById(id);
}

	
	
}
