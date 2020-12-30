# Revature Project 1: Employee Reimbursement System

  

## Overview
This is a java webapp/site I created for my revature training. It is a site where employees can submit reimbursement requests to their managers and then the managers and approve or deny said requests. 

## Features
- Login system for both employees and managers, with different roles/actions based on which accounts log in
- Managers can register new employee accounts and approve/deny Employee submitted reimbursement requests
- Employees can submit and view transaction requests and update their account information

## Technologies used
- Java with servlets and hibernate for the backend business logic
- AWS PostgreSQL database for storage
- JSPs w/ Bootstrap and servlets for the frontend.
- Server hosted with TomCat

## How to set up with Intellij
1. Clone repo and open it up in IntelliJ
2. Use Smart Tomcat or IntelliJ pro to create a Tomcat configuration and set the deployment directory to 'RevatureProject1/src/main/webapp' and set the Context Path to '/Project1point1'
![Tomcat Config](https://imgur.com/YYqYYEv)
3. Go into the Maven tab of the project and run Maven package to create the WAR.
![Maven](https://imgur.com/OTDp1Uf)
4. Create an AWS Relational Database and change the credentials. Go into the HibernateUtil.java file and change the hibernate configuration options in the GetSessionFactory method
![Hibernate Options](https://imgur.com/lclmuRX)
5. Run the project on the TomCat configuration and the webapp should boot up and hibernate should generate any necessary tables
6. Visit the site on localhost:8080

## Contributors
- Myself (Joseph Feldmann)

## License
[Creative Commons Attribution](https://github.com/idleberg/Creative-Commons-Markdown/blob/master/4.0/by.markdown)
