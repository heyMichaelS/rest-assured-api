import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class getTestid {

    // Define um método de teste
    @Test
    public void testGetBookingID() {
// Configura a URL base para as requisições da API
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

// Configura e executa a requisição GET para o endpoint "/booking/"
        given() // Define as configurações da requisição (headers, parâmetros, etc.)
                .header("Accept", "*/*") //adiciona o header accept
                .when() // Indica o início da execução da requisição
                .get("/booking/201") // Especifica o endpoint a ser chamado
                .then() // Define as validações da resposta
                .statusCode(200) // Verifica se o status code da resposta é 200 (OK)
                .body("firstname", equalTo("John"))  // Valida o campo firstname
                .body("lastname", equalTo("Smith"))   // Valida o campo lastname
                .body("totalprice", equalTo(111))   // Verifica se totalprice é maior que 0
                .body("depositpaid", is(true))        // Verifica se depositpaid é true
                .log().all(); // Loga no console todos os detalhes da resposta (body, headers, etc.)
    }
}
