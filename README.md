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

    II.i Problem Descriptions
        Problem One-
            This problem I used a database approach. I took in how many names the user wanted to add, and then took the substring of
            this name by extracting the first three digits. I added the functionality that if the name is only two characters long
            it will take those two characters and then add the 3 digit ID code at the end. I also made it so you cannot enter a one
            character long name, because I don't know anyone who has a one letter name, but do know people with the name Xi etc. After
            taking the substring of the names I count how many names like that are already in the databse (adding one to it because
            this is a valid name so we consider it added, for mathematical reasons), and then multiply that number by 5 to create the
            three digit ID. I then go through the MongoDB collection and extract each name as it was entered and output it to the user.
            The information is all saved within the database and carries over from each run of the application on the local machine.

        Problem Two-
            This problem I used the OpenCSV dependency. This made it extremely simple to just grab each element and print it within the
            console and not have to worry about excluding the commas from each line. I used the .skip() method from the OpenCSV API documentation
            to skip to Id, Name, and Address fields listed in the beginning of the file, because the sample output on the problem sheet omitted it
            so I felt it was necessary to do so as well. As always, when finished with the process I closed the CSV reader.

        Problem Three-
            This problem did not need Maven to be executed, although I used it anyway just to package it as a jar easier. I took an Object Oriented
            approach with this problem by creating an abstract Number class, with two child classes as SocialSecurityNumber and PhoneNumber. These
            classes made it easier because they each contained a couple of abstract methods that made the overall main function of the code shorter.
            In each of the classes (SSN and PN) I used a regular expression checker (.match() method) in order to see if the respective number
            they entered only contain numbers rather than special characters or letters etc. The number is then outputted to the user, and the 
            process continues until the user enters Q as wanted. If they enter an invalid choice, it prints out what they entered and prompts them
            that it was an invalid entry. 

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






