package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Agarimo
 */
public class Ftp {

    FTPClient ftpClient;

    public Ftp(ConexionFtp con) throws IOException {
        ftpClient = new FTPClient();
        ftpClient.connect(con.getHost(), con.getPort());
        ftpClient.login(con.getUser(), con.getPass());
        ftpClient.enterLocalPassiveMode();
    }

    public void close() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }

    public boolean uploadFile(File local, String remote) throws FileNotFoundException, IOException {
        boolean done;
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        try (InputStream inputStream = new FileInputStream(local)) {
            done = ftpClient.storeFile(remote, inputStream);
        }

        return done;
    }

    public boolean downloadFile(String remote, File local) throws FileNotFoundException, IOException {
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        boolean done;
        try (OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(local))) {
            done = ftpClient.retrieveFile(remote, outputStream1);
        }

        return done;
    }

    public boolean createDir(String dir) throws IOException {
        return ftpClient.makeDirectory(dir);
    }

}
