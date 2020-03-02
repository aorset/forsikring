package andersorset.forsikringsavtale.controller;

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

    @POST
    @Path("/opprett/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnAvtaleVO getAvtale(CreateAvtaleVO avtaleVO){
        return insuranceService.opprettAvtale(
                avtaleVO.getNavn(),
                avtaleVO.getAdresse(),
                avtaleVO.getAvtaleInnhold()
        );
    }
}
