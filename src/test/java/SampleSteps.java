package webdemo;

import cucumber.api.java8.En;

public class SampleSteps implements En{

    public SampleSteps() {
        Given("Alice is hungry", () -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new cucumber.api.PendingException();
        });

        When("she eats {int} cucumbers", (Integer int1) -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new cucumber.api.PendingException();
        });

        Then("she will be full", () -> {
            // Write code here that turns the phrase above into concrete actions
            //throw new cucumber.api.PendingException();
        });
    }


}

