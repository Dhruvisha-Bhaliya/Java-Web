# Enterprice Java : --

- First Download Payara Server Community Edition 6.2025.7(Full) -> [https://www.payara.fish/downloads/payara-platform-community-edition/]

# How to Create project When using Servlet :--
- Apache Netbeans 25 -> New Project -> Java with Maven -> Web Application -> Payara Server -> Jakarata EE 10 Web ->Source Packages ->Servlet Package -> Servlet.java
  (If Network not Available then Java with Ant -> Java Web -> Web Application)

# How to add dependencies :---
- in mavenproject -> Project Files ->
- **pom.xml** :-- Add below Dependencies  
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.47</version>
      <scope>provided</scope>            
  </dependency>

=> mysql-connector-java is the official MySQL JDBC driver.It allows your Servlet (Java code) to connect to a MySQL database.

=> Adding this dependency makes Maven download the MySQL driver jar and put it in project’s classpath.

=> add this dependency so Servlet can connect and interact with a MySQL database.

# How to perform CRUD using Servlet
- in mavenproject -> Source Package -> new package create -> model ->OptimizedLogic.java :-
  
! Model :----------  

[1] **OptimizedLogic.java** :-- 
=> Above class is a Data Access Layer (DAL) or DAO (Data Access Object).It acts as a bridge between your Servlet (Java code) and the MySQL database.

=> Instead of writing SQL directly inside your servlet, you put all database logic here → making code cleaner, reusable, and easier to maintain.

- in mavenproject -> Source Package -> new package create -> model ->Employee.java :-
  
[2] **Employee.java** :--
=> In Java, we need an object to store that row’s data.

=> That’s what Employee is → it’s a blueprint (class) to hold empno, ename, and salary.

! Servlet :----------

- in mavenproject -> Source Package -> new package create -> Servlet ->EmployeeServlet.java :-

[3] **EmployeeServlet.java** :--

=> The EmployeeServlet acts as the controller in the MVC architecture of this project.

- **Purpose**:

=> Handles HTTP requests (GET/POST) and interacts with the model classes (Employee, OptimizedLogic) to fetch employee data from the database.

- **Flow**:

=>  Browser sends a request to /EmployeeServlet

=>  Servlet calls OptimizedLogic to retrieve all employees

=>  Generates an HTML response containing:

=>  Employee List (Emp No, Name, Salary) in a table

=>  Gross Salary & Max Salary summary

=>  Sends the response back to the browser

# URL-Mapping :--

==>   http://localhost:8080/<YourProjectName>/EmployeeServlet
