# EGTProgrammingChallenge

I. Table of Contents 

    I - Table of Contents
    II - Description
    III - Necessary Technologies


II. Descripiton

This project is part of Edmunds GovTech Programming Challenge given to me. I have completed Problems one, 
two and three in this programming challenge. Within each directory (ProblemOne, ProblemTwo, and 
ProblemThree), there is the same structure, as follows:
   
    src          --> this is a folder that contains all of my .java code
    
    pom.xml      --> this is a .xml file which contains all of my dependencies and has the Maven code which 
                     allows this project to be packaged as a jar and ran simply with one command, as shown 
                     later
    
    0-README.txt --> this is a .txt file which contains the commands you can type (when placing yourself 
                     within the directory of the problem you wish to run, ie within ProblemOne directory)
    
    target       --> this is a folder that contains a couple of sub directories
                    
                target/libs              --> this directory has all the .jar dependencies needed for the 
                                              program to run
    
                target/classes           --> this directory has all the .class files that are compiled from
                                              the .java files
            
                target/maven-archiver    --> this directory has the pom.properties file within it
    
                target/maven-status      --> this directory has a bunch of subdirectories for the maven 
                                             compiler

                target/generated-soruces --> this directory has nothing in it but maven automatically
                                             created it 

To run the programs I used the following commands (This is just an example, use the correct number ie, for problem one use One, Two etc.)
All of the subdirectories have there own 0-README.txt file to show what exact commands you run to run the JAR.

    1. ` mvn clean install package `
    2. ` java -jar target/ProblemOne-0.0.1-SNAPSHOT.jar `
    3. Output will be printed to the console following this step

    Disclaimer --> I am working on a Mac, I tested these programs on an Ubuntu VM and they worked fine. 

III. Necessary Technologies

Some technologies that I used within the programs are the following:

    - MongoDB (Problem 1)
        - The JAR dependencies needed for Mongo within Java (which are downloaded within the repo, and can be via the pom.xml file)
    - OpenCSV (dependency for Problem 2)






