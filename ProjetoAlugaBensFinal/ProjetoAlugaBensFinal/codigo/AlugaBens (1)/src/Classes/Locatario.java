package Classes;

public class Locatario extends Usuario {
	/// arraylist locatario fazer

	private String cidade;
	private String complemento;
	private String bairro;

	public Locatario(String telefone, String profissao, String Sexo, String cidade, String complemento, String bairro) {

		this.cidade = cidade;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public Locatario() {

	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public static int getCodigo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
