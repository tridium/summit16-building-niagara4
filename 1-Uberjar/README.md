# DEMO 1: Uberjar

## Setup
- Remove any existing Intellij and Gradle folders (`.idea`, `.gradle`, `gradle`) and files (`gradlew`, `gradlew.bat`)
- Remove the `build` folder in the `barcode-wb` folder
- Set the appropriate values in `environment.gradle`
- All barcode jar files are removed from the `modules` folder
- `module-include.xml` has no entries
- `BBarcodeGenerator` does not have generated slot code

## Execution
- Run Intellij
- Select Import Project
- Navigate to and load the `build.gradle` script
- Select the Gradle wrapper task configuration
- Make sure that a Java 8 JDK is selected for the Gradle JVM
- Use the Project Format = .idea (directory based)
- Open `environment.gradle`: these environment values were set in the New Module Wizard
- Open `vendor.gradle`: it sets the Group and Version elements as they were defined in the New Module Wizard


- Open the `BBarcodeGenerator.java` file
- It contains the code that generates the display for our widget
- It contains the Annotations defined for our widget


- Open the module Gradle file
- It contains the dependency declarations
- Open Gradle Project panel on the right side of Intellij (You might need to select the Tool Buttons from the View menu)
- Run `slot tool` task from the main Gradle project to add properties and type to source code
- Changes should automatically reload into Intellij


- Open `module-include.xml` – it should be mostly empty
- Run `jar` task to generate the type entries
- Changes should automatically reload into Intellij
- Only the types will be added into this file, based on the `NiagaraType` annotations in your code
- You will still need to add agent declarations and other content manually