package br.com.fiap.universidade_fiap.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.universidade_fiap.model.Discente;
import br.com.fiap.universidade_fiap.model.EnumNacionalidade;
import br.com.fiap.universidade_fiap.model.EnumNivel;
import br.com.fiap.universidade_fiap.model.EnumStatus;
import br.com.fiap.universidade_fiap.model.Pessoa;
import br.com.fiap.universidade_fiap.repository.DiscenteRepository;
import br.com.fiap.universidade_fiap.repository.PessoaRepository;

@Controller
public class DiscenteController {

	@Autowired
	private DiscenteRepository repD;
	
	@Autowired
	private PessoaRepository repP;

	@GetMapping("/index")
	public ModelAndView popularIndex() {

		ModelAndView mv = new ModelAndView("/home/index");

		List<Discente> discentes = repD.findAll();

		mv.addObject("discentes", discentes);

		return mv;
	}

	@GetMapping("/pessoa/nova")
	public ModelAndView retornarCadPessoa() {

		ModelAndView mv = new ModelAndView("/pessoa/form_cad");
		mv.addObject("pessoa", new Pessoa());
		mv.addObject("lista_nac", EnumNacionalidade.values());
		return mv;

	}
	
	@PostMapping("/insere_pessoa")
	public ModelAndView cadastrarPessoa(Pessoa pessoa) {
		
		Pessoa pes_nova = new Pessoa();
		pes_nova.setNome(pessoa.getNome());
		pes_nova.setCpf(pessoa.getCpf());
		pes_nova.setDataNascimento(pessoa.getDataNascimento());
		pes_nova.setEmail(pessoa.getEmail());
		pes_nova.setNacionalidade(pessoa.getNacionalidade());
		
		repP.save(pes_nova);
		
		Discente discente = new Discente();
		discente.setPessoa(pes_nova);
		discente.setRm(0L);
		discente.setStatus(EnumStatus.A_DEFINIR);
		discente.setNivel(EnumNivel.A_DEFINIR);
		
		repD.save(discente);
		
		return new ModelAndView("redirect:/index");
		
	}
	
	
	@GetMapping("/discente/detalhes/{id}")
	public ModelAndView exibirDetalhes(@PathVariable Long id)
	{
		Optional<Discente> op = repD.findById(id);
		
		if (op.isPresent())
		{
			ModelAndView mv = new ModelAndView("/discente/detalhes");
			// Extraindo o discente encontrado pelo optional
			mv.addObject("discente", op.get());
			return mv;
		}
		else {
			return new ModelAndView("redirect:/index");
		}		
	}
	
	@GetMapping("/discente/editar/{id}")
	public ModelAndView exibirPaginaEdicao(@PathVariable Long id)
	{
		Optional<Discente> op = repD.findById(id);
		
		if (op.isPresent())
		{
			ModelAndView mv = new ModelAndView("/discente/editar");
			// Extraindo o discente encontrado pelo optional
			mv.addObject("discente", op.get());
			mv.addObject("lista_nac", EnumNacionalidade.values());
			mv.addObject("lista_status", EnumStatus.values());
			mv.addObject("lista_niveis", EnumNivel.values());
			
			return mv;
		}
		else {
			return new ModelAndView("redirect:/index");
		}		
	}

	@PostMapping("/discente/atualizar/{id}")
	public ModelAndView atualizarDiscente(@PathVariable Long id, Discente discente_atualizado) {
		
		Optional<Discente> op = repD.findById(id);
		
		if(op.isPresent()) {
			
			Discente discente = op.get();
			discente.transferirDiscente(discente_atualizado);
			repD.save(discente);
			return new ModelAndView("redirect:/index");
			
		} else {
			return new ModelAndView("redirect:/index");
		}
		
	}
 
	
	@GetMapping("/discente/remover/{id}")
	public ModelAndView removerDiscente(@PathVariable Long id) {
		
		Optional<Discente> op = repD.findById(id);
		
		if(op.isPresent()) {
			
			repD.deleteById(id);
			
			return new ModelAndView("redirect:/index");
			
		} else {
			return new ModelAndView("redirect:/index");
		}
		
	}
	
}



