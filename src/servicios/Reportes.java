package servicios;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JTable;

public class Reportes {

    public void toPdf(JTable tabla, String titulo) throws Exception {
        Document document = new Document();
        try {

            PdfWriter writer;
            writer = PdfWriter.getInstance(document, new FileOutputStream(titulo + ".pdf"));
            document.open();
            
            document.addTitle(titulo);
            document.addAuthor("Martín Alexis Samán Arata");
           
            document.setPageSize(PageSize.A4.rotate());
            document.newPage();

            PdfPTable tblTemp = new PdfPTable(tabla.getColumnCount());
            PdfPCell columnHeader;

            for (int column = 0; column < tabla.getColumnCount(); column++) {
                columnHeader = new PdfPCell(new Phrase(tabla.getColumnName(column)));
                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                tblTemp.addCell(columnHeader);
            }
            tblTemp.setHeaderRows(1);
            for (int row = 0; row < tabla.getRowCount(); row++) {
                for (int column = 0; column < tabla.getColumnCount(); column++) {
                    tblTemp.addCell(tabla.getValueAt(row, column).toString());
                }
            }

            document.add(tblTemp);
            tabla.print();

        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getCause());
        }
        document.close();

    }
}
