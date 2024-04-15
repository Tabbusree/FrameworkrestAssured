package api.endpoints;

import api.payload.User;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class userEndPoints2 {

    //method created for getting the url's from properties file
    static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes");  //Load properties file
        return routes;
    }
    //Implementation of create user endpoint
    public static Response createUser(User payload){
        String post_url = getURL().getString("post_url");
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
                .when()
                .post(post_url);

        return response;
    }

    public static Response getUser(String userName){
        String get_url = getURL().getString("get_url");
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(get_url);

        return response;
    }

    public static Response updateUser(String userName, User payload){
        String update_url  = getURL().getString("update_url");
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(update_url);

        return response;
    }

    public static Response deleteUser(String userName){
        String delete_url  = getURL().getString("delete_url");
        Response response = given()
                .pathParam("username", userName)
                .when()
                .delete(delete_url);

        return response;
    }
}
