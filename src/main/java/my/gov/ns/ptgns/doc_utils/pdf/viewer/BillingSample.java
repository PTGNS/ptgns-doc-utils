package my.gov.ns.ptgns.doc_utils.pdf.viewer;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;
import my.gov.ns.ptgns.doc_utils.pdf.AbstractITextPdf;
import my.gov.ns.ptgns.doc_utils.utils.DocColumnUtil;
import my.gov.ns.ptgns.doc_utils.utils.DocFontUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class BillingSample extends AbstractITextPdf {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Resource resource = new ClassPathResource("pdf_template/Billing_Sample.pdf");
        File file = resource.getFile();

        FileInputStream template = new FileInputStream(file);
        PdfReader reader = new PdfReader(template);
        PdfContentByte cb = writer.getDirectContent();

        PdfImportedPage page1 = writer.getImportedPage(reader, 1);
        cb.addTemplate(page1, 0, 0);

        PdfContentByte canvas = writer.getDirectContent();

        // ACCOUNT INFO
        DocColumnUtil.generateColumn(canvas,Element.ALIGN_LEFT, DocFontUtil.defaultNormalFont(),435f,593f, 17.5f, "123456789", "01/01/2022", "001","2", "RM 200.00");

        // BILL ITEMIZATION
        DocColumnUtil.generateColumn(canvas,Element.ALIGN_RIGHT, DocFontUtil.defaultNormalFont(),515f,430f, 18f, "1000.00", "200.00", "3500.00","300.00", "500.00");
        DocColumnUtil.generateColumn(canvas,Element.ALIGN_RIGHT, DocFontUtil.defaultBoldFont(),515f,340f, 18f, "5500.00");

    }
}
