package ProjetoGen.BlogPessoal.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoGen.BlogPessoal.Model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	 public Optional<Usuario> findByUsuario(String usuario);
	 
	 public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
}
