# MeetPro - An Automated Meeting Booking System By PseudoNerds

## Project Scope

Take your boardroom life online. Your MeetPro account will be a one-stop-solution for creating rooms, scheduling meetings, managing rooms, inviting members, and much more.
The system consists of three types of Users (Employees)

   ***1. Admin -*** Creates and configures meeting room.
  
   ***2. Manager -*** Search and book a room for a meeting.
   
   ***3. Member -*** View meetings in which he/she is part of.
   
## Prerequisite
   
* [Jdk 1.8](https://www.oracle.com/java/technologies/downloads/)
* [Apache Tomcat v9.0](https://tomcat.apache.org/download-90.cgi)
* [Eclipse](https://www.eclipse.org/downloads/)
* [MySQL](https://www.mysql.com/downloads/)
   
## How to run this project into your System:

  1. From the AutomatedMeetingBookingSystem folder, import or clone the project and open it in IDE (Eclipse here).
  2. In database folder in repository there is a file namely: DatabaseScript.txt   
  3. Open MySQL command line and copy/paste and run each query one by one. This will create the database required to run MeetPro.
  4. Paste your MySQL password in line 17 of [DaoUtility.java](https://github.com/AishwaryaaP/pseudonerds/blob/master/AutomatedMeetingBookingSystem/src/main/java/com/AutomatedMeetingBookingSystem/utility/DaoUtility.java).
  5. Using the correct userid and email you can login in the system and run the functionalities defined according to their role.
  6. By logging as Admin, you have right to insert users using xml file which is kept in database folder having titled "users.xml".
  7. The base url of our application is "http://localhost:8080/Codefurry1/Index.jsp"
  8. The MeetPro application is ready to use.


 
   
             
