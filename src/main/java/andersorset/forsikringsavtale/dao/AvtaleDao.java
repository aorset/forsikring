package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Avtale.AvtaleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AvtaleDao {

    @Autowired
    RestClient restClient;

    public Avtale opprettAvtale(int kundeNr, String innhold){
        return restClient.opprettAvtale(new Avtale(kundeNr, innhold));
    }

    public Avtale sendAvtaleTilKunde(Avtale avtale){
        Avtale avtaleMedSendtStatus = restClient.sendAvtaleTilKunde(avtale);
        return avtaleMedSendtStatus;
    }
}
