package ProjetoGen.BlogPessoal.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuarios")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 
	

@NotNull
@Size(min = 2, max = 100)
private String nome;
	

@Size(max = 500,
message = "O link da foto não pode ser maior do que 5000 caractéres")
private String foto;

@Email(message = "O atributo Usuário é Obrigatório!")
@Size(message = "O atributo Usuário deve ser um email válido!")
private String usuario; 

	
@NotBlank
@Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
private String senha;

private String tipo;


@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List<Postagem> postagem;



public Usuario (long id, String nome, String usuario, String senha) {
	
	this.id = id;
	this.nome = nome;
	this.foto = foto;
	this.usuario = usuario;

}


public Usuario () {} 




public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



public String getNome() {
	return nome;
}



public void setNome(String nome) {
	this.nome = nome;
}



public String getUsuario() {
	return usuario;
}



public void setUsuario(String usuario) {
	this.usuario = usuario;
}



public String getSenha() {
	return senha;
}



public void setSenha(String senha) {
	this.senha = senha;
}



public String getFoto() {
	return foto;
}



public void setFoto(String foto) {
	this.foto = foto;
}



public List<Postagem> getPostagem() {
	return postagem;
}



public void setPostagem(List<Postagem> postagem) {
	this.postagem = postagem;
}


public String getTipo() {
	return tipo;
}


public void setTipo(String tipo) {
	this.tipo = tipo;
}




	
	
}
