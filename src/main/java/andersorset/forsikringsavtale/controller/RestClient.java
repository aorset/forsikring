package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Kunde;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Component
public class RestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    private Client client = ClientBuilder.newClient();

    public Avtale postAvtale(Avtale avtale, String uri){
        try{
            Response res = client
                    .target(uri)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(avtale));
            if(res.getStatus() != 200){
                throw new RuntimeException("Tilkobling feilet ved posting av avtale.");
            }
            return client
                    .target(uri)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(avtale), Avtale.class);
        }catch(RuntimeException e){
            LOGGER.info(e.toString());
            return null;
        }
    }

    public Kunde postKunde(Kunde kunde, String uri) {
        try{
            Response res = client
                    .target(uri)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(kunde));
            if(res.getStatus() != 200){
                throw new RuntimeException("Tilkobling feiled ved posting av kunde.");
            }
            return client
                    .target(uri)
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(kunde), Kunde.class);
        }catch(RuntimeException e){
            LOGGER.info(e.toString());
            return null;
        }
    }
}
