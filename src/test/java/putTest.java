//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.core.Is.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;
//
//public class putTest {
//
//    private static String token = "";
//    private static int bookingId;
//
//    @BeforeClass
//    public static void setup() {
//        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
//    }
//
//    @Test
//    public void testCreateAndUpdateBooking() throws InterruptedException {
//        //   AUTENTICAÇÃO - Gera o Token
//        token = given()
//                .contentType(ContentType.JSON)
//                .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
//                .when()
//                .post("/auth")
//                .then()
//                .statusCode(200)
//                .extract()
//                .path("token");
//
//        System.out.println("Token gerado: " + token);
//        Thread.sleep(2000); // Aguarde 2s para evitar timeout
//
//        //  CRIAÇÃO DA RESERVA
//        String response = given()
//                .header("Accept", "application/json")
//                .header("Content-Type", "application/json")
//                .header("Connection", "keep-alive")
//                .body("{ " +
//                        "\"firstname\": \"Michael\", " +
//                        "\"lastname\": \"Silva\", " +
//                        "\"totalprice\": 3000, " +
//                        "\"depositpaid\": true, " +
//                        "\"bookingdates\": { " +
//                        "   \"checkin\": \"2018-01-01\", " +
//                        "   \"checkout\": \"2019-01-01\" " +
//                        "}, " +
//                        "\"additionalneeds\": \"Breakfast\" " +
//                        "}")
//                .when()
//                .post("/booking")
//                .then()
//                .statusCode(200)
//                .extract()
//                .asString();
//
//        System.out.println("Resposta da criação da reserva: " + response);
//        bookingId = given()
//                .when()
//                .post("/booking")
//                .then()
//                .extract()
//                .path("bookingid");
//
//        System.out.println("Booking ID criado: " + bookingId);
//        Thread.sleep(2000);
//
//        //     ATUALIZAÇÃO DA RESERVA (PUT)
//        given()
//                .header("Content-Type", "application/json")
//                .header("Accept", "application/json")
//                .header("Connection", "keep-alive")
//                .header("Cookie", "token=" + token) // Tente "Authorization: Bearer " + token se necessário
//                .body("{ " +
//                        "\"firstname\": \"Carlos\", " +
//                        "\"lastname\": \"Silva\", " +
//                        "\"totalprice\": 4000, " +
//                        "\"depositpaid\": false, " +
//                        "\"bookingdates\": { " +
//                        "   \"checkin\": \"2023-05-10\", " +
//                        "   \"checkout\": \"2023-05-20\" " +
//                        "}, " +
//                        "\"additionalneeds\": \"Lunch\" " +
//                        "}")
//                .when()
//                .put("/booking/" + bookingId)
//                .then()
//                .statusCode(200)
//                .body("firstname", equalTo("Carlos"))
//                .body("totalprice", equalTo(4000))
//                .body("depositpaid", is(false))
//                .body("bookingdates.checkin", equalTo("2023-05-10"))
//                .body("bookingdates.checkout", equalTo("2023-05-20"))
//                .log().all();
//
//        System.out.println("Reserva atualizada com sucesso!");
//    }
//}
