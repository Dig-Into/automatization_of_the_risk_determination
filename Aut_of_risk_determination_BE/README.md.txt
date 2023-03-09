# Getting Started
1. Java 11 is used for this project. Use [AdoptJDK](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot) if you want.
2. Maven is used for build, but also for liquibase. If not install, you can follow [instructions](https://howtodoinjava.com/maven/how-to-install-maven-on-windows/)
3. MySQL database is currently used. Create a new database named vt_db with utf8 encoding if it doesn't exist.
4. Change parameters in application.properties file as needed.
5. You should now be able to run the project

# Working with Liquibase
Liquibase-Maven can be used to create a changelog file based on the current entities, located in the virtualterminal.model package.
There are two separate liquibase configuration files located in the liquibase/config folder. Change the parameters if needed (especially the connection parameters for the database).

You can then run the plugin using maven from the command prompt (flag -Pdevelopment for the development profile, -Pproduction for the production one)
1. `mvn liquibase:diff -Pdevelopment`
2. Rename the the generated file: liquibase/liquibase-changeLog.xml (describing the changes made, versioning), and include it in the liquibase-masterChangeLog.xml
3. For the changes to take effect:
  1. Run the application or
  2. (Doesn't work for now) Run `mvn liquibase:update -Pdevelopment`

For more information, you can consult this [tutorial](https://blog.quadiontech.com/database-migrations-with-springboot-maven-and-liquibase-9fe7a7b8b8df).

# Installing certificate
This application comes with development self-signed sertificate. It is located in the cert folder. In order to allow
Angular Client to communicate using https, You should install the certificate to the web browser. For Mozzila:
https://support.mozilla.org/en-US/questions/1059377 