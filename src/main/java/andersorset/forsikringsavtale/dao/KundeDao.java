package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KundeDao extends Throwable {

    @Autowired
    RestClient restClient;

    public int opprettKunde(String navn, String adresse) throws Exception{
        Kunde tempKunde = new Kunde(navn, adresse);
        return restClient.opprettKunde(tempKunde).getKundeNr();
    }
}
