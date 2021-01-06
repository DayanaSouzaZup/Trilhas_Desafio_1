package br.com.zup.estrelas.desafioTrilhas.service;

import java.util.List;

import br.com.zup.estrelas.desafioTrilhas.dto.AlteraClienteDTO;
import br.com.zup.estrelas.desafioTrilhas.dto.MensagemDTO;
import br.com.zup.estrelas.desafioTrilhas.entity.Cliente;

public interface IClienteService {
	
	public MensagemDTO adicionaCliente(Cliente cliente);
	
	public Cliente buscaCliente(String cpf);
	
	public List<Cliente> listaClientes();
	
	public MensagemDTO removeCliente(String cpf);
	
	public MensagemDTO alteraCliente(String cpf, AlteraClienteDTO alteraClienteDTO);

}
