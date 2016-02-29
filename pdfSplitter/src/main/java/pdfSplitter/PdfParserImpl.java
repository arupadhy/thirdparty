package pdfSplitter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PdfParserImpl implements PdfParser{
	
	public void parsePdf(String pdf, String txt) throws IOException {
        PdfReader reader = new PdfReader(pdf);
        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
        Rectangle rect = new Rectangle(70, 80, 490, 580);
        RenderFilter filter = new RegionTextRenderFilter(rect);
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            out.println(PdfTextExtractor.getTextFromPage(reader, i, strategy));
        }
        out.flush();
        out.close();
        reader.close();
    }
	

	public static void main(String []args) throws IOException {
		new PdfParserImpl().parsePdf("/Users/arvind/Downloads/jasper.pdf", "/Users/arvind/pdf/parse.txt");
	}
	
	
	public File[] splitPdf(File file) {
		PdfReader reader = null;
		try {
			reader = new PdfReader(file.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		
		// TODO Auto-generated method stub
		return null;
	}

}
