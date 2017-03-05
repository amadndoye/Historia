******* Step 1 ***********
Download the latest Derby version from the Apache website http://db.apache.org/derby/. Choose the bin distribution and extract this zip to a directory of your choice.

******************[optional] **************
Also make the Derby tools available in your path:
Set the environment variable DERBY_HOME to the Derby installation directory
Add DERBY_HOME/bin to the "path" environment variable


*************step 2 ************ 
start derby  with command startNetworkServer



**************** step 3 **************************
go to the app dir where located the pom.xml
type the following command : 

mvn clean
mvn install
mvn embedded-glassfish:run

************** step 4 **************

go to http://localhost:8080/Historia

and have fun