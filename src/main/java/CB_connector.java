import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CB_connector {

    public StringBuilder get_CB_XML_to_StringBuilder(){

        URL url = null;
        try {
            url = new URL("http://cbr.ru/scripts/XML_daily.asp");// windows-1251
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        StringBuilder content = new StringBuilder();
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"windows-1251"))){
                in.lines().forEach(x -> content.append(x));
            }
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(content.toString());

        return content;
    }

}
