package tests;


import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTestUsingDDT extends TestPase {

private LoginPage loginpageObject;

@Test
    public void AssertLoginInFaceBookWithValidData() throws IOException, ParseException {
    JsonDataReader jsonReader = new JsonDataReader();
    jsonReader.JsonReader();
    loginpageObject = new LoginPage(driver);
    loginpageObject.LoginToFacebook(jsonReader.Email,jsonReader.Password);
    Assert.assertTrue(loginpageObject.IsLoginButtonIsDisplay());
}
    @Test
    public void AssertLoginInFaceBookWithInValidData() throws IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        loginpageObject = new LoginPage(driver);
        loginpageObject.LoginToFacebook(jsonReader.InValidEmail,jsonReader.Password);
        Assert.assertTrue(loginpageObject.IsLoginButtonIsDisplay());
    }
}



