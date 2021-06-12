package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Classes.CentralDeInformacoes;

public class Persistencia {
	
		private XStream xstream = new XStream(new DomDriver("UTF-8"));
		private File arquivo = new File("arquivo.xml");
	
		
		
		public void salvaCentral(CentralDeInformacoes centralDeInformacoes){ 
			String  xml = xstream.toXML(centralDeInformacoes);
		
				try {
					if(!arquivo.exists())
						arquivo.createNewFile();
					PrintWriter escrever = new PrintWriter(arquivo);
					escrever.write(xml);
					escrever.flush();
					escrever.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	}

		public CentralDeInformacoes recuperarCentral() {		
		
		try {
			if (arquivo.exists()) {
				
					FileInputStream fis = new FileInputStream(arquivo);
					return (CentralDeInformacoes)xstream.fromXML(fis);
					
			}
			
			} catch (FileNotFoundException e) {
				
				
				e.printStackTrace();
			}
		return new CentralDeInformacoes();
		}

		
}
