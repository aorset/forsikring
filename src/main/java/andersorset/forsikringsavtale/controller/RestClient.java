package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Kunde;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

@Component
public class RestClient {
    private static final String OPPRETT_AVTALE_URI = "http://localhost:3000/opprettAvtale";
    private static final String OPPRETT_KUNDE_URI = "http://localhost:3000/opprettKunde";
    private static final String SEND_AVTALE_TIL_KUNDE_URI = "http://localhost:3000/sendAvtaleTilKunde";

    private Client client = ClientBuilder.newClient();

    public Avtale opprettAvtale(Avtale avtale) {

        Avtale avtaleRes = client
                .target(OPPRETT_AVTALE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(avtale), Avtale.class);

        System.out.println("opprettAvtale avtaleRes = " + avtaleRes.toString());

        return avtaleRes;
    }

    public Kunde opprettKunde(Kunde kunde) {
        return client
                .target(OPPRETT_KUNDE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(kunde), Kunde.class);
    }

    public Avtale sendAvtaleTilKunde(Avtale avtale) {

        Avtale avtaleRes = client
                .target(SEND_AVTALE_TIL_KUNDE_URI)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(avtale), Avtale.class);
        System.out.println("sendAvtaleTilKunde avtaleRes = " + avtaleRes.toString());
        return avtaleRes;
    }

}
