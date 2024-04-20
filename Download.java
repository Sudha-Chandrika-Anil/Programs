import java.io.*;
import java.util.*;
import java.net.*;

class Download {

    public static void main(String[] args) throws Exception {

        int c;
        URL u = new URL("https://www.tutorialspoint.com/java/java_tutorial.pdf");
        URLConnection uc = u.openConnection();
        System.out.println("Date: " + new Date(uc.getDate()));
        System.out.println("ContentType: " + uc.getContentType());
        System.out.println("Expires: " + uc.getExpiration());
        System.out.println("Last Modified: " + new Date(uc.getLastModified()));
        int len = uc.getContentLength();
        System.out.println("Content Length: " + len);
        if (len > 0) {
            FileOutputStream fout = new FileOutputStream("test.pdf");
            System.out.println("***********Content********");
            InputStream input = uc.getInputStream();
            int i = 0;
            while (((c = input.read()) != -1) && i < len) {
                fout.write(c); // Write bytes directly to the file
                i++;
            }
            input.close();
            fout.close();
        } else
            System.out.println("No content Available");
    }
}
