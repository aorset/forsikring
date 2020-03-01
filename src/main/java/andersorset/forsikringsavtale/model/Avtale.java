package andersorset.forsikringsavtale.model;

public class Avtale {

    enum AvtaleStatus {
        SENDT,
        IKKE_SENDT
    }

    private int kundeNr;
    private int avtaleNr;
    String avtaleStatus;

    public Avtale(){
        this.kundeNr = 1;
        this.avtaleNr = 1;
        this.avtaleStatus = AvtaleStatus.IKKE_SENDT.toString();
    }

    public int getKundeNr() {
        return kundeNr;
    }

    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }

    public int getAvtaleNr() {
        return avtaleNr;
    }

    public void setAvtaleNr(int avtaleNr) {
        this.avtaleNr = avtaleNr;
    }

    public String getAvtaleStatus() {
        return avtaleStatus;
    }

    public void setAvtaleStatus(String avtaleStatus) {
        this.avtaleStatus = avtaleStatus;
    }
}
