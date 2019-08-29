package webdemo.entidades;

import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String sobrenome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Usuario(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public static ArrayList<Usuario> GetUsuarios(){
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("Dino", "da Silva Sauro"));
		usuarios.add(new Usuario("Fran", "da Silva Sauro"));
		usuarios.add(new Usuario("Baby", "da Silva Sauro"));
		usuarios.add(new Usuario("Charlene", "da Silva Sauro"));
		usuarios.add(new Usuario("Bob", "da Silva Sauro"));
		usuarios.add(new Usuario("João", "das Neves"));
		usuarios.add(new Usuario("Abominável", "das Neves"));
		
		return usuarios; 
	}

}
