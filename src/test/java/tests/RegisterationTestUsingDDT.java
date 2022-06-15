package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterationPage;
import pages.SecurityCodePage;

import java.io.IOException;

public class RegisterationTestUsingDDT extends TestPase{

    private RegisterationPage registerationPageobject;
    private ProfilePage profilePageObject;
    private LoginPage logInPageObject;
    private SecurityCodePage securityCodePageObject;



    @Test
    public void AssertOpenReisterPage() {

        logInPageObject = new LoginPage(driver);
        registerationPageobject = new RegisterationPage(driver);
        logInPageObject.OpenRegisterPage();
        Assert.assertTrue(registerationPageobject.IsSignUpBtnDisplay());
    }

    @Test
    public void AssertUserCanRegisrationWithValidData()  throws Exception, IOException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();

        logInPageObject = new LoginPage(driver);
        logInPageObject.OpenRegisterPage();
        registerationPageobject = new RegisterationPage(driver);
        securityCodePageObject= new SecurityCodePage(driver);


        registerationPageobject.userRegisration(jsonReader.Firstname, jsonReader.Lastname, jsonReader.Email,jsonReader.ConfirmEmail, jsonReader.Password);
        securityCodePageObject.EnterSecurityCode(jsonReader.ValidCode);
        profilePageObject.GetWelcomMessaeagonProfile();
        Assert.assertEquals(securityCodePageObject.GetSuccessMessageAlert(),jsonReader.RegisterMessSuccessText);
        Assert.assertEquals(profilePageObject.GetWelcomMessaeagonProfile(), jsonReader.WelcomeMessageofProfile);
    }


//    @Test
//    public void AssertUserCanRegisrationWithValidDataa()  {
//
//        logInPageObject = new LoginPage(driver);
//        registerationPageobject = new RegisterationPage(driver);
//       securityCodePageObject= new SecurityCodePage(driver);
//       logInPageObject.OpenRegisterPage();
//       registerationPageobject.userRegisration("Ahmed","Mahmoud","elkawy6@gmail.com","elkawy6@gmail.com","765765786g");
//        securityCodePageObject.EnterSecurityCode("8789798");
//       profilePageObject.GetWelcomMessaeagonProfile();
//      //Assert.assertEquals(securityCodePageObject.GetSuccessMessageAlert(),RegisterMessSuccessText);
//        //Assert.assertEquals(profilePageObject.GetWelcomMessaeagonProfile(), WelcomeMessageofProfile);
//    }

    @Test
    public void AssertUserCanNotRegisrationWithUsedEmail() throws IOException, ParseException  {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        logInPageObject = new LoginPage(driver);
        registerationPageobject = new RegisterationPage(driver);
        securityCodePageObject= new SecurityCodePage(driver);
        logInPageObject.OpenRegisterPage();
        registerationPageobject.userRegisration(jsonReader.Firstname, jsonReader.Lastname, jsonReader.InValidEmail,jsonReader.ConfirmEmail, jsonReader.Password);
        Assert.assertEquals(registerationPageobject.GetRegisterMessFailed(),jsonReader.RegisterMessFailedText);
    }
    @Test
    public void AssertUserCanNotRegisrationWithWithWrongCode() throws IOException, ParseException  {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();
        logInPageObject = new LoginPage(driver);
        registerationPageobject = new RegisterationPage(driver);
        securityCodePageObject= new SecurityCodePage(driver);
        logInPageObject.OpenRegisterPage();
        registerationPageobject.userRegisration(jsonReader.Firstname, jsonReader.Lastname, jsonReader.Email,jsonReader.ConfirmEmail,jsonReader.Password);
        securityCodePageObject.EnterSecurityCode(jsonReader.InValidCode);
        Assert.assertEquals(securityCodePageObject.GetFailedMessageAlert(),jsonReader.WrongMessageCode);
    }
}
