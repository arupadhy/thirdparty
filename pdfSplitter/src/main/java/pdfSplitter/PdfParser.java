package pdfSplitter;

import java.io.File;

public interface PdfParser {

	File[] splitPdf(File file);
}
