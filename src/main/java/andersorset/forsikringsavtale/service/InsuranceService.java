package andersorset.forsikringsavtale.service;

import andersorset.forsikringsavtale.dao.AvtaleDao;
import andersorset.forsikringsavtale.dao.KundeDao;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Kunde;
import andersorset.forsikringsavtale.model.ReturnAvtaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    AvtaleDao avtaleDao;

    @Autowired
    KundeDao kundeDao;


    public ReturnAvtaleVO opprettAvtale(String kundeNavn, String kundeAdr, String avtaleInnhold){

        // Opprett Kunde
        int kundeNr = kundeDao.opprettKunde(kundeNavn, kundeAdr);

        // Opprett avtale
        Avtale avtale =  avtaleDao.opprettAvtale(kundeNr, avtaleInnhold);

        // Send avtale til kunde
        Avtale sendtAvtale = avtaleDao.sendAvtaleTilKunde(avtale);

        return new ReturnAvtaleVO(sendtAvtale.getAvtaleStatus(), avtale.getAvtaleNr());
    }


}
