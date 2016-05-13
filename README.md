<!---
   @author     Tim Urenda
   @creation   13 May 2016
   @since      Niagara Summit 2016
--->

# Building Niagara 4

You will find the source code for the three demonstrations that were part of the Building Niagara 4 session 
of the Developer Day presented at the Niagara Summit 2016. Each demo is a separate Niagara development 
environment with it's own `build.gradle` file, and each of these environments can be loaded into Intellij
IDEA as separate projects. Each uses the `environment.gradle` file not available in Niagara 4.2 and earlier 
versions, but these can be compiled against earlier Niagara 4 versions. You can copy the modules into 
an existing Niagar 4 development environment, but you will need to run the Gradle tasks from a Niagara 
Console command line. Niagara 4.2 and earlier versions are still dependent on environment variables for 
declaring the Niagara environment.