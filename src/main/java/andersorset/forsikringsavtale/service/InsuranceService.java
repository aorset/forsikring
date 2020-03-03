package andersorset.forsikringsavtale.service;
import andersorset.forsikringsavtale.dao.AvtaleDao;
import andersorset.forsikringsavtale.dao.KundeDao;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.ReturnAvtaleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceService.class);

    @Autowired
    private AvtaleDao avtaleDao;

    @Autowired
    private KundeDao kundeDao;

    public ReturnAvtaleVO opprettAvtale(String kundeNavn, String kundeAdr, String avtaleInnhold){

        try{
            // Opprett Kunde
            Integer kundeNr = kundeDao.opprettKunde(kundeNavn, kundeAdr);
            if(kundeNr == null){
                throw new RuntimeException("Kundenummer kunne ikke opprettes");
            }

            // Opprett avtale
            Avtale avtale =  avtaleDao.opprettAvtale(kundeNr, avtaleInnhold);
            if(avtale == null){
                throw new RuntimeException("Avtale kunne ikke opprettes");
            }

            // Send avtale til kunde
            Avtale sendtAvtale = avtaleDao.sendAvtaleTilKunde(avtale);
            if(sendtAvtale == null){
                throw new RuntimeException("Avtale kunne ikke sendes til kunde");
            }

            return new ReturnAvtaleVO(sendtAvtale.getAvtaleStatus(), avtale.getAvtaleNr());

        }catch (Exception e){
            LOGGER.error(e.toString());
            return null;
        }
    }
}
