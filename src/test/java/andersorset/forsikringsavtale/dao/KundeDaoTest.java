package andersorset.forsikringsavtale.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = KundeDao.class)
public class KundeDaoTest {

    @Autowired
    private KundeDao kundeDao;

    @Test
    public void testAtKundeBlirOpprettetMedKundeNummer(){
        Integer kundeNr = kundeDao.opprettKunde("Test-navn", "Test-adresse");
        assertNotNull(kundeNr);
    }
}
