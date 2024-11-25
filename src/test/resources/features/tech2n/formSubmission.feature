@SmokeTest2NTECH  @2NTECH @FormSubmission
Feature: Form submission on 2NTECH site

#  @JobApplicationWithRealData
#  Scenario: Successfully fill and submit the job application form
#    When the user provides personal information:
#      | FullName    | Mustafa Ozbir             |
#      | TCNumber    | 45454545455               |
#      | PhoneNumber | 05071234567               |
#      | Email       | ozbirmustafa@hotmail.com  |
#    And the user uploads their CV
#    And the user selects "Lisans" as the education level
#    And the user ensures the KVKK checkbox is selected
#    And the user clicks the next button to navigate to the Add Info tab
#    And the user selects "Test Engineer" as the job position
#    And the user submits the form
#    Then the user verifies the successful submission of the job application

#  Unique Datalarla bir kere başvuru yapılabiliyor. Test ikinci kere çalışınca fail oluyor.
#  Bu yüzden fake data üreten senaryo aşağıdadır.
#  @JobApplicationWithRealData nın çalıştığına dair log ve screenshotlar
#                              logs ve screenshots packageinin altında mevcuttur.

  @JobApplicationWithFakeData
  Scenario: Successfully fill and submit the job application form
    When the user provides fake personal information:
    And the user uploads their CV
    And the user selects "Lisans" as the education level
    And the user ensures the KVKK checkbox is selected
    And the user clicks the next button to navigate to the Add Info tab
    And the user selects "Test Engineer" as the job position
    And the user submits the form
    Then the user verifies the successful submission of the job application