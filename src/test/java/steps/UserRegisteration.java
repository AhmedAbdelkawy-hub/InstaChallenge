package steps;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import data.JsonDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterationPage;
import pages.SecurityCodePage;
import tests.TestPase;


public class UserRegisteration extends TestPase {

	RegisterationPage registerationPageobject;
	LoginPage logInPageObject;
	SecurityCodePage securityCodePageObject ;
	ProfilePage profilePageObject;


	@Given("User open Registeration Page")
	public void user_open_registeration_page() {

		 registerationPageobject = new RegisterationPage(driver);
		logInPageObject.OpenRegisterPage();
		Assert.assertTrue(registerationPageobject.IsSignUpBtnDisplay());
	}

	@When("User Enter all registeration data")
	public void user_enter_all_registeration_data() throws JsonIOException, JsonSyntaxException, IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();

		 logInPageObject = new LoginPage(driver);
		 registerationPageobject = new RegisterationPage(driver);
		 securityCodePageObject = new SecurityCodePage(driver);
		 profilePageObject = new ProfilePage(driver);
		logInPageObject.OpenRegisterPage();
		registerationPageobject.userRegisration(jsonReader.Firstname, jsonReader.Lastname, jsonReader.Email,jsonReader.ConfirmEmail, jsonReader.Password);
		securityCodePageObject.EnterSecurityCode(jsonReader.ValidCode);
		profilePageObject.GetWelcomMessaeagonProfile();
	}

	@When("User Click Submit Data")
	public void the_user_enter_all_registeration_data() {

	}

	@Then("User regisered sucess and Message appeared")
	public void the_registeration_page_opend_success() throws IOException, ParseException {
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.JsonReader();

		Assert.assertEquals(securityCodePageObject.GetSuccessMessageAlert(),jsonReader.RegisterMessSuccessText);
		Assert.assertEquals(profilePageObject.GetWelcomMessaeagonProfile(), jsonReader.WelcomeMessageofProfile);
	}

	////////////////////////////////////////////

}
