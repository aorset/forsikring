package andersorset.forsikringsavtale.model;

public class ReturnAvtaleVO{
    String avtaleStatus;
    int avtaleNr;

    public ReturnAvtaleVO(String avtaleStatus, int avtaleNr){
        this.avtaleStatus = avtaleStatus;
        this.avtaleNr = avtaleNr;
    }

    public String getAvtaleStatus() {
        return avtaleStatus;
    }

    public void setAvtaleStatus(String avtaleStatus) {
        this.avtaleStatus = avtaleStatus;
    }

    public int getAvtaleNr() {
        return avtaleNr;
    }

    public void setAvtaleNr(int avtaleNr) {
        this.avtaleNr = avtaleNr;
    }
}
