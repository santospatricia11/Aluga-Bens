package Classes;

import java.util.ArrayList;

public class Locador extends Usuario {

	private ArrayList<Bem> bens = new ArrayList();

	public Locador() {

	}
	public ArrayList<Bem> getBens() {
		return bens;
	}

	public void setBens(ArrayList<Bem> alugueis) {
		this.bens = bens;
	}

}
