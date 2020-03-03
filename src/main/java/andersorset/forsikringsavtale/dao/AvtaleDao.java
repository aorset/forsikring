package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Avtale;
import org.springframework.stereotype.Repository;

@Repository
public class AvtaleDao{

    public static final String OPPRETT_AVTALE_URI = "http://localhost:3000/opprettAvtale";
    public static final String SEND_AVTALE_TIL_KUNDE_URI = "http://localhost:3000/sendAvtaleTilKunde";

    RestClient restClient = new RestClient();

    public Avtale opprettAvtale(int kundeNr, String innhold){
        return restClient.postAvtale(new Avtale(kundeNr, innhold), OPPRETT_AVTALE_URI);
    }

    public Avtale sendAvtaleTilKunde(Avtale avtale){
        return restClient.postAvtale(avtale, SEND_AVTALE_TIL_KUNDE_URI);
    }
}
