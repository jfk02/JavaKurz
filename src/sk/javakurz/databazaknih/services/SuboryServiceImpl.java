package sk.javakurz.databazaknih.services;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.alignment.VerticalAlignment;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import sk.javakurz.databazaknih.dao.DatabazaKnihDao;

public class SuboryServiceImpl implements SuboryService {

    private DatabazaKnihDao databazaKnihDao;

    private final String cestaKSuborom = "vystupykniznice/";
/*

    private boolean createBackupPath(){
        boolean isCreated = false;
        try {
            File myObj = new File(backupPath);
            myObj.createNewFile();
            isCreated = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    public boolean saveState() {
        boolean isSaved = false;
        createBackupPath();
        try {
            FileOutputStream fileOut = new FileOutputStream(backupPath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(database.getBookData());
            objectOut.close();
            fileOut.close();
            isSaved = true;
            System.out.println("Database state saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the database state.");
            e.printStackTrace();
        }
        return isSaved;
    }

    public boolean loadState() {
        boolean isLoaded = false;
        createBackupPath();
        try {
            FileInputStream fileIn = new FileInputStream(backupPath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            database.setBookData((BookStorage) objectIn.readObject());
            objectIn.close();
            fileIn.close();
            isLoaded = true;
            System.out.println("Database state loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred while loading the database state.");
            e.printStackTrace();
        }
        return isLoaded;
    }








    public boolean openPdfReport(){
        boolean isOpen = false;
        try{
            File file = new File(pdfPath);
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(file);
                isOpen = true;
            }
        }
        catch (DocumentException | IOException e){
            System.out.println("An error occurred while opening the PDF report.");
            e.printStackTrace();
        }
        return isOpen;
    }



*/


    private Table vytvorTabulku() {

        Table tabulkaKnih = new Table(3);
        tabulkaKnih.setPadding(1f);
        tabulkaKnih.setSpacing(0.5f);
        tabulkaKnih.setWidth(100);
        var sirkyStlpcov = new float[]{50f, 40f, 10f};
        tabulkaKnih.setWidths(sirkyStlpcov);

        ArrayList<String> zahlavieTabulky = new ArrayList<>();
        zahlavieTabulky.add("Názov knihy");
        zahlavieTabulky.add("Autor");
        zahlavieTabulky.add("Rok vydania");

        zahlavieTabulky.forEach(e -> {
            Cell current = new Cell(new Phrase(e));
            current.setHeader(true);
            current.setHorizontalAlignment(HorizontalAlignment.CENTER);
            current.setVerticalAlignment(VerticalAlignment.CENTER);
            current.setBackgroundColor(Color.LIGHT_GRAY);
            tabulkaKnih.addCell(current);
        });

        LinkedHashMap<Integer, List<String>> listRiadkov = new LinkedHashMap<>();
        AtomicInteger indexRiadku = new AtomicInteger(1);

        databazaKnihDao.getDatabazaKnihModel()
                .getDatabazaKnih()
                .values()
                .forEach(kniha -> {
                    listRiadkov.put(indexRiadku.get(), Arrays.asList(kniha.getNazov(),
                            kniha.getAutor(),
                            Integer.toString(kniha.getRokVydania())));
                    indexRiadku.incrementAndGet();
                });

        listRiadkov.forEach((index, knihaPodrobosti) -> {
            String aktualnyNazov = knihaPodrobosti.get(0);
            String aktualnyAutor = knihaPodrobosti.get(1);
            String aktualnyRokVydania = knihaPodrobosti.get(2);

            var bunkaNazov = new Cell(new Phrase(aktualnyNazov));
            var bunkaAutor = new Cell(new Phrase(aktualnyAutor));
            var bunkaRokVydania = new Cell(new Phrase(aktualnyRokVydania));

            bunkaNazov.setVerticalAlignment(VerticalAlignment.CENTER);
            bunkaAutor.setVerticalAlignment(VerticalAlignment.CENTER);
            bunkaRokVydania.setVerticalAlignment(VerticalAlignment.CENTER);
            bunkaRokVydania.setHorizontalAlignment(HorizontalAlignment.CENTER);

            tabulkaKnih.addCell(bunkaNazov);
            tabulkaKnih.addCell(bunkaAutor);
            tabulkaKnih.addCell(bunkaRokVydania);
        });

        return tabulkaKnih;
    }

    public void ulozDoPDF() {

        Document zoznamKnihPDF = new Document(PageSize.A4, 40, 40, 40, 40);

        String titulok = "Java Knižnica";
        String textDokumentu = "Z našej knižnice si môžete zapožičať:";

        var zoznamKnih = vytvorTabulku();

        try {
            FileOutputStream pdfOutputFile = new FileOutputStream(cestaKSuborom + "ZoznamKníh.pdf");
            final PdfWriter pdfWriter = PdfWriter.getInstance(zoznamKnihPDF, pdfOutputFile);
            pdfWriter.setPageEvent(new PdfPageEventHelper() {
                @Override
                public void onEndPage(PdfWriter writer, Document document) {
                    PdfContentByte cb = writer.getDirectContent();
                }
            });

            zoznamKnihPDF.open();  // Open the Document

            /* Here we add some metadata to the generated pdf */
            zoznamKnihPDF.addTitle("Java Knižnica");
            zoznamKnihPDF.addSubject("Zoznam kníh dostupných v Java Knižnici");
            zoznamKnihPDF.addKeywords("Java, Knižnica, OpenPDF");
            zoznamKnihPDF.addAuthor("Java Knižnica");
            /* End of the adding metadata section */

            // Create a Font object
            Font titleFont = new Font(Font.COURIER, 20f, Font.BOLDITALIC, Color.BLUE);

            // Create a paragraph with the new font
            Paragraph paragraph = new Paragraph(titulok, titleFont);

            // Element class provides properties to align
            // Content elements within the document
            paragraph.setAlignment(Element.ALIGN_CENTER);

            zoznamKnihPDF.add(paragraph);

            // Adding an empty line
            zoznamKnihPDF.add(new Paragraph(Chunk.NEWLINE));

            // Include the text as content of the pdf
            zoznamKnihPDF.add(new Paragraph(textDokumentu));

            // 4)Finally add the table to the document
            zoznamKnihPDF.add(zoznamKnih);

            zoznamKnihPDF.close();
            pdfWriter.close();
        } catch (IOException de) {
            System.err.println(de.getMessage());
        }
    }

    public SuboryServiceImpl(DatabazaKnihDao databazaKnihDao) {
        this.databazaKnihDao = databazaKnihDao;
    }
}
