# Problem Statement

## 1. Title
Equipment Rental Marketplace

## 2. Domain
E-Commerce / Equipment Rental Management System

## 3. Who is the user? (2-3 user types, with roles)

### Admin
- Manage users
- Monitor equipment listings
- View rental transactions
- Remove inappropriate listings

### Equipment Owner
- Register and log in
- Add equipment for rent
- Update or remove equipment
- View rental requests
- Track rented equipment

### Renter
- Register and log in
- Search available equipment
- Rent equipment
- Return rented equipment
- View rental history

## 4. What problem are we solving? (3-5 sentences, real-life example)

Construction companies, farmers, event organizers, and individuals often require expensive equipment only for a short duration. Purchasing such equipment is costly, while many equipment owners have machines that remain unused for long periods. Existing rental methods are mostly manual, making it difficult to find suitable equipment, compare prices, and manage rental records. The Equipment Rental Marketplace solves this problem by providing an online platform where owners can list their equipment and renters can easily search, rent, and return equipment efficiently.

## 5. Proposed Solution (what the application will do, feature-wise)

The Equipment Rental Marketplace provides an easy-to-use platform for renting equipment.

Features:
- User Registration
- User Login
- Owner Dashboard
- Renter Dashboard
- Add Equipment
- Update Equipment
- Delete Equipment
- View Equipment
- Search Equipment
- Rent Equipment
- Return Equipment
- Rental History
- User Profile Management
- Database Storage using MySQL

## 6. Core Entities / Database Tables (list all, minimum 5)

1. Users
2. Equipment
3. Rentals
4. Categories
5. Payments

## 7. User Roles & Permissions (minimum 2 distinct roles)

### Admin
- Manage users
- Manage equipment
- View all rental transactions
- Monitor system activities

### Equipment Owner
- Add equipment
- Edit equipment details
- Delete equipment
- View rental requests

### Renter
- Search equipment
- Rent equipment
- Return equipment
- View rental history

## 8. Success Criteria

- Users can register and log in successfully.
- Equipment owners can add equipment to the marketplace.
- Renters can search and rent available equipment.
- Rental information is stored in the MySQL database.
- Equipment availability is updated after each rental and return.
- Rental history is displayed correctly to the user.

## 9. Out of Scope (clearly list what you will NOT build)

- Online payment gateway
- GPS tracking
- Live chat between users
- Equipment insurance
- Mobile application
- AI-based equipment recommendation
- Email and SMS notifications

## 10. Chosen Track

Java (Spring Boot) + MySQL
