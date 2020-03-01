package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.service.InsuranceService;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/insurance")
public class InsuranceController {

    InsuranceService insuranceService;
    // Opprett avtale ->

    // <- Avtalenummer og status

    @POST
    @Path("/opprett/")
    @Produces(MediaType.APPLICATION_JSON)
    public Avtale getAvtale(){
        insuranceService = new InsuranceService();
        Avtale avtale = insuranceService.opprettAvtale();
        System.out.println("avtale = " + avtale.toString());
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
