import java.util.HashMap;

public class Converse_Valutes {


    HashMap<String,Valute> actualCourse;

    public Converse_Valutes(HashMap<String,Valute> valutes){
        actualCourse = valutes;
    }

    public void setActualCourse(HashMap<String,Valute> valutes){
        actualCourse = valutes;
    }

    public double converse (String base_valute_ID, String target_valute_ID, Double base_valute_sum){

        Valute base_valute = actualCourse.get(base_valute_ID);
        double bv_nominal = Double.parseDouble(base_valute.getNominal());
        double bv_value = Double.parseDouble(base_valute.getValue());
        System.out.println(base_valute);

        Valute target_valute = actualCourse.get(target_valute_ID);
        double tv_nominal = Double.parseDouble(target_valute.getNominal());
        double tv_value = Double.parseDouble(target_valute.getValue());
        System.out.println(target_valute);

        return base_valute_sum/bv_nominal/bv_value*tv_value*tv_nominal;
    }

}
