# Introduction #

Steps how to run the Maven JNLP goal to create the necessary Java Webstart files.

# Details #

1. Add the "keytooliui.storepass" and "keytooliui.keypass" properties to your Maven "settings.xml" (located in "{user-home}\.m2\settings.xml")

Example configuration:
```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <profiles>

        <profile>

            <id>inject-user-properties</id>

            <properties>
                <keytooliui.storepass>your-storepass</keytooliui.storepass>
                <keytooliui.keypass>the-keypass</keytooliui.keypass>
            </properties>
        
        </profile>
        
   </profiles>
  
  
    <activeProfiles>
        <activeProfile>inject-user-properties</activeProfile>
    </activeProfiles>
  
</settings>
 
```

2. Run the following Maven command

_From a DOS or SHELL, go to the directory that contains pom.xml file, then type in:_

```
mvn webstart:jnlp
```

3. As a result of the command you will find the JNLP file and the signed JARs in the "target/jnlp" folder

# Tips #

  * Enable "debugging" and "tracing" in the Java Control Panel if you encounter problems starting the app.
  * The default location of the trace and log files is: "<user.home>/.java/deployment/log" on Unix/Linux and "<User Application Data Folder>\Sun\Java\Deployment\log" on Windows.

_MEMO: WebStart cache folder is located at the same level as WebStart log folder. To locate WebStart cache, please open up WebStart viewer: run the following DOS/SHELL command: javaws -viewer ==> "Java Control Panel" shows up. In "General" tab, "Temporary Internet Files", click "Settings..." button_

  * For local testing set the "codebase" attribute to the target JNLP folder - Example:
```
<?xml version="1.0" encoding="utf-8"?>
<jnlp spec="1.0+" codebase="file:///C:/keytool-iui/target/jnlp" href="keytool-iui.jnlp">
   :
</jnlp>
```
> > Then start the JNLP file with a double click.