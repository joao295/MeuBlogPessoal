package ProjetoGen.BlogPessoal.Repository;






import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetoGen.BlogPessoal.Model.Tema;




//* extends JpaRepository ele pega todos os metodos crud 

//*
@Repository
public interface TemaRepository extends JpaRepository <Tema, Long> {

		public List<Tema> findAllByDescricaoContainingIgnoreCase (String descricao);
	
}
