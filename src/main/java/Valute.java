public class Valute {

    String ID;
    String NumCode;
    String CharCode;
    String Nominal;
    String Name;
    String value;

    public Valute(String ID, String numCode, String charCode, String nominal, String name, String value) {
        this.ID = ID;
        NumCode = numCode;
        CharCode = charCode;
        Nominal = nominal;
        Name = name;
        this.value = value;
    }

    @Override
    public String toString(){
        return "ID = " + ID + " NumCode = " + NumCode + " CharCode = " + CharCode + " Nominal = " + Nominal + " Name = " + Name + " value = " + value;
    }

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return value;
    }
}
