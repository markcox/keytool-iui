
====
Required: JDK 1.6.0+
====

====
Resources location:
====

2 projects:
. folder: src/KtlIuiShared (shared project),
. folder: src/KtlIuiMain (main project),

3 internal libraries:
. folder: libs/internal/HelpMain
. folder: libs/internal/ResourceMain
. folder: libs/internal/ResourceShared

7 external libraries:
. BC (BouncyCastle):
  . JAR: libs/external/bcmail138.jar
  . JAR: libs/external/bcprov138.jar
  . JAR: libs/external/bctesp138.jar
. JMF (Java Media Frameworks):
  . JAR: libs/external/jmf211ecor.jar
  . JAR: libs/external/jmf211eplg.jar
. JH (JavaHelp):
  . JAR: libs/external/jhall2005.jar
. JWS (Java WebStart) ATTN: not included in the package, see below:
  . JAR: [jdk.home]/jre/lib/javaws.jar

====
Compile settings:
====

Required libraries:

. KtlIuiShared: 
  . JH library,
  . JWS library,
  . BC library,
  . JMF library
 
 . KtlIuiMain: 
  . JH library,
  . BC library,
  . KtlIuiShared project.

====
KtlIuiMain's runtime settings:
====

Required libraries: 
  . HelpMain library,
  . ResourceMain library,
  . ResourceShared library.

Main class:
	. com.google.code.p.keytooliui.ktl.UIKeytool
  
 