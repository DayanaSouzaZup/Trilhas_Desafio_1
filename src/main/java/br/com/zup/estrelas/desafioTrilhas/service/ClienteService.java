package br.com.zup.estrelas.desafioTrilhas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.desafioTrilhas.dto.AlteraClienteDTO;
import br.com.zup.estrelas.desafioTrilhas.dto.MensagemDTO;
import br.com.zup.estrelas.desafioTrilhas.entity.Cliente;
import br.com.zup.estrelas.desafioTrilhas.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{

	private static final String CPF_JÁ_UTILIZADO = "Já existe um cliente com esse CPF";
	private static final String CLIENTE_CADASTRADO_COM_SUCESSO = "Cliente cadastrado com sucesso";
	private static final String CLIENTE_REMOVIDO_COM_SUCESSO = "Cliente removido com sucesso";
	private static final String CLIENTE_INEXISTENTE = "Cliente inexistente";
	private static final String CLIENTE_ALTERADO_COM_SUCESSO = "Cliente alterado com sucesso";

	@Autowired
	ClienteRepository clienteRepository;

	public MensagemDTO adicionaCliente(Cliente cliente) {

		if (cliente.getCpf() != null) {

			if (clienteRepository.existsById(cliente.getCpf())) {
				return new MensagemDTO(CPF_JÁ_UTILIZADO);
			}
		}

		clienteRepository.save(cliente);
		return new MensagemDTO(CLIENTE_CADASTRADO_COM_SUCESSO);
	}

	public Cliente buscaCliente(String cpf) {

		return clienteRepository.findById(cpf).orElse(null);
	}

	public List<Cliente> listaClientes() {

		return (List<Cliente>) clienteRepository.findAll();
	}

	public MensagemDTO removeCliente(String cpf) {

		if (clienteRepository.existsById(cpf)) {

			return new MensagemDTO(CLIENTE_REMOVIDO_COM_SUCESSO);
		}
		return new MensagemDTO(CLIENTE_INEXISTENTE);
	}

	public MensagemDTO alteraCliente(String cpf, AlteraClienteDTO alteraClienteDTO) {

		Optional<Cliente> clienteConsultado = clienteRepository.findById(cpf);

		if (clienteConsultado.isPresent()) {

			Cliente clienteAlterado = clienteConsultado.get();

			clienteAlterado.setNome(alteraClienteDTO.getNome());
			clienteAlterado.setCpf(alteraClienteDTO.getCpf());
			clienteAlterado.setIdade(alteraClienteDTO.getIdade());
			clienteAlterado.setTelefone(alteraClienteDTO.getTelefone());
			clienteAlterado.setEndereco(alteraClienteDTO.getEndereco());
			clienteAlterado.setEmail(alteraClienteDTO.getEmail());

			return new MensagemDTO(CLIENTE_ALTERADO_COM_SUCESSO);
		}
		return new MensagemDTO(CLIENTE_INEXISTENTE);
	}
}
