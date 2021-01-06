package br.com.zup.estrelas.desafioTrilhas.dto;

public class MensagemDTO {

	private String mensagem;

	public MensagemDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null)
			return false;
		if (getClass() != objeto.getClass())
			return false;
		MensagemDTO other = (MensagemDTO) objeto;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

}
