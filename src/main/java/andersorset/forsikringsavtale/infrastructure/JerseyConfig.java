package andersorset.forsikringsavtale.infrastructure;

import andersorset.forsikringsavtale.controller.InsuranceController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
    }
    private void registerEndpoints() {
        register(InsuranceController.class);
    }

}