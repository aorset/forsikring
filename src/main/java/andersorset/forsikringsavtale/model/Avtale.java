package andersorset.forsikringsavtale.model;

public class Avtale {

    public enum AvtaleStatus {
        SENDT,
        IKKE_SENDT
    }

    private Integer kundeNr;
    private Integer avtaleNr;
    private String avtaleStatus;
    private String innhold;

    public Avtale(int kundeNr, String innhold){
        this.kundeNr = kundeNr;
        this.innhold = innhold;
        this.avtaleStatus = AvtaleStatus.IKKE_SENDT.toString();
    }

    public Avtale(){}

    public Integer getKundeNr() {
        return kundeNr;
    }

    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }

    public Integer getAvtaleNr() {
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

    public String getInnhold() {
        return innhold;
    }

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }

    @Override
    public String toString(){
        return "[ avtaleNr: " + avtaleNr + ", kundeNr: " + kundeNr + ", avtaleStatus: " + avtaleStatus + ", innhold: " + innhold + "]";
    }
}
