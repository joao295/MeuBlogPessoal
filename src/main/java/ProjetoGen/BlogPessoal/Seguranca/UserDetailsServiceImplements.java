package ProjetoGen.BlogPessoal.Seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjetoGen.BlogPessoal.Model.Usuario;
import ProjetoGen.BlogPessoal.Repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {
	
	private @Autowired UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<Usuario> optional = repository.findByUsuario(username);
		
		if (optional.isPresent()) {
			return new UserDetailsImplements (optional.get());

		} else {
			throw new UsernameNotFoundException(username + "Usuario não existe");
		}

	}
}
