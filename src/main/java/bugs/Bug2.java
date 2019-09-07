package bugs;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import java.io.IOException;

public class Bug2 {

    public static void main(String args[]) throws IOException {

      PdfReader reader = new PdfReader("empty.pdf");
      PdfWriter writer = new PdfWriter("out.pdf");
      PdfDocument doc = new PdfDocument(reader, writer, new StampingProperties().preserveEncryption().useAppendMode());
      PdfFont font = PdfFontFactory.createFont("bugs/LiberationSans-Regular.ttf", PdfEncodings.IDENTITY_H, true);
      PdfPage page = doc.getPage(1);
      PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), doc);
      canvas.beginText();
      canvas.setFontAndSize(font, 512);
      canvas.setTextMatrix(150, 200);
      canvas.showText("š");
      canvas.endText();
      canvas.release();
      doc.close();
    }
}
