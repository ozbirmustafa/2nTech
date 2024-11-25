package com.tech2n.stepDefinitions;

import com.tech2n.pages.AllPagesTech2n;
import com.tech2n.utilities.Tech2nMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static com.common.constants.Constants.FILE_PATH_OF_CV;

public class FormSubmissionStepDefinitions extends AllPagesTech2n {

    private static final Logger logger = LogManager.getLogger(FormSubmissionStepDefinitions.class);

    @When("the user provides personal information:")
    public void the_user_provides_personal_information(DataTable dataTable) {
        Map<String, String> personalInfo = dataTable.asMap(String.class, String.class);

        logger.info("User is providing personal information.");
        personalInfoTab().enterNameSurname(personalInfo.get("FullName"));
        personalInfoTab().enterTcNumber(personalInfo.get("TCNumber"));
        personalInfoTab().enterPhoneNumber(personalInfo.get("PhoneNumber"));
        personalInfoTab().enterEmail(personalInfo.get("Email"));
        logger.info("Personal information entered successfully.");

    }
    @When("the user uploads their CV")
    public void the_user_uploads_their_cv() {
        personalInfoTab().uploadCv(FILE_PATH_OF_CV);
    }
    @When("the user selects {string} as the education level")
    public void the_user_selects_as_the_education_level(String educationLevel) {
        personalInfoTab().chooseEducationDegree(educationLevel);
    }
    @When("the user ensures the KVKK checkbox is selected")
    public void the_user_ensures_the_kvkk_checkbox_is_selected() {
        personalInfoTab().clickKVKKIfIsNotSelected();
        personalInfoTab().verifyKVKKCheckBoxIsSelected();
    }

    @When("the user clicks the next button to navigate to the Add Info tab")
    public void the_user_clicks_the_next_button_to_navigate_to_the_add_info_tab() {
        personalInfoTab().clickNextTabButton();
        logger.info("Successfully navigated to the Additional Info tab.");
    }

    @When("the user selects {string} as the job position")
    public void the_user_selects_as_the_job_position(String jobTitle) {
        otherInfoTab().clickTheJobTitle(jobTitle);
    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        logger.info("Submitting the form.");
        otherInfoTab().submitForm();
        logger.info("Form submitted successfully.");
    }

    @Then("the user verifies the successful submission of the job application")
    public void theUserVerifiesTheSuccessfulSubmissionOfTheJobApplication() {
        logger.info("Verifying successful job application submission.");
        otherInfoTab().verifySuccessMessageVisibility();
        otherInfoTab().verifyJobApplicationSuccessUrl();
        logger.info("Job application submission verified successfully.");
    }

    @When("the user provides fake personal information:")
    public void theUserProvidesFakePersonalInformation() {
        personalInfoTab().createFakeDataForUserInfo();
    }
}
