# DEMO 2: Multi-jar Module

## Setup

- All barcode jar files are removed from the `modules` folder
- A station is available with a simple application, a blank PX page, and a user with the Default Web Profile set to `HTML5HxProfile`
- Set the appropriate values in `environment.gradle`

## Execution

- This module enables the display of point values as barcodes in both PX pages and in bajaux
- There are three runtime profiles
- Load the module into Intellij using the `build.gradle` file similar to demo 1
- Expand the project contents in the Project panel to show the layout of the three module parts
  - The RT module implements a new point type and contains the code to generate the barcode graphic and stores it as an encoded `String` Property
  - The WB module retrieves that Property value and generates the image for the Widget
  - The UX module implements a Field Editor that also gets the Property and displays the barcode


- Run `jar` task
- Start the station
- Start Workbench and connect to the station
- Open the `barcode` palette
- Add the `BarcodeNumeric` component to station and link a signal to the input
- Open the PX page
- Drag the `BarcodeNumeric` into the PX page and associate with `Barcode` widget from the Palette
- Log into the station with the web user, open the Property sheet, and navigate to the `Barcode` component


- Save the PX page and the station
- Close the station and Workbench