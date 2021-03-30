package br.com.alunos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.alunos.dao.AlunosDao;
import br.com.alunos.model.Aluno;

@Controller
public class AlunoController {
	
	@Autowired    //--------- com essa anotação, posso injetar dependencia sem precisar instanciar a interface  
	private AlunosDao alunorepositorio;
	
	private ModelAndView mv= new ModelAndView();
 
	
	
	@GetMapping("/viewInserirAluno")
	public ModelAndView viewInserirAluno(Aluno addAluno) {
		mv.setViewName("CadastroAluno/formAluno");
		mv.addObject("addAluno", new Aluno());
		return mv;
	}
	
	/*POST SEM TRATAMENTO DE ERRO NO FORMULARIO - PJCS
	@PostMapping("inserirAluno")
	public ModelAndView inserirAluno(Aluno addAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/alunos-adicionados");
		alunorepositorio.save(addAluno);
		return mv;
	}
	*/
	
	//POST COM TRATAMENTO DE ERRO NO FORMULARIO 
	@PostMapping("inserirAluno")
	public ModelAndView inserirAluno(@Valid Aluno addAluno, BindingResult verErrors) {
		if (verErrors.hasErrors()){
			mv.setViewName("CadastroAluno/formAluno");
			mv.addObject("addAluno");
		}else {
			mv.setViewName("redirect:/alunos-adicionados");
			alunorepositorio.save(addAluno);
		}
		return mv;
	}
	
	@GetMapping("alunos-adicionados")
	public ModelAndView listagemAlunos() {
		mv.setViewName("CadastroAluno/listarAlunos");
		mv.addObject("titulo","Listagem dos Ultimos Alunos Cadastrados"); 
		mv.addObject("alunosListagem", alunorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/viewAlterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer idAluno) {
		mv.setViewName("CadastroAluno/alterar");
		Aluno alt_aluno = alunorepositorio.getOne(idAluno);
		mv.addObject("altAluno", alt_aluno);
		return mv; 
	}
	
	@PostMapping("/alterarAluno")
	public ModelAndView alterarAluno(Aluno altAluno) {
		alunorepositorio.save(altAluno);
		mv.setViewName("redirect:/alunos-adicionados");
		return mv; 
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluiAluno(@PathVariable("id") Integer idAluno) {
		alunorepositorio.deleteById(idAluno);
		return "redirect:/alunos-adicionados";
	}

	
	@GetMapping("/viewPesquisaAlunos")
	public ModelAndView pesquisaAlunos() {
		mv.setViewName("CadastroAluno/pesquisaAlunos");
		return mv; 
	}
	
	@GetMapping("alunos-ativos")
	public ModelAndView listagemAlunosAtivos() {
		mv.setViewName("CadastroAluno/listarAlunos");
		mv.addObject("titulo","Listagem de Alunos Ativos"); 
		mv.addObject("alunosListagem", alunorepositorio.findByStatusAtivos());
		return mv;
	}
	
	@GetMapping("alunos-inativos")
	public ModelAndView listagemAlunosInativos() {
		mv.setViewName("CadastroAluno/listarAlunos");
		mv.addObject("titulo","Listagem de Alunos Inativos"); 
		mv.addObject("alunosListagem", alunorepositorio.findByStatusInativos());
		return mv;
	}
	
	
	
	
}
