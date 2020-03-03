package andersorset.forsikringsavtale.model;

import java.util.HashMap;

public class Kunde {

    private Integer kundeNr;
    private HashMap<Integer, Avtale> avtaleHashMap;
    private String navn;
    private String adresse;

    public Kunde(String navn, String adresse){
        this.navn = navn;
        this.adresse = adresse;
    }

    public Kunde(){}

    public void addAvtale(Avtale avtale){
        avtaleHashMap.put(avtale.getAvtaleNr(), avtale);
    }

    public Integer getKundeNr() {
        return kundeNr;
    }

    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }

    public HashMap<Integer, Avtale> getAvtaleHashMap() {
        return avtaleHashMap;
    }

    public void setAvtaleHashMap(HashMap<Integer, Avtale> avtaleHashMap) {
        this.avtaleHashMap = avtaleHashMap;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
