package br.senai.sp.cadastroclientes.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.cadastroclientes.dao.ClientesDao;
import br.senai.sp.cadastroclientes.dao.ConectionFactory;
import br.senai.sp.cadastroclientes.model.Cliente;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		System.out.println("passou aqui");
		ConectionFactory.conectar();
		return "index";
	}
	
	@RequestMapping(value = "salvarObj", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		ClientesDao dao = new ClientesDao();
		if(cliente.getId() == null) {
			dao.inserir(cliente);
		}else {
			dao.atualizar(cliente);
		}
		return "index";
	}
	
	@RequestMapping("listaClientes")
	public String listar(Model model) {
		ClientesDao dao = new ClientesDao();
		model.addAttribute("clientes", dao.listar());
		return "listacliente";
	}
	
	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		ClientesDao dao = new ClientesDao();
		dao.excluir(idCliente);
		return "redirect:listaClientes";
	}
	
	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		ClientesDao dao = new ClientesDao();
		model.addAttribute("cliente", dao.buscar(idCliente));
		return "forward:/";
	}
	
	/*public void genero(Cliente cliente) {
		int contM = 0, contF = 0;
		long id = cliente.getId();
		for (int i = 0; i = id.length; i++) {
			if()
		}
		
	}*/
	
	@RequestMapping("estatisticas")
	public String estatisticas(Model model) {
		List<Cliente> cliente = new ClientesDao().listar();
		int  contMasc = 0;
		int contFem = 0;
		int contOutros = 0;
		int contJovem = 0;
		int contAduto = 0;
		int contIdoso = 0;
		int segunda = 0;
		int terca = 0;
		int quarta = 0;
		int quinta = 0;
		int sexta = 0;
		int sabado = 0;
		int domingo = 0;
		int manha = 0;
		int tarde = 0;
		int noite = 0;
		
		for (Cliente c : cliente) {
			// contador dos gêneros
			if(c.getGenero().equals("masculino")) {
				contMasc++;
			}else if(c.getGenero().equals("feminino")) {
				contFem++;
			}else {
				contOutros++;
			}
			
			//contador da faixa etária
			if(c.getIdade() <= 17) {
				contJovem++;
			}else if(c.getIdade() <= 59) {
				contAduto++;
			}else {
				contIdoso++;
			}
			
			// dia da semana em que foi cadastrado
			int diaDaSemana = c.getDataCadastro().get(Calendar.DAY_OF_WEEK);
			
			if(diaDaSemana == 1) {
				domingo++;
			}else if(diaDaSemana == 2) {
				segunda++;
			}else if(diaDaSemana == 3) {
				terca++;
			}else if(diaDaSemana == 4) {
				quarta++;
			}else if(diaDaSemana == 5) {
				quinta++;
			}else if(diaDaSemana == 6) {
				sexta++;
			}else {
				sabado++;
			}
			
			// periodo do dia em que foi cadastrado
			int hora = c.getDataCadastro().get(Calendar.HOUR_OF_DAY);
			
			System.out.println("HORA>>>>>>>>"+hora);
			if(hora < 12) {
				manha++;
			}else if(hora < 18) {
				tarde++;
			}else {
				noite++;
			}
			
			
		}
		model.addAttribute("masculino", contMasc);
		model.addAttribute("feminino", contFem);
		model.addAttribute("outros", contOutros);
		model.addAttribute("jovem", contJovem);
		model.addAttribute("adulto", contAduto);
		model.addAttribute("idoso", contIdoso);
		model.addAttribute("segunda", segunda);
		model.addAttribute("terca", terca);
		model.addAttribute("quarta", quarta);
		model.addAttribute("quinta", quinta);
		model.addAttribute("sexta", sexta);
		model.addAttribute("sabado", sabado);
		model.addAttribute("domingo", domingo);
		model.addAttribute("manha", manha);
		model.addAttribute("tarde", tarde);
		model.addAttribute("noite", noite);
		return "contadorestatisticas";
	}
}
