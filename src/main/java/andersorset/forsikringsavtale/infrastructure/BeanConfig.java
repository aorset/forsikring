package andersorset.forsikringsavtale.infrastructure;

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
