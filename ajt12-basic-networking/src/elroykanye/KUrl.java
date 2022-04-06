package elroykanye;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

public class KUrl {
    private static void createUrl() {
        try {
            URL googleUrl = new URL("https://google.com");

            URL googleUrl2 = new URL(googleUrl, "u/0/?tab=wX");

            System.out.println(googleUrl2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void parseUrl() {
        URL url = null;
        try {
            URL googleUrl = new URL("https://google.com");

            URL googleUrl2 = new URL(googleUrl, "u/0/?tab=wX");

            System.out.println(googleUrl2);
            url = new URL("http://www.uroy.biz:8080/ajp/BasicNetworking/index.html?topic=URL#ParsingURL");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assert url != null;
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Authority: " + url.getAuthority());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Default port: " + url.getDefaultPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());
        System.out.println("File: " + url.getFile());
        System.out.println("Ref: " + url.getRef());
    }

    private static void webpageRetrieve() {
        try {
            URL openRefineUrl = new URL("http://127.0.0.1:3333/");
            int c;
            InputStream in = openRefineUrl.openStream();
            OutputStream out = new FileOutputStream(BasicNetworking.A_FILE.concat("file.html"));

            while((c = in.read()) != -1) {
                out.write(c);
            }

            in.close(); out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void urlConnection() {
        try {
            URL openRefineUrl = new URL("http://127.0.0.1:3333/");
            int c;
            URLConnection connection = openRefineUrl.openConnection();

            InputStream in = connection.getInputStream();
            OutputStream out = new FileOutputStream(BasicNetworking.A_FILE.concat("file2.html"));

            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content Encoding: " + connection.getContentEncoding());
            System.out.println("Content-Length: " + connection.getContentLength());
            System.out.println("Last-Modified: " + connection.getLastModified());
            System.out.println("Date: " + Date.from(Instant.ofEpochMilli(connection.getDate())));
            System.out.println("Expires: " + connection.getExpiration());
            System.out.println("Connection Timeout: " + connection.getConnectTimeout());

            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close(); out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void httpUrlConnection() {
        try {
            URL openRefineUrl = new URL("http://127.0.0.1:3333/");
            int c;

            HttpURLConnection connection = (HttpURLConnection) openRefineUrl.openConnection();
            System.out.println("Request URL: " + openRefineUrl);
            int code = connection.getResponseCode();

            if((code != HttpURLConnection.HTTP_OK) &&
                    (code == HttpURLConnection.HTTP_MOVED_TEMP ||
                    code == HttpURLConnection.HTTP_MOVED_PERM ||
                    code == HttpURLConnection.HTTP_SEE_OTHER)) {
                System.out.println("Response code ... " + code);

                URL newUrl = new URL(connection.getHeaderField("Location"));
                connection = (HttpURLConnection) newUrl.openConnection();
                System.out.println("Redirect to URL ... " + newUrl);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(BasicNetworking.A_FILE.concat("file3.html"))));

            String line;
            StringBuilder htmlStr = new StringBuilder();
            while((line = in.readLine()) != null) {
                htmlStr.append(line);
                out.write(line + "\n");
            }

            System.out.println("Content...\n" + htmlStr);

            in.close(); out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void urlEncodeDecode() {
        String str = "Hello, Elroy Kanye! Wahalä?";
        String encodedStr =  URLEncoder.encode(str, StandardCharsets.UTF_8);
        System.out.println("String: " + str);
        System.out.println("Encoded string: " + encodedStr);

        String decodedStr = URLDecoder.decode(str, StandardCharsets.UTF_8);
        System.out.println("Decoded string: " + decodedStr);
    }

    public static void runner() {
        urlEncodeDecode();
    }
}

