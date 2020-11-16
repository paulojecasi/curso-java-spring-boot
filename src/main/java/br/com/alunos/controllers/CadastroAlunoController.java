package br.com.alunos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alunos.dao.CadastroAlunosDao;
import br.com.alunos.model.Aluno;

@Controller
public class CadastroAlunoController {
	
	@Autowired
	private CadastroAlunosDao alunorepositorio;

	@GetMapping("/inserirAluno")
	public ModelAndView inserirAluno(Aluno addAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CadastroAluno/formAluno");
		mv.addObject("addAluno", new Aluno());
		return mv;
	}
	
	@PostMapping("InsertAlunos")
	public ModelAndView insertAluno(Aluno addAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/alunos-adicionados");
		alunorepositorio.save(addAluno);
		return mv;
	}
	
	@GetMapping("alunos-adicionados")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CadastroAluno/listarAlunos");
		mv.addObject("alunosListagem", alunorepositorio.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CadastroAluno/alterar");
		Aluno alt_aluno = alunorepositorio.getOne(id);
		mv.addObject("aluno", alt_aluno);
		return mv; 
	}
	
	
}
