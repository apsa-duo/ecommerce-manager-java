<h1 align="center">ðŸ›’ ECommerceManager</h1>

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

## ðŸ“– About

**ECommerceManager** is a fully functional desktop e-commerce application demonstrating object-oriented programming principles (SOLID, DRY, KISS) in a real-world context. It features a dual-interface system â€” one for **administrators** and one for **customers** â€” with complete product lifecycle management, user authentication, shopping cart functionality, and automated invoice generation.

This project was developed as an academic exercise at university and later refactored into a professional-grade codebase suitable for a software engineering portfolio.

---

## âœ¨ Key Features

| Feature | Description |
|---------|-------------|
| ðŸ” **Dual Authentication** | Separate login flows for administrators and customers |
| ðŸ“¦ **Product Catalog (CRUD)** | Add, edit, delete, search, and sort products by category/price/rating |
| ðŸ›’ **Shopping Cart** | Add/remove items, quantity validation, real-time total calculation |
| ðŸ’³ **Credit Card Validation** | 16-digit check and expiration date verification |
| ðŸ§¾ **Invoice Generation** | Automatic `.txt` invoice files created in `Facturas/` on purchase |
| â­ **Product Reviews** | Customers can rate (0â€“10) and comment on any product |
| ðŸ‘¥ **Customer Types** | Individual (DNI) and Business (CIF + Website) customer profiles |
| ðŸ” **Search & Sort** | Filter by category; sort by price (asc/desc) or average rating |
| ðŸ’¾ **Data Persistence** | Java serialization to `.dat` files for products, customers, and sales |

---

## ðŸ—ï¸ Project Structure

```
ECommerceManager2023/
â”œâ”€â”€ pom.xml                              # Maven build configuration
â”œâ”€â”€ .gitignore                           # Git exclusion rules
â”œâ”€â”€ README.md                            # This file
â”œâ”€â”€ imagenes/                            # Product images & app logo
â”‚   â””â”€â”€ logo.jpg
â”œâ”€â”€ Facturas/                            # Auto-generated invoice files (gitignored)
â””â”€â”€ src/main/java/com/ECommerceManager/
    â”œâ”€â”€ model/                           # Domain entities & data layer
    â”‚   â”œâ”€â”€ User.java                    # Base user (email + password)
    â”‚   â”œâ”€â”€ Customer.java                # Customer with profile details
    â”‚   â”œâ”€â”€ IndividualCustomer.java      # Personal customer (DNI)
    â”‚   â”œâ”€â”€ BusinessCustomer.java        # Business customer (CIF + website)
    â”‚   â”œâ”€â”€ Product.java                 # Product with reviews & ratings
    â”‚   â”œâ”€â”€ Review.java                  # Product review (rating + comment)
    â”‚   â”œâ”€â”€ Purchase.java                # Purchase order
    â”‚   â”œâ”€â”€ PurchaseItem.java            # Line item (product + quantity)
    â”‚   â”œâ”€â”€ Address.java                 # Mailing address
    â”‚   â”œâ”€â”€ CreditCard.java             # Payment card with validation
    â”‚   â””â”€â”€ StoreManager.java           # Data persistence manager
    â”œâ”€â”€ exception/                       # Custom exception hierarchy
    â”‚   â”œâ”€â”€ PurchaseException.java       # Cart/purchase validation errors
    â”‚   â”œâ”€â”€ StockException.java          # Stock availability errors
    â”‚   â””â”€â”€ CreditCardException.java     # Payment validation errors
    â”œâ”€â”€ util/                            # Shared utilities
    â”‚   â”œâ”€â”€ Constants.java               # Centralized configuration
    â”‚   â””â”€â”€ UIHelper.java                # UI utility methods
    â””â”€â”€ ui/                              # Swing GUI frames
        â”œâ”€â”€ MainMenuFrame.java           # App entry point
        â”œâ”€â”€ AdminLoginFrame.java         # Admin authentication
        â”œâ”€â”€ AdminMenuFrame.java          # Admin dashboard
        â”œâ”€â”€ ProductManagementFrame.java  # Product CRUD operations
        â”œâ”€â”€ UserManagementFrame.java     # View registered users
        â”œâ”€â”€ SalesQueryFrame.java         # Query sales by date
        â”œâ”€â”€ CustomerLandingFrame.java    # Customer portal
        â”œâ”€â”€ CustomerLoginFrame.java      # Customer authentication
        â”œâ”€â”€ CustomerRegistrationFrame.java # Registration type selection
        â”œâ”€â”€ IndividualRegistrationFrame.java # Individual signup
        â”œâ”€â”€ BusinessRegistrationFrame.java  # Business signup
        â”œâ”€â”€ CustomerMenuFrame.java       # Customer dashboard
        â”œâ”€â”€ PurchaseFrame.java           # Shopping & checkout
        â”œâ”€â”€ EditIndividualFrame.java     # Edit individual profile
        â”œâ”€â”€ EditBusinessFrame.java       # Edit business profile
        â””â”€â”€ SubmitReviewFrame.java       # Submit product review
```

---

## ðŸš€ Getting Started

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

## ðŸ› ï¸ Tech Stack

- **Language:** Java 17
- **Build Tool:** Apache Maven
- **GUI Framework:** Java Swing (Nimbus Look & Feel)
- **Data Persistence:** Java Serialization (`.dat` files)
- **Design Patterns:** MVC-inspired, Utility classes, Custom Exception hierarchy

---

## ðŸ§¹ Code Quality Highlights

- âœ… **English naming** â€” All classes, methods, and variables use descriptive English names
- âœ… **Comprehensive Javadoc** â€” Every public class and method is documented
- âœ… **DRY** â€” Shared code extracted into `UIHelper` and `Constants` utility classes
- âœ… **SOLID** â€” Clean class hierarchy (`User` â†’ `Customer` â†’ `Individual`/`Business`)
- âœ… **KISS** â€” `Collections.sort()` + `Comparator` replaces hand-written bubble sort
- âœ… **Proper error handling** â€” Custom exception hierarchy with descriptive messages
- âœ… **No magic strings** â€” All constants centralized in `Constants.java`

---

## ðŸ—ºï¸ Future Roadmap

- [ ] ðŸ—„ï¸ Migrate from Java Serialization to an embedded database (H2/SQLite)
- [ ] ðŸŒ Add a REST API layer (Spring Boot)
- [ ] ðŸŽ¨ Migrate UI to JavaFX for a modern look
- [ ] ðŸ”’ Implement password hashing (bcrypt)
- [ ] ðŸ§ª Add unit tests (JUnit 5)
- [ ] ðŸ“Š Add sales analytics dashboard

---

## ðŸ‘¥ Contributors

| Name | Role |
|------|------|
| **Andrea Pascual Aguilera** | Developer |
| **Sergio Alonso Zarcero** | Developer |

---

## ðŸ“„ License

This project is open source and available under the [MIT License](LICENSE).

---

<p align="center">
  <sub>Built with â˜• Java and a passion for clean code</sub>
</p>
