package ProjetoGen.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import ProjetoGen.BlogPessoal.Model.Usuario;
import ProjetoGen.BlogPessoal.Repository.UsuarioRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		usuarioRepository.save(new Usuario(0L, "João Almeida", "joao@email.com.br", "123456678"));
		usuarioRepository.save(new Usuario(0L, "Manuela Boaz", "Manuela@email.com.br", "123456678"));
		usuarioRepository.save(new Usuario(0L, "Adriano Boaz", "Adriano@email.com.br", "123261678"));
		usuarioRepository.save(new Usuario(0L, "Manoel Boaz", "Manoel@email.com.br", "123262123"));

	}

	@Test
	@DisplayName("Retornar 1 usuario")
	public void deveRetonarUmUsuario()

	{
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}

	@Test
	@DisplayName("Retorna três usuários")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Boaz");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Manuela Boaz"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Adriano Boaz"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Manoel Boaz"));
	}

}
