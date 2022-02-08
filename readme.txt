#Prerequisites:
1. Install Java/Maven
2. Follow following link
	https://gw4e.github.io/mydoc_install_gw4e_on_top_of_eclipse#option-1---installing-gw4e-with-the-eclipse-marketplace-option

step in point 2:
2a. download jar:
https://github.com/gw4e/gw4e.project/raw/gw-repo-4.0.0/graphwalker-cli-4.0.0-SNAPSHOT.jar
and run following maven commands
mvn install:install-file -Dfile=YOUR_DOWNLOAD_LOCATION/graphwalker-cli-4.0.0-SNAPSHOT.jar -DgroupId=org.graphwalker -DartifactId=graphwalker-cli -Dversion=4.0.0-SNAPSHOT -Dpackaging=jar
mvn install:install-file -Dfile=C:\\Users\\sheetal_singh\\Downloads\\graphwalker-cli-4.0.0-SNAPSHOT.jar -DgroupId=org.graphwalker -DartifactId=graphwalker-cli -Dversion=4.0.0-SNAPSHOT -Dpackaging=jar

2b. install XText and Gef from eclispe > install new software
XText http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/
Gef   http://download.eclipse.org/tools/gef/gef4/updates/releases

2c. Install GW4E Pluggin from Eclipse > marketplace


3. Open eclipse in GW4E Perspective

4. Add selenium-core entry in pom.xml or directly add jar into build path

5. Create a new project
   with Simple.json
   with Java Bases Test
   with All 3 Junit checkbox checked

6. Right click simple.json > GW4E > Generate Java based test cases

7. Run newly generated java class SimpleImpl.java as Junit tests


