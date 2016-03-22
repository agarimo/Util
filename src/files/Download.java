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
package files;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agarimo
 */
public class Download {
    
    public static String downloadURL(String enlace) throws MalformedURLException, IOException {
        String inputLine;
        URL link = new URL(enlace);

        BufferedReader in = new BufferedReader(new InputStreamReader(link.openStream()));
        StringBuilder buffer = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            buffer.append(inputLine);
            buffer.append(System.getProperty("line.separator"));
        }
        return buffer.toString();
    }
    
    public static void downloadFILE(String link, File destino) {
        try {
            URL enlace = new URL(link);
            URLConnection connection = enlace.openConnection();
            
            OutputStream out;
            try (InputStream in = connection.getInputStream()) {
                out = new DataOutputStream(new FileOutputStream(destino));
                byte[] buffer = new byte[1024];
                int sizeRead;
                while ((sizeRead = in.read(buffer)) >= 0) {
                    out.write(buffer, 0, sizeRead);
                }
            }
            out.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
