## Task 1

Please find the Task 1 description below:

### What should be done
When performing a task, you must use the capabilities of Selenium WebDriver, a unit test framework (for example JUnit) and the Page Object concept.

### Automate the following script:

Open https://pastebin.com/ or a similar service in any browser.
Create 'New Paste' with the following attributes:
* Code: "Hello from WebDriver"

* Paste Expiration: "10 Minutes"

* Paste Name / Title: "helloweb"


## Task 2

Please find the Task 2 description below:

### What should be done
When performing a task, you must use the capabilities of Selenium WebDriver, a unit test framework (for example JUnit) and the Page Object concept.

### Automate the following script:

1. Open https://pastebin.com/ or a similar service in any browser.
2. Create 'New Paste' with the following attributes:
    * Code:
      ```bash
      git config --global user.name  "New Sheriff in Town"
      git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
      git push origin master --force
      ```
    * Syntax Highlighting: "Bash"
    * Paste Expiration: "10 Minutes"
    * Paste Name / Title: "how to gain dominance among developers"
3. Save 'paste' and check the following:
    * Browser page title matches 'Paste Name / Title'
    * Syntax is suspended for bash
    * Check that the code matches the one from paragraph 2.


## Task 3

Please find the Task 3 description below:

### What should be done
When performing a task, you must use the capabilities of Selenium WebDriver, a unit test framework (for example JUnit) and the Page Object concept.

### Automate the following script:

1. Open https://cloud.google.com/.
2. Click on the icon at the top of the portal page and enter "Google Cloud Platform Pricing Calculator" into the search field.
3. Perform the search.
4. Click "Google Cloud Platform Pricing Calculator" in the search results and go to the calculator page.
5. Click COMPUTE ENGINE at the top of the page.
6. Fill out the form with the following data:
   * Number of instances: 4
   * What are these instances for?: leave blank
   * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or another User-Provided OS
   * Provisioning model: Regular
   * Machine Family: General purpose
   * Series: N1
   * Machine type: n1-standard-8 (vCPUs: 8, RAM: 30 GB)
   * Select “Add GPUs“
     * GPU type: NVIDIA Tesla V100
     * Number of GPUs: 1
     * Local SSD: 2x375 Gb
   * Datacenter location: Frankfurt (europe-west3)
   * Committed usage: 1 Year
     Other options leave in the default state.
7. Click 'Add to Estimate'.
8. Check the price is calculated in the right section of the calculator. There is a line “Total Estimated Cost: USD ${amount} per 1 month”
9. Click "Share" to see Total estimated cost
10. Click "Open estimate summary" to see Cost Estimate Summary, will be opened in separate tab browser.
11. Verify that the 'Cost Estimate Summary' matches with filled values in Step 6.


#### Notes:
* Dropdown "Datacenter location" was renamed as "Region"
* If GPU type chosen as "NVIDIA Tesla V100" there is no option "Frankfurt (europe-west3)" in Region dropdown (in task was replaced for "Netherlands (europe-west4)")


## Framework

Use your completed Task 3 from the WebDriver module as a precondition for the current task, in which you need to develop a framework based on it, which will include the following features:

1. A WebDriver manager for managing browser connectors
2. Page Object/Page Factory for page abstractions
3. Models for business objects of the required elements
4. Property files with test data for at least two different environments
5. XML suites for smoke tests and other tests
6. If the test fails, a screenshot with the date and time is taken.

