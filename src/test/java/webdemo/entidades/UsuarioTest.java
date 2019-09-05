package webdemo.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


//Classe com testes unitários de usuário
//Observe que cada teste unitário testa um aspecto específico de uma determinada funcionalidade
//Por exemplo: 
// - Na recuperação de usuário, testo quando o usuário existe e quando não existe
// - Na inclusão, testo a inclusão na lista geral, a não repetição de id
// - Na atualização, testo a não modificação do ID e a atualização dos campos
//Observe que isto acontece em testes diferentes. E, ainda, observe que, se estou seguindo TDD,
//vou escrevendo cada um destes testes antes da implementação. O teste serve meio que uma "descrição"
//do que meu código vai fazer. E, ainda, testes servem como uma documentação fiel (já que é executável
//e depende do código) do que meu código faz (ou ao menos, do que é esperado que ele faça.
public class UsuarioTest {
	
	@Test
	public void usuario_deve_possuir_id_depois_de_salvo() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		//Execução
		usuario.salvar();
		//Verificação
		assertNotEquals(0, usuario.getId());
	}
	
	@Test
	public void devo_conseguir_recuperar_lista_de_usuarios() {
		//Execução
		List<Usuario> usuarios = Usuario.Todos();
		//Verificação
		assertNotNull(usuarios);
	}
	
	@Test
	public void ao_salvar_novo_usuario_deve_ser_inserido_na_lista() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		int contagemOriginal = Usuario.Todos().size();
		int contagemEsperada = contagemOriginal + 1;
		//Execução
		usuario.salvar();
		//Verificação
		assertEquals(contagemEsperada, Usuario.Todos().size());
	}
	
	@Test
	public void usuarios_nao_podem_ter_mesmo_id() {
		//Configuração
		Usuario usuario1 = new Usuario("Dino", "da Silva Sauro");
		Usuario usuario2 = new Usuario("Fran", "da Silva Sauro");
		//Execução
		usuario1.salvar();
		usuario2.salvar();
		//Verificação
		assertFalse(usuario1.getId() == usuario2.getId());
	}
	
	@Test
	public void devo_conseguir_buscar_usuario_por_id() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		usuario.salvar();
		int id = usuario.getId();
		//Execução
		Usuario usuarioRecuperado = Usuario.GetById(id);
		//Verificação
		assertNotNull(usuarioRecuperado);
		assertEquals(usuario, usuarioRecuperado);
	}
	
	@Test
	public void devo_receber_nulo_quando_usuario_nao_foi_encontrado() {
		//Execução
		Usuario usuarioRecuperado = Usuario.GetById(9999);
		//Verificação
		assertNull(usuarioRecuperado);
	}
	
	@Test
	public void ao_atualizar_usuario_id_deve_permanecer() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		usuario.salvar();
		int idOriginal = usuario.getId();
		//Execução
		usuario.setSobrenome("da Silva Papagaio");
		usuario.salvar();
		//Verificação
		assertEquals(idOriginal, usuario.getId());
	}
	
	@Test
	public void ao_modificar_dados_devem_ser_atualizados() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		usuario.salvar();
		String novoNome = "Corvo";
		String novoSobrenome = "da Silva Papagaio";
		//Execução
		usuario.setNome(novoNome);
		usuario.setSobrenome(novoSobrenome);
		usuario.salvar();
		//Verificação
		Usuario usuarioAtualizado = Usuario.GetById(usuario.getId());
		assertEquals(novoNome, usuarioAtualizado.getNome());
		assertEquals(novoSobrenome, usuarioAtualizado.getSobrenome());
	}
	
	@Test
	public void devo_conseguir_remover_usuario() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		usuario.salvar();
		int quantidadeUsuarios = Usuario.Todos().size();
		int quantidadeEsperada = quantidadeUsuarios - 1;
		//Execução
		usuario.remover();
		//Verificação
		assertEquals(quantidadeEsperada, Usuario.Todos().size());
	}
	
	@Test
	public void ao_remover_nao_devo_conseguir_recuperar_usuario() {
		//Configuração
		Usuario usuario = new Usuario("Dino", "da Silva Sauro");
		usuario.salvar();
		int idUsuario = usuario.getId();
		//Execução
		usuario.remover();
		Usuario usuarioEncontrado = Usuario.GetById(idUsuario);
		//Verificação
		assertNull(usuarioEncontrado);
	}
}
