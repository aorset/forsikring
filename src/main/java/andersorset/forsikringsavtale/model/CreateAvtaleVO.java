package andersorset.forsikringsavtale.model;

public class CreateAvtaleVO{
    String navn, adresse, avtaleInnhold;

    public CreateAvtaleVO(String navn, String adresse, String avtaleInnhold){
        this.navn = navn;
        this.adresse = adresse;
        this.avtaleInnhold = avtaleInnhold;
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

    public String getAvtaleInnhold() {
        return avtaleInnhold;
    }

    public void setAvtaleInnhold(String avtaleInnhold) {
        this.avtaleInnhold = avtaleInnhold;
    }
}
