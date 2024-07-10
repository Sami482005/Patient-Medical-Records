# Introduction
This repository includes all the codes needed to create a patient medical record in a hospital.
This repository was created for the purpose of collecting code from the four contributors to this project completed at Lebanese American University for Database Management Systems (BIF/CSC375).

# Dependencies
MySQl server installed from Wamp Server.
We are using Java through NetBeans Distribution.
JDK>8 (Using 22)
Add [JDBC](/home/sami/Patient_Medical_Records/mysql-connector-j-9.0.0.jar) to the Java Project

# Explaining the Repository
### Schema
Includes the [Entity-Relationship Diagram](/Schema/Picture1.png).
Includes the translated [Relational Model](/Schema/Relational%20Model.docx), although it is missing the Primary Keys. (Foreign keys represented by #)
Includes [The Queries Purposes](/Schema/Queries.docx): The queries expected to work in the project 
###### <span style="color:red">Note: Some of the queries are available but not in that file</span>


### View
Includes all the frames created in Java that will represent the interface that the User uses to interact with the database.

#### Plans for the View in Mind:
We create a main page that asks the User if he is a patient, or a Doctor.
This Program is created for only one Hospital so we can design the entire interface customized for only one hospital.
After the user chooses which one they are, the have the option to either sign up or login. (Default logging in behavior)
If they want to sign up they need to fill out the information needed to fill all the attributes needed in their database.

###### If they are a patient:
They can book an appointment or they can simply look at the prescription, lab radiology and surgery reports.

###### If they are a doctor:
They can see their schedule, they can adjust it (saying I am free for this hour or I am not free this hour)

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
