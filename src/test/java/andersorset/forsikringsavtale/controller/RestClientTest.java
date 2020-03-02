package andersorset.forsikringsavtale.controller;

import andersorset.forsikringsavtale.infrastructure.ForsikringsavtaleApplication;
import andersorset.forsikringsavtale.model.Avtale;
import andersorset.forsikringsavtale.model.Avtale.AvtaleStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = ForsikringsavtaleApplication.class)
class RestClientTest {

    public static final int HTTP_CREATED = 201;
    private RestClient client = new RestClient();

    @Test
    public void testThatAvtaleIsCreated() {

        Avtale response = client.opprettAvtale(new Avtale(0, AvtaleStatus.IKKE_SENDT, "Test-innhold"));
        System.out.println("response = " + response);

        //assertEquals(response.getStatus(), HTTP_CREATED);
    }
}
