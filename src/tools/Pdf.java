/*
 * The MIT License
 *
 * Copyright 2016 Agarimo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tools;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Agarimo
 */
public class Pdf {

    public static void convertPDF(File origen, File destino) throws IOException {
        destino.createNewFile();

        FileWriter fw = new FileWriter(destino.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);
        PdfReader pr = new PdfReader(origen.getAbsolutePath());
        int pNum = pr.getNumberOfPages();
        for (int page = 1; page <= pNum; page++) {
            String text = PdfTextExtractor.getTextFromPage(pr, page);
            bw.write(text);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();
        pr.close();

        convertPDFFixFile(destino);
    }

    private static void convertPDFFixFile(File aux) {
        String datos = LoadFile.readFile(aux);
        LoadFile.writeFile(aux, datos);
    }
}
