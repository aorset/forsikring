package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.CreateAvtaleVO;
import andersorset.forsikringsavtale.model.ReturnAvtaleVO;
import andersorset.forsikringsavtale.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/insurance")
public class InsuranceController {



    @Autowired
    InsuranceService insuranceService;
    // Opprett avtale ->

    // <- Avtalenummer og status

    @POST
    @Path("/opprett/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnAvtaleVO getAvtale(CreateAvtaleVO avtaleVO){
        System.out.println(avtaleVO.getNavn() + " " + avtaleVO.getAdresse() + " " + avtaleVO.getAvtaleInnhold());

        ReturnAvtaleVO avtale = insuranceService.opprettAvtale(
                avtaleVO.getNavn(),
                avtaleVO.getAdresse(),
                avtaleVO.getAvtaleInnhold()
        );

        return avtale;
    }

    @GET
    @Path("/test/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("text/plain")
    public String hello(){
        return "Hello from Spring";
    }


}
