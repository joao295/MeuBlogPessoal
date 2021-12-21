package ProjetoGen.BlogPessoal.Repository;






import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoGen.BlogPessoal.Model.Tema;




//* extends JpaRepository ele pega todos os metodos crud 

//*

public interface TemaRepository extends JpaRepository <Tema, Long> {

		public List<Tema> findAllByDescricaoContainingIgnoreCase (String descricao);
	
}
