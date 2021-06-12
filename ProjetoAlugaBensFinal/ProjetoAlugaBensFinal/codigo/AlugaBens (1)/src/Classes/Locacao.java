package Classes;

public class Locacao {
	private int prazo;
	private int quant;
	private int codigo;
	private String cpfLocador;
	private Locador locador;
	private Locatario locatario;
	private Bem bem;

	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}

	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

	public String getCpfLocador() {
		return cpfLocador;
	}

	public void setCpfLocador(String cpfLocador) {
		this.cpfLocador = cpfLocador;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Locacao [prazo=" + prazo + ", quant=" + quant + ", codigo=" + codigo + "]";
	}

}
