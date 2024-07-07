'''
This code creates a png file of the Entity-Relationship Diagram of the database schema.
However the schema is very rudimentary and does not clearly represent the diagram.
'''
import matplotlib.pyplot as plt
import networkx as nx

# Initialize the graph
G = nx.DiGraph()

# Add entities and their attributes
entities = {
    "Doctor": ["Doctor-ID", "first-name", "last-name", "email", "phone_nb", "title", "office_nb", "specialty", "starting_Year", "F_ID"],
    "MedicalFacility": ["F_ID", "Fname", "location", "contactInfo"],
    "Patients": ["P_SSN", "P_ID", "DOB", "first-name", "last-name", "address", "gender", "email", "phone_nb", "medical_history"],
    "InsurancePlan": ["IP_ID", "class", "company_provider", "issuing_date", "end_date", "P_ID"],
    "EmergencyContacts": ["phone_nb", "name", "relationship"],
    "Medical_File": ["MF_ID", "dateOfcreation", "P_SSN", "Doctor-ID", "prescription", "desc", "date"],
    "LabTest": ["LT_ID", "report", "type", "reason", "MF_ID"],
    "Radiology": ["R_ID", "type", "report", "reason", "imagesFiles", "MF_ID"],
    "Surgery": ["S_ID", "Surgery_name", "aim"],
    "Treatments": ["T_ID", "name", "reason", "startDate", "endDate", "MF_ID"],
    "Appointment": ["A_ID", "day", "to", "from", "reasonOfvisit", "statusOfappt", "P_SSN"]
}

# Add entities as nodes
for entity, attributes in entities.items():
    G.add_node(entity, shape='rectangle')
    for attr in attributes:
        G.add_node(f"{entity}.{attr}", shape='ellipse')
        G.add_edge(f"{entity}.{attr}", entity)

# Define relationships
relationships = [
    ("Doctor", "MedicalFacility"),
    ("Medical_File", "Doctor"),
    ("Medical_File", "Patients"),
    ("LabTest", "Medical_File"),
    ("Radiology", "Medical_File"),
    ("Treatments", "Medical_File"),
    ("Appointment", "Patients"),
    ("InsurancePlan", "Patients"),
    ("InsurancePlan", "Surgery"),
    ("InsurancePlan", "Treatments"),
    ("InsurancePlan", "Radiology"),
    ("InsurancePlan", "LabTest"),
    ("Patients", "EmergencyContacts"),
    ("Patients", "Medical_File"),
    ("Perform_Surgery", "Doctor"),
    ("Perform_Surgery", "MedicalFacility"),
    ("Perform_Surgery", "Patients"),
    ("Perform_Surgery", "Surgery"),
    ("hasAvailability", "Doctor"),
    ("CoversSurgery", "InsurancePlan"),
    ("CoversSurgery", "Surgery"),
    ("CoversTreatment", "InsurancePlan"),
    ("CoversTreatment", "Treatments"),
    ("CoversRadio", "InsurancePlan"),
    ("CoversRadio", "Radiology"),
    ("CoversTest", "InsurancePlan"),
    ("CoversTest", "LabTest"),
    ("Has_Emergency_Contacts", "Patients"),
    ("Has_Emergency_Contacts", "EmergencyContacts"),
    ("Admits", "Patients"),
    ("Admits", "MedicalFacility")
]

# Add relationships as edges
for rel in relationships:
    G.add_edge(rel[0], rel[1])

# Draw the graph
plt.figure(figsize=(20, 20))
pos = nx.spring_layout(G, k=0.5, iterations=50)
nx.draw(G, pos, with_labels=True, node_size=3000, node_color="skyblue", font_size=10, font_color="black", font_weight="bold", edge_color="gray")
plt.title("Entity-Relationship Diagram")
