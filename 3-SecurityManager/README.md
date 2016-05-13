# DEMO 3: Security Manager

## Setup

- All barcode jar files are removed from the `modules` folder
- A station is available with a simple application, a blank PX page, and a user with the Default Web Profile set to `HTML5HxProfile`
- Set the appropriate values in `environment.gradle`

## Execution

### Set the Gradle logging level

- Run the `jar` task – it fails due to a bug in `barcode-wb`
- Set `--debug` in the runtime configuration for the `barcode-wb:jar` task
- Run `jar` again, making sure to have the correct task selected, and run it from the toolbar
- Select Open from the File menu and navigate to `<user>\.gradle\daemon\2.9`
- Open the most recent `daemon.log` file
- Open `barcode-wb.gradle`, set the `runtimeProfile` to `wb`, and re-run the `jar` task

### Create a new build task

- Here we will generate a QR code for use in our module
- Open `barcode-wb.gradle`, and file comments where:
  - We declare a build dependency on a third party jar that generates QR codes using the `buildscript{}` closure
  - We create a new task type in a class that extends the Gradle default task type
  - We declare an instance of that task type
  - We establish a task dependency from an existing `processResources` task on our new task to ensure our task is run during the build
- Run the `qrCode` task in the Gradle Projects panel under `:barcode-wb/other`
- You can see in the Gradle output that the task was run as part of the last build
- Run Workbench
- Open the `barcode` module
- Open the `qrCodes`, then open the file to show the value of the QR code
- Quit Workbench

### Change the build behavior using a Gradle Property definition

- Open the Gradle run configuration for the `barcode-wb:jar` task
- Add `-Pandroid` to the Intellij runtime configuration
- Run the `clean` task from the Gradle project panel
- Run `jar` again, making sure to have the correct task selected, and run it from the toolbar
- Rerun Workbench and show new `qrcode` filename

### Review Permissions Configuration in an example `module-permissions.xml` file

- Open the `module-permissions.xml` file to see permissions details
- Look at the station startup output for Permissions configuration:
  - `INFO [15:24:35 22-Apr-16 EDT][sys] Additional permissions found for module ...`
- Run station and Workbench, view the permissions details in the Spy page

### Set up a unit test with TestNG

- Open `BTestBarcodeNumeric.java` in IntelliJ
- Open `module-includeTest.xml` and see the test class declarations
- Run `clean` on the `barcode-rt` subproject
- Run the `niagaraTest` task on the `barcode-rt` subproject
- Select Open from the File menu, navigate to `<niagaraUserHome>\report\testng`, and open `index.html`
- Click on the Chrome link to view the results
- One test should have failed
- Uncomment the `expectedExceptions` in `BTestBarcodeNumeric` and re-run the `clean` and `niagaraTest` tasks
- Refresh the `index.html` file in Chrome to show all tests passed