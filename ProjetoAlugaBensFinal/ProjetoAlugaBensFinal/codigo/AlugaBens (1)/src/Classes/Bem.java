package Classes;

import java.util.Date;

public class Bem {
	private int codigo;
	private String nome;
	private String descricao;
	private int quant;
	private float valor;
	private String condicao;
	private Date dataDeDevolucao;
	private String locacao;
	private int prazo;
	private boolean disponivel;
	private int quantAlugueis;

	public int getQuantAlugueis() {
		return quantAlugueis;
	}

	public void setQuantAlugueis(int quantAlugueis) {
		this.quantAlugueis = quantAlugueis;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public Date getDataDeDevolucao() {
		return dataDeDevolucao;
	}

	public void setDataDeDevolucao(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getLocacao() {
		return locacao;
	}

	public void setLocacao(String locacao) {
		this.locacao = locacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getDataDeDEvolucao() {
		return dataDeDevolucao;
	}

	public void setDataDoAlugel(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}
}
