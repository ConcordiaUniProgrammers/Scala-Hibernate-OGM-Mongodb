# Scala-Hibernate-OGM-Mongodb
Scala sample with Hibernate OGM and Mongodb.

This is a maven application that can demonstrate how we can use Hibernate OGM to store data into Mongodb as a document based nosql.

As a sample, we implement the many to many and one to many relationship in the domain model.

Domain model consist of Person, Home, Car.
Each person has a list of Homes, and each home belongs to a person. Each person also has list of car that can have many owners.
