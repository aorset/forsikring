package andersorset.forsikringsavtale.dao;

import andersorset.forsikringsavtale.controller.RestClient;
import andersorset.forsikringsavtale.model.Kunde;
import org.springframework.stereotype.Repository;

@Repository
public class KundeDao{

    public static final String OPPRETT_KUNDE_URI = "http://localhost:3000/opprettKunde";

    private RestClient restClient = new RestClient();

    public Integer opprettKunde(String navn, String adresse){
        return restClient.postKunde(new Kunde(navn, adresse), OPPRETT_KUNDE_URI).getKundeNr();
    }
}
