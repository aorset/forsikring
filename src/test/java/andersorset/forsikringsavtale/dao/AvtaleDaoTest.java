package andersorset.forsikringsavtale.dao;


import andersorset.forsikringsavtale.infrastructure.ForsikringsavtaleApplication;
import andersorset.forsikringsavtale.model.Avtale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AvtaleDao.class)
class AvtaleDaoTest {

    @Autowired
    private AvtaleDao avtaleDao;

    @Test
    public void testAtAvtaleBlirLagetMedAvtaleNummer() {
        Avtale response = avtaleDao.opprettAvtale(10, "Test-innhold");
        assertNotNull(response.getAvtaleNr());
    }

    @Test
    public void testAtAvtaleBlirSendt(){
        Avtale usendtAvtale  = new Avtale(10,"Test-avtale");
        usendtAvtale.setAvtaleNr(50);
        assertEquals(Avtale.AvtaleStatus.IKKE_SENDT.toString(), usendtAvtale.getAvtaleStatus());
        Avtale response = avtaleDao.sendAvtaleTilKunde(usendtAvtale);
        assertEquals(Avtale.AvtaleStatus.SENDT.toString(), response.getAvtaleStatus());
    }
}
