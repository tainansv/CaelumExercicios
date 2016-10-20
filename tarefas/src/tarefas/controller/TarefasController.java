package tarefas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tarefas.dao.JdbcTarefaDao;
import tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/novaTarefa")
	public String form(){
		return "tarefas/formulario";
	}
	
	@RequestMapping("/adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		
		if(result.hasFieldErrors("descricao"))
			return "tarefas/formulario";
		
		dao.adiciona(tarefa);
		return "tarefas/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		model.addAttribute("tarefas", dao.lista());
		return "tarefas/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model){
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefas/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa){
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model){
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefas/finalizada";
	}
	
	@RequestMapping("menu")
	public String menu(){
		return "menu";
	}

}
