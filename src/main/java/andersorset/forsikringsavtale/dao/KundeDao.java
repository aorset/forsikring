package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Avtale.AvtaleStatus;
import andersorset.forsikringsavtale.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KundeDao {

    @Autowired
    RestClient restClient;


    public int opprettKunde(String navn, String adresse){
        Kunde tempKunde = new Kunde(navn, adresse);
        return restClient.opprettKunde(tempKunde).getKundeNr();
    }

}
