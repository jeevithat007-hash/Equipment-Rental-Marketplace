# Equipment Rental Marketplace

## Project Overview

The Equipment Rental Marketplace is a Java-based desktop application developed to simplify the process of renting equipment. It provides a platform where equipment owners can list their equipment for rent and renters can search, rent, and return equipment easily.

This system reduces the need to purchase expensive equipment for short-term use and helps owners generate income from idle equipment. The application includes user authentication, equipment management, rental management, and database integration.

---

## Problem Statement

Many construction companies, farmers, event organizers, and individuals require expensive equipment such as excavators, generators, tractors, and concrete mixers only for a limited period. Purchasing such equipment is costly, while many owners have equipment that remains unused. Existing rental methods are mostly manual, making it difficult to manage equipment availability and rental records.

The Equipment Rental Marketplace solves this problem by providing an easy-to-use digital platform where owners can list equipment and renters can rent it online.

---

## Objectives

- Develop an online equipment rental platform.
- Provide secure user registration and login.
- Allow owners to add and manage equipment.
- Allow renters to search and rent equipment.
- Maintain rental history.
- Store all data in a MySQL database.

---

# User Roles

## Admin
- Manage users
- Monitor equipment listings
- View rental transactions
- Manage the system

## Equipment Owner
- Register and Login
- Add Equipment
- Update Equipment
- Delete Equipment
- View Rental Requests

## Renter
- Register and Login
- Search Equipment
- Rent Equipment
- Return Equipment
- View Rental History

---

# Features

## User Module
- User Registration
- User Login
- Role-Based Access

## Equipment Module
- Add Equipment
- View Equipment
- Update Equipment
- Delete Equipment
- Equipment Availability Status

## Rental Module
- Rent Equipment
- Return Equipment
- Rental History
- Rental Status

---

# Technology Stack

## Frontend
- Java Swing

## Backend
- Java
- Spring Boot

## Database
- MySQL
- JDBC

## Development Tools
- VS Code
- Git
- GitHub
- XAMPP

---

# Project Structure

```
EquipmentRentalMarketplace
│
├── src
│   ├── Main.java
│   ├── RentalSystem.java
│   ├── User.java
│   ├── Equipment.java
│   ├── Rental.java
│   ├── LoginFrame.java
│   ├── RegisterFrame.java
│   ├── OwnerDashboard.java
│   ├── RenterDashboard.java
│   ├── AddEquipmentFrame.java
│   ├── ViewEquipmentFrame.java
│   ├── RentEquipmentFrame.java
│   ├── ReturnEquipmentFrame.java
│   └── DatabaseConnection.java
│
├── docs
│   ├── Problem_Statement.md
│   └── diagrams
│       ├── ER_Diagram.png
│       ├── System_Architecture.png
│       └── Class_Diagram.png
│
├── database
│   └── equipment_rental.sql
│
└── README.md
```

---

# Database Tables

## Users
- user_id
- name
- email
- password
- role

## Equipment
- equipment_id
- owner_id
- equipment_name
- category
- description
- rent_per_day
- image_path
- status

## Rentals
- rental_id
- renter_id
- equipment_id
- rental_date
- return_date
- total_amount
- rental_status

## Categories
- category_id
- category_name

## Payments
- payment_id
- rental_id
- payment_method
- payment_status

---

# System Modules

## Module 1
### User Authentication
- Registration
- Login
- Logout

---

## Module 2
### Equipment Management
- Add Equipment
- View Equipment
- Update Equipment
- Delete Equipment

---

## Module 3
### Rental Management
- Rent Equipment
- Return Equipment
- Rental History

---

# Software Requirements

- Windows 10/11
- Java JDK 17+
- VS Code
- MySQL
- XAMPP
- Git

---

# Hardware Requirements

- Intel i3 Processor or above
- 4 GB RAM (Minimum)
- 10 GB Free Storage

---

# Installation Steps

### Step 1

Clone the repository

```bash
git clone https://github.com/yourusername/EquipmentRentalMarketplace.git
```

---

### Step 2

Open the project in VS Code.

---

### Step 3

Install Java JDK.

---

### Step 4

Install XAMPP and start MySQL.

---

### Step 5

Create the database.

```sql
CREATE DATABASE equipment_rental;
```

---

### Step 6

Import the SQL tables.

---

### Step 7

Add the MySQL JDBC Driver.

---

### Step 8

Run the project.

```
Main.java
```

or

```
LoginFrame.java
```

---

# Future Enhancements

- Online Payment Gateway
- Equipment Image Upload
- GPS Tracking
- Email Notifications
- Mobile Application
- Customer Reviews
- Ratings
- AI-Based Equipment Recommendation
- Equipment Availability Notifications

---

# Expected Outcome

- Easy equipment rental process
- Reduced equipment purchase cost
- Better equipment utilization
- Secure user authentication
- Efficient rental management
- Centralized equipment database

---

# Documentation

- Problem Statement
- System Architecture Diagram
- ER Diagram
- Class Diagram
- README

---

# Author

**Jeevitha T**

Bachelor of Technology

Department of Artificial Intelligence and Data Science

Capstone Project – Equipment Rental Marketplace

---

# License

This project is developed for academic and educational purposes.
