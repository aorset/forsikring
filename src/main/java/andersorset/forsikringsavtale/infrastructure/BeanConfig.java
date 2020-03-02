package andersorset.forsikringsavtale.infrastructure;

import andersorset.forsikringsavtale.dao.KundeDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
        "andersorset.forsikringsavtale.controller",
        "andersorset.forsikringsavtale.dao",
        "andersorset.forsikringsavtale.infrastructure",
        "andersorset.forsikringsavtale.model",
        "andersorset.forsikringsavtale.service",
})
@Configuration
public class BeanConfig {

}
