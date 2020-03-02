package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Avtale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AvtaleDao extends Throwable{

    @Autowired
    RestClient restClient;

    public Avtale opprettAvtale(int kundeNr, String innhold) throws Exception{
        return restClient.opprettAvtale(new Avtale(kundeNr, innhold));
    }

    public Avtale sendAvtaleTilKunde(Avtale avtale) throws Exception{
        Avtale avtaleMedSendtStatus = restClient.sendAvtaleTilKunde(avtale);
        return avtaleMedSendtStatus;
    }
}
