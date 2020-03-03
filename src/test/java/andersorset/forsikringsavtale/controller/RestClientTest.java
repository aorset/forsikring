package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.dao.AvtaleDao;
import andersorset.forsikringsavtale.dao.KundeDao;
import andersorset.forsikringsavtale.infrastructure.ForsikringsavtaleApplication;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Kunde;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = ForsikringsavtaleApplication.class)
class RestClientTest {

    private RestClient client = new RestClient();

    @Test
    public void testThatNullIsReturnedInsteadOfAvtaleIfRequestUriIsInvalid(){
        assertNull(client.postAvtale(new Avtale(10, "Test-innhold"), "http://localhost:3000/nonExistingUri"));
    }

    @Test
    public void testThatNullIsReturnedInsteadOfKundeIfRequestUriIsInvalid(){
        assertNull(client.postKunde(new Kunde("Test-navn", "Test-adresse"), "http://localhost:3000/nonExistingUri"));
    }

    @Test
    public void testThatKundeNummerIsReturnedIfRequestIsValid(){
        assertNotNull(client.postKunde(new Kunde("Test-navn", "Test-adresse"), KundeDao.OPPRETT_KUNDE_URI));
    }
    @Test
    public void testThatAvtaleGetsAvtaleNummerIfRequestIsValid(){
        assertNotNull(client.postAvtale(new Avtale(10, "Test-innhold"), AvtaleDao.OPPRETT_AVTALE_URI).getAvtaleNr());
    }

}
