import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

public class authTest {

        // Define um método de teste
        @Test
        public void testGetBookingAuth() {
// Configura a URL base para as requisições da API
            RestAssured.baseURI = "https://restful-booker.herokuapp.com";

            // Envia a requisição POST para autenticação e valida o token retornado
            given()
                    .header("Content-Type", "application/json")
                    .body("{ \"username\": \"admin\", \"password\": \"password123\" }") // Envia o JSON com as credenciais
                    .when()
                    .post("/auth") // Faz a requisição POST para autenticação
                    .then()
                    .statusCode(200) // Verifica se o status code é 200 (OK)
                    .body("token", notNullValue()) // Verifica se o token foi gerado corretamente
                    .log().all(); // Loga a resposta no console

        }
    }
