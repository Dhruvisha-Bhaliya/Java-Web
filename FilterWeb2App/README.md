## \# FilterWeb2App Project :-



##### **=>  How to create Filter in java Apache netbeans 25 :**



* First create filter package -> new -> other -> Web -> Filter -> Filter name(MyFilter) -> (if Filter name and Applies to add) else -> Finish



##### => **What is a Filter in Servlets?**



* A Filter is a component in Java EE (Jakarta EE) that can intercept requests and responses before they reach a servlet or JSP.



* Filters are not servlets themselves, but they work in the middleware layer between the client (browser) and the servlet.



###### **==> They are mostly used for:**



* **Pre-processing (before request goes to servlet)**



* **Post-processing (after servlet generates response)**



###### 🔹 **Common Purposes of Filters :**





1. ***Logging \& Debugging :-***



Track requests and responses (headers, parameters, execution time).



**2.** ***Authentication \& Authorization :-***



Check if a user is logged in before allowing access to certain servlets/pages.



**3.** ***Input Validation \& Sanitization :-***



Prevent SQL Injection or XSS attacks by filtering inputs.



**4.<i> Compression :-</i>**



GZIP compress the response before sending to client.



**5.** ***Character Encoding :-***



Set UTF-8 encoding for requests/responses globally.



**6.** ***Centralized Code Execution :-***



Instead of repeating code in every servlet, keep it once in a filter.



###### 🔹 **How your AnotherFilter works :**



***-> You annotated it with:***



@WebFilter(filterName = "AnotherFilter", urlPatterns = {"/\*"})





This means the filter will run for all URLs (/\*).



Your filter methods:



**doBeforeProcessing()** → runs before servlet executes.



System.out.println("I am Another Filter as Request");





**doAfterProcessing()** → runs after servlet response is generated.



System.out.println("I am AnotherFilter as Response");





**chain.doFilter(request, response)** → hands over control to the next filter or servlet.

