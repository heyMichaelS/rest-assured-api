import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class postTest {

    // Define um método de teste
    @Test
    public void testCreateBooking() {
        // Configura a URL base para as requisições da API
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Envia a requisição POST para criar uma nova reserva
        given()
                .header("Accept", "application/json") // Define que queremos JSON na resposta
                .header("Content-Type", "application/json") // Define que estamos enviando JSON
                .body("{ " +
                        "\"firstname\": \"Michael\", " +
                        "\"lastname\": \"Silva\", " +
                        "\"totalprice\": 3000, " +
                        "\"depositpaid\": true, " +
                        "\"bookingdates\": { " +
                        "   \"checkin\": \"2018-01-01\", " +
                        "   \"checkout\": \"2019-01-01\" " +
                        "}, " +
                        "\"additionalneeds\": \"Breakfast\" " +
                        "}")
                .when()
                .post("/booking") // Faz a requisição POST
                .then()
                .statusCode(200) // Verifica se a reserva foi criada com sucesso
                .body("booking.firstname", equalTo("Michael"))
                .body("booking.lastname", equalTo("Silva"))
                .body("booking.totalprice", equalTo(3000))
                .body("booking.depositpaid", is(true))
                .body("booking.bookingdates.checkin", equalTo("2018-01-01"))
                .body("booking.bookingdates.checkout", equalTo("2019-01-01"))
                .log().all(); // Loga toda a resposta no console
    }
}