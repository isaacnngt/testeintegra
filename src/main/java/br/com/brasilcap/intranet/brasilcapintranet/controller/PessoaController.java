package br.com.brasilcap.intranet.brasilcapintranet.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilcap.intranet.brasilcapintranet.dto.PessoaDTO;
import br.com.brasilcap.intranet.brasilcapintranet.entity.Pessoa;
import br.com.brasilcap.intranet.brasilcapintranet.repository.ParametroRepository;
import br.com.brasilcap.intranet.brasilcapintranet.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@SuppressWarnings("unused")
	@Autowired
	private ParametroRepository parametroRepository;

	@RequestMapping(value = "aniversariantes/{mes}", method = RequestMethod.GET)
	public List<Pessoa> aniversariantes(@PathVariable Short mes) {

		return pessoaRepository.findAniversariantes(mes);
	}

	@SuppressWarnings("unused")
	@GetMapping("/eu")
	public Pessoa buscaUsuarioLogado(HttpServletRequest request) {
		String userName = request.getRemoteUser();

		userName = "inunes.terceiro";

		if (userName != null) {
			return pessoaRepository.findByUserName(userName);
		} else
			return null;

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Pessoa> getPessoasAll() {
		return pessoaRepository.findPessoasAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/porletra")
	public List<Pessoa> getByLetter(@RequestParam Character letra) {
		return pessoaRepository.findByLetter(letra);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/pornome")
	public List<Pessoa> getByName(@RequestParam String nome) {
		return pessoaRepository.findByName(nome);
	}

	/*@RequestMapping(method = RequestMethod.GET, value = "/equipe")
	public List<PessoaDTO> findSubordinados(@RequestParam String userName) {
		return pessoaRepository.findPorGestor(userName);
	}*/
	
	public List<Pessoa> findSubordinados(String userName) {
	    Pessoa usuario = pessoaRepository.findByUserName(userName);
	    if (usuario != null) {
	        return pessoaRepository.findPorGestors(usuario);
	    } else {
	        // Lida com o caso em que nenhum usuário é encontrado com o nome de usuário fornecido
	        return Collections.emptyList(); // ou lançar uma exceção, ou retornar uma mensagem de erro, etc.
	    }
	}


	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Pessoa getOne(@PathVariable int id) {

		return pessoaRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "otimizado")
	public List<PessoaDTO> getOtimizado() {
		return pessoaRepository.findOtimizado();
	}

	/*
	 * @GetMapping("/foto/{id}") public byte[] getFoto(Integer id) throws Exception
	 * {
	 * 
	 * Pessoa pessoa = pessoaRepository.findById(id);
	 * 
	 * if (pessoa.getTemFoto()) { return pessoa.fotoA(); }
	 * 
	 * Parametro parametro =
	 * parametroRepository.findByChave("INT_FUNCIONARIO_FOTO"); // String chave =
	 * parametroRepository.findByChave2("INT_FUNCIONARIO_FOTO"); String matricula =
	 * String.valueOf(pessoa.getPessoalMatricula().replaceFirst("^0+(?!$)", ""));
	 * String caminho = parametro.getDescConteudoParametro() +
	 * "\\" + matricula + ".jpg";
	 * 
	 * try { java.nio.file.Path path = Paths.get(caminho); byte[] data =
	 * Files.readAllBytes(path); return data; } catch (IOException e) { throw new
	 * Exception("Erro ao ler a foto: " + e.getMessage()); } }
	 */

}
