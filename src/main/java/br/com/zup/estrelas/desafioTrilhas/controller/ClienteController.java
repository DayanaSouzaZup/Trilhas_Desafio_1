package br.com.zup.estrelas.desafioTrilhas.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.desafioTrilhas.dto.AlteraClienteDTO;
import br.com.zup.estrelas.desafioTrilhas.dto.MensagemDTO;
import br.com.zup.estrelas.desafioTrilhas.entity.Cliente;
import br.com.zup.estrelas.desafioTrilhas.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@Autowired
//	ClienteService clienteService;

	ClienteService clienteService;

	public ClienteController(ClienteService clienteParametro) {
		this.clienteService = clienteParametro;
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO adicionaCliente(@RequestBody Cliente cliente) {

		return clienteService.adicionaCliente(cliente);
	}

	@GetMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Cliente buscaCliente(@PathVariable String cpf) throws Exception {

		return clienteService.buscaCliente(cpf);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Cliente> listaClientes() {

		return clienteService.listaClientes();
	}

	@DeleteMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO removeCliente(@PathVariable String cpf) {

		return clienteService.removeCliente(cpf);

	}

	@PutMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public MensagemDTO alteraCliente(@PathVariable String cpf, @RequestBody AlteraClienteDTO cliente) {

		return clienteService.alteraCliente(cpf, cliente);
	}

}
