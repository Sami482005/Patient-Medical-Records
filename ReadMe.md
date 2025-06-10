# Introduction
This repository includes all the codes needed to create a patient medical record in a hospital.
This repository was created for the purpose of collecting code from the four contributors to this project completed at Lebanese American University for Database Management Systems (BIF375/CSC375).

# Dependencies
MySQl server installed from Wamp Server.
We are using Java through NetBeans Distribution.
JDK>8 (Using 22)
Add [JDBC](/home/sami/Patient_Medical_Records/mysql-connector-j-9.0.0.jar) to the Java Project

# Explaining the Repository
### Schema
Includes the [Entity-Relationship Diagram](/Schema/Picture1.png).
Includes the translated [Relational Model](/Schema/RelationalModel.docx)
Includes [The Queries Purposes](/Schema/Queries.docx): The queries expected to work in the project 
###### <span style="color:red">Note: Some of the queries are available but not in that file</span>


### View
Includes all the frames created in Java that will represent the interface that the User uses to interact with the database.
###### If they are a patient:
They can book an appointment or they can simply look at the prescription, lab radiology and surgery reports.
###### If they are a doctor:
They can see their schedule, they can adjust it (saying I am free for this hour or I am not free this hour) and they can add surgeries, lab tests, radiologies... 


### Control
Includes all the control and coordination between the model and view.



### Model
Includes all the internal information representation.



## Some things to know
**Statement** class is used to write different queries
**ResultSet** class is used when selecting information to be stored.

###### Methods  
***ExecuteQuery()***: for SELECT query
***ExecuteUpdate()***: for MODIFICATION queries (Delete, Update, Insert)
get*Type*(): to extract the info into the correct type from a **ResultSet**

**this.dispose()** #makes a tab close without killing the program
