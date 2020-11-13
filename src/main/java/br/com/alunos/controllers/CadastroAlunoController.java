package br.com.alunos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alunos.dao.AddAlunoDao;
import br.com.alunos.model.Aluno;

@Controller
public class CadastroAlunoController {
	
	@Autowired
	private AddAlunoDao alunorepositorio;
	
	@GetMapping("/inserirAluno")
	public ModelAndView InsertAlunos(Aluno addAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CadastroAluno/formAluno");
		mv.addObject("addAluno", new Aluno());
		return mv;
		
	}
	
	@PostMapping("InsertAlunos")
	public ModelAndView addAluno(Aluno addAluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/CadastroAluno/listaAlunos");
		alunorepositorio.save(addAluno);
		return mv;
	}
	
	
}
