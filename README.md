<h1 align="center">ECommerceManager</h1>

<p align="center">
  <strong>A desktop e-commerce management system built with Java Swing</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/Swing-GUI-007396?style=for-the-badge&logo=java&logoColor=white" alt="Swing GUI">
  <img src="https://img.shields.io/badge/Status-Maintained-brightgreen?style=for-the-badge" alt="Maintained">
</p>

---

## About

**ECommerceManager** is a fully functional desktop e-commerce application demonstrating object-oriented programming principles (SOLID, DRY, KISS) in a real-world context. It features a dual-interface system — one for **administrators** and one for **customers** — with complete product lifecycle management, user authentication, shopping cart functionality, and automated invoice generation.

This project was developed as an academic exercise at university and later refactored into a professional-grade codebase suitable for a software engineering portfolio.

---

## Key Features

| Feature | Description |
|---------|-------------|
| **Dual Authentication** | Separate login flows for administrators and customers |
| **Product Catalog (CRUD)** | Add, edit, delete, search, and sort products by category/price/rating |
| **Shopping Cart** | Add/remove items, quantity validation, real-time total calculation |
| **Credit Card Validation** | 16-digit check and expiration date verification |
| **Invoice Generation** | Automatic `.txt` invoice files created in `Facturas/` on purchase |
| **Product Reviews** | Customers can rate (0–10) and comment on any product |
| **Customer Types** | Individual (DNI) and Business (CIF + Website) customer profiles |
| **Search & Sort** | Filter by category; sort by price (asc/desc) or average rating |
| **Data Persistence** | Java serialization to `.dat` files for products, customers, and sales |

---

## Project Structure

```
ECommerceManager2023/
├── pom.xml                              # Maven build configuration
├── .gitignore                           # Git exclusion rules
├── README.md                            # This file
├── imagenes/                            # Product images & app logo
│   └── logo.jpg
├── Facturas/                            # Auto-generated invoice files (gitignored)
└── src/main/java/com/ECommerceManager/
    ├── model/                           # Domain entities & data layer
    │   ├── User.java                    # Base user (email + password)
    │   ├── Customer.java                # Customer with profile details
    │   ├── IndividualCustomer.java      # Personal customer (DNI)
    │   ├── BusinessCustomer.java        # Business customer (CIF + website)
    │   ├── Product.java                 # Product with reviews & ratings
    │   ├── Review.java                  # Product review (rating + comment)
    │   ├── Purchase.java                # Purchase order
    │   ├── PurchaseItem.java            # Line item (product + quantity)
    │   ├── Address.java                 # Mailing address
    │   ├── CreditCard.java             # Payment card with validation
    │   └── StoreManager.java           # Data persistence manager
    ├── exception/                       # Custom exception hierarchy
    │   ├── PurchaseException.java       # Cart/purchase validation errors
    │   ├── StockException.java          # Stock availability errors
    │   └── CreditCardException.java     # Payment validation errors
    ├── util/                            # Shared utilities
    │   ├── Constants.java               # Centralized configuration
    │   └── UIHelper.java                # UI utility methods
    └── ui/                              # Swing GUI frames
        ├── MainMenuFrame.java           # App entry point
        ├── AdminLoginFrame.java         # Admin authentication
        ├── AdminMenuFrame.java          # Admin dashboard
        ├── ProductManagementFrame.java  # Product CRUD operations
        ├── UserManagementFrame.java     # View registered users
        ├── SalesQueryFrame.java         # Query sales by date
        ├── CustomerLandingFrame.java    # Customer portal
        ├── CustomerLoginFrame.java      # Customer authentication
        ├── CustomerRegistrationFrame.java # Registration type selection
        ├── IndividualRegistrationFrame.java # Individual signup
        ├── BusinessRegistrationFrame.java  # Business signup
        ├── CustomerMenuFrame.java       # Customer dashboard
        ├── PurchaseFrame.java           # Shopping & checkout
        ├── EditIndividualFrame.java     # Edit individual profile
        ├── EditBusinessFrame.java       # Edit business profile
        └── SubmitReviewFrame.java       # Submit product review
```

---

## Getting Started

### Prerequisites

- **Java 17** or higher ([Download](https://adoptium.net/))
- **Maven 3.x** ([Download](https://maven.apache.org/download.cgi))

### Build & Run

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/ECommerceManager2023.git
cd ECommerceManager2023

# Compile the project
mvn clean compile

# Run the application
mvn exec:java -Dexec.mainClass="com.ECommerceManager.ui.MainMenuFrame"
```

### Default Admin Credentials

| Field    | Value                |
|----------|----------------------|
| Email    | `admin@ECommerceManager.com` |
| Password | `admin`              |

---

## Tech Stack

- **Language:** Java 17
- **Build Tool:** Apache Maven
- **GUI Framework:** Java Swing (Nimbus Look & Feel)
- **Data Persistence:** Java Serialization (`.dat` files)
- **Design Patterns:** MVC-inspired, Utility classes, Custom Exception hierarchy

---

## Code Quality Highlights

- **English naming** — All classes, methods, and variables use descriptive English names
- **Comprehensive Javadoc** — Every public class and method is documented
- **DRY** — Shared code extracted into `UIHelper` and `Constants` utility classes
- **SOLID** — Clean class hierarchy (`User` → `Customer` → `Individual`/`Business`)
- **KISS** — `Collections.sort()` + `Comparator` replaces hand-written bubble sort
- **Proper error handling** — Custom exception hierarchy with descriptive messages
- **No magic strings** — All constants centralized in `Constants.java`

---

## Future Roadmap

- [ ] Migrate from Java Serialization to an embedded database (H2/SQLite)
- [ ] Add a REST API layer (Spring Boot)
- [ ] Migrate UI to JavaFX for a modern look
- [ ] Implement password hashing (bcrypt)
- [ ] Add unit tests (JUnit 5)
- [ ] Add sales analytics dashboard

---

## Contributors

| Name | Role |
|------|------|
| **Andrea Pascual Aguilera** | Developer |
| **Sergio Alonso Zarcero** | Developer |

---

## License

This project is open source and available under the [MIT License](LICENSE).

---

<p align="center">
  <sub>Built with Java and a passion for clean code</sub>
</p>
