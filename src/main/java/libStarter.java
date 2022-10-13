import java.util.HashMap;

public class libStarter {

    public static void main(String ... args){

        StringBuilder sb = null;

        sb = new CB_connector().get_CB_XML_to_StringBuilder();

        HashMap<String,Valute> valutes = new CB_XML_parserTo_Valute().XML_to_valuteMap(sb);

        System.out.println(new Converse_Valutes(valutes).converse("R01060","R01035",1.0));



    }

}
