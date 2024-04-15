package api.test;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
public class DataDrivenTests {

    @Test(priority=1, dataProvider="Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String UserId, String Username, String Firstname, String Lastname, String Email, String Password, String Phone) {

        User userPayload = new User();

        userPayload.setId(Integer.parseInt(UserId));
        userPayload.setUsername(Username);
        userPayload.setFirstName(Firstname);
        userPayload.setLastName(Lastname);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);

        Response response = userEndPoints.createUser(userPayload);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority=2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
    public void tetDeleteUserByName(String UserName){
        Response response = userEndPoints.deleteUser(UserName);
        assertEquals(response.getStatusCode(), 200);
    }
}
