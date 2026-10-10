# Changelog

All notable changes to the Equipment Rental Marketplace project are documented here.

## [1.0.0] - 2026-09-20

### Added
- Owner and Renter registration and login
- Role-based dashboards
- Equipment category management
- Add, view, edit and delete equipment
- Equipment availability tracking
- Equipment rental with rental days
- Automatic rental amount calculation
- Renter rental history
- Owner rental history
- Equipment return functionality
- Payment recording with UPI, Cash and Card options
- Payment status tracking
- MySQL database integration using JDBC
- ER diagram
- System architecture diagram
- Class diagram
- Project README documentation
- Git ignore configuration

### Security
- Database password is read through the `DB_PASSWORD` environment variable.
- Local database credentials are not stored as a hard-coded password.

### Testing
- Renter registration and login tested
- Owner registration and login tested
- Equipment CRUD operations tested
- Rental and return flow tested
- Payment flow tested
- Rental history tested
- Database relationships verified