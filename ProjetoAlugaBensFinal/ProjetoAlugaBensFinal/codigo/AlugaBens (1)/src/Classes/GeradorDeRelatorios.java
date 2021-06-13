package Classes;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {
	// gerador de relatorios
	public void gerarRelatorioAlugueis(CentralDeInformacoes c, String nome) {
		try {
			Document documento = new Document();
			PdfWriter.getInstance(documento, new FileOutputStream(nome));
			documento.open();
			for (Locador l : c.getLocadoresCadastrados()) {
				Paragraph paragraphNome = new Paragraph(l.getNome());
				documento.add(paragraphNome);
				for (Bem a : l.getBens()) {
					Paragraph paragrafAluguel = new Paragraph(a.toString());
					documento.add(paragrafAluguel);

				}

			}
			documento.close();

		} catch (DocumentException e) {
			System.err.println(e.getMessage());

		} catch (IOException io) {
			System.err.println(io.getMessage());
		}

	}

}
