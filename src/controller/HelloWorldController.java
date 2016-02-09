package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import repositories.PessoasDAO;
import entities.tbPessoas;
 
@Controller
public class HelloWorldController 
{
	@Autowired PessoasDAO pessoasDAO;
	
	String message = "Welcome to Spring MVC!";
 
	@RequestMapping("/hello")
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name) 
	{
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/cadastrapessoa")
	public String cadastra(@RequestParam(value = "nome") String nome){
		tbPessoas pessoa = new tbPessoas();
		pessoa.setId(15);
		pessoa.setNome(nome);
		pessoasDAO.persist(pessoa);
		return "index";
	}
	
	@RequestMapping("/showpessoas")
	public ModelAndView showPessoas(){
		
		tbPessoas pessoas = pessoasDAO.getAll().get(0);
		
		ModelAndView mv = new ModelAndView("detalhePessoas");
		mv.addObject("nome", pessoas.getNome());
		return mv;
	}
	
	@RequestMapping("/index")
	public String indice()
	{
		return "index";
	}
}