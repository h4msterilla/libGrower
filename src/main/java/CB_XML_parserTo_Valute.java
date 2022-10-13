// https://javarush.ru/groups/posts/656-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---dom

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CB_XML_parserTo_Valute {


    public HashMap<String,Valute> XML_to_valuteMap(StringBuilder sb){

        HashMap<String,Valute> valuteMap= new HashMap<>();

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new ByteArrayInputStream(sb.toString().getBytes("windows-1251")));

            NodeList nodeList = doc.getElementsByTagName("Valute");
            //System.out.println("количество элементов");
            //System.out.println(nodeList.getLength());

            for(int i = 0; nodeList.getLength()>i;i++){
                //System.out.println(nodeList.item(i).getNodeName() + " = " + nodeList.item(i).getTextContent());
                Valute v = getValute(nodeList.item(i));
                valuteMap.put(v.getID(),v);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return valuteMap;
    }


    public Valute getValute(Node node_Valute){

        //System.out.println(node_Valute.getAttributes().getLength());
        //System.out.println(node_Valute.getChildNodes().item(0).getTextContent());

        String ID       = node_Valute.getAttributes().item(0).getTextContent();
        String NumCode  = node_Valute.getChildNodes().item(0).getTextContent();
        String CharCode = node_Valute.getChildNodes().item(1).getTextContent();
        String Nominal  = node_Valute.getChildNodes().item(2).getTextContent();
        String Name     = node_Valute.getChildNodes().item(3).getTextContent();
        String value    = node_Valute.getChildNodes().item(4).getTextContent().replace(",",".");

        return new Valute(ID,NumCode,CharCode,Nominal,Name,value);
    }

}
