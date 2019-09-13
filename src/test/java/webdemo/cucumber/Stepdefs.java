package webdemo.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

class IsItFriday {
	static String isItFriday(String today) {
		return "Friday".equals(today) ? "Yep" : "Nope";
	}
}



public class Stepdefs {
	
	private String today;
	private String answer;
	
	@Given("Today is Sunday")
	public void today_is_Sunday() {
	    today = "Sunday";
	}
	
	@Given("Today is Friday")
	public void today_is_Friday() {
		today = "Friday";
	}

	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_Friday_yet() {
		answer = IsItFriday.isItFriday(today);
	}

	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAwsner) {
		assertEquals(expectedAwsner, answer);
	}

}
