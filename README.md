# 🌮 TacoVerse POS System

> *A fully object-oriented taco shop point-of-sale application built in Java.*

---

```text
========================================
             TACOVERSE POS
========================================

Order Type............. Custom / Combo
Taco Builder........... Available
Signature Tacos........ Included
Drinks................. Included
Chips & Salsa.......... Included
Receipt Saving......... Enabled
Architecture........... OOP / Layered
Language............... Java
========================================
```

---

# 📌 Overview

TacoVerse is a console-based taco shop ordering system designed for the **TACO-licious Capstone Project**.

Customers can:

* Build fully customized tacos and burritos
* Add drinks and chips & salsa
* Order signature tacos
* Purchase combo meals
* Review order details before checkout
* Generate timestamped receipt files automatically

The project was built using strong **Object-Oriented Programming principles** and a clean layered architecture.

---

# 🌮 Features

## 🧾 Ordering System

* Create new customer orders
* Add:

  * Custom tacos
  * Signature tacos
  * Combo meals
  * Drinks
  * Chips & Salsa
* Checkout and receipt generation
* Cancel orders anytime

---

## 🌯 Taco Customization

Supports fully custom user-entered toppings and sauces.

Customers can customize:

### Taco Sizes

* Single Taco
* 3-Taco Plate
* Burrito

### Shell Types

* Corn
* Flour
* Hard Shell
* Bowl

### Premium Toppings

* Carne Asada
* Al Pastor
* Carnitas
* Pollo
* Chorizo
* Pescado
* Queso Fresco
* Oaxaca
* Cotija
* Cheddar

### Regular Toppings

* Lettuce
* Cilantro
* Onions
* Tomatoes
* Jalapeños
* Radishes
* Pico de Gallo
* Guacamole
* Corn

### Sauces

* Salsa Verde
* Salsa Roja
* Chipotle
* Habanero
* Mild
* Extra Hot

### Extras

* Extra Meat
* Extra Cheese
* Covered in Salsa & Queso

---

# 🌟 Signature Items

## 🌮 Street Taco

Includes:

* 3-Taco Plate
* Corn Tortillas
* Carne Asada
* Onions
* Cilantro
* Salsa Verde

---

## 🌯 Super Burrito

Includes:

* Burrito
* Flour Tortilla
* Carnitas
* Cheddar
* Pico de Gallo
* Lettuce
* Tomatoes
* Covered in Salsa & Queso

---

# 🥤 Other Products

| Item          | Price |
| ------------- | ----- |
| Small Drink   | $2.00 |
| Medium Drink  | $2.50 |
| Large Drink   | $3.00 |
| Chips & Salsa | $1.50 |

---

# 🧠 OOP Concepts Demonstrated

```text
========================================
          OBJECT ORIENTED DESIGN
========================================

✅ Encapsulation
✅ Inheritance
✅ Polymorphism
✅ Interfaces
✅ Enums
✅ Composition
✅ Abstraction
✅ Service Layer Architecture
✅ Separation of Concerns
✅ Single Responsibility Principle
✅ Reusable Methods
✅ Layered Package Structure
✅ Extensible Design
========================================
```

---

# 🏗️ Architecture Highlights

## ✅ Clean Package Structure

```text
com.tacos
│
├── app
├── data
├── enums
├── interfaces
├── models
├── services
└── ui
```

---

## ✅ Service Layer Architecture

Business logic is separated into dedicated service classes:

| Service        | Responsibility    |
| -------------- | ----------------- |
| PricingService | Calculates totals |
| OrderService   | Displays orders   |
| ReceiptService | Saves receipts    |

---

## ✅ Interfaces

```java
Pricable
Receiptable
```

Used to enforce:

* pricing behavior
* receipt formatting

---

## ✅ Inheritance

Signature tacos inherit from the base `Taco` class:

```text
Taco
 ├── StreetTaco
 └── SuperBurrito
```

Combo meals inherit from:

```text
ComboOrder
 ├── StreetTacoCombo
 └── TacoSnackCombo
```

---

# 🧾 Receipt System

Every completed order generates a receipt file automatically.

Receipts are stored inside:

```text
/receipts
```

File naming format:

```text
yyyyMMdd-HHmmss.txt
```

Example:

```text
20260527-184523.txt
```

---

# 💻 Technologies Used

| Technology         | Purpose               |
| ------------------ | --------------------- |
| Java               | Core application      |
| OOP                | Architecture & design |
| File I/O           | Receipt saving        |
| Enums              | Menu options          |
| Interfaces         | Shared behavior       |
| Switch Expressions | Cleaner control flow  |
| ArrayLists         | Dynamic order storage |

---

# 🎨 Console UI

The application includes:

* colorized console output
* structured menus
* formatted receipts
* readable order summaries

---

# 📷 Sample Receipt

```text
================================
        TACOVERSE RECEIPT
================================

Taco:
Size: SINGLE
Shell: FLOUR
Meats: [Pollo]
Cheeses: [Queso]
Toppings: [Cilantro, Onion]
Sauces: [Lime Guac]
Extra Meat: No
Extra Cheese: No
Covered: No
Price: $5.25

Drink:
Size: Medium
Flavor: Horchata
Price: $2.50

================================
FINAL TOTAL: $7.75
================================
```

---

# 🚀 How To Run

## Clone Repository

```bash
git clone https://github.com/kyraprak/TacOS.git
```

---

## Open Project

Open in:

* IntelliJ IDEA
* VS Code
* Eclipse

---

## Run

Execute:

```text
Main.java
```

---

# 📚 Assignment Requirements Covered

```text
========================================
         CAPSTONE REQUIREMENTS
========================================

✅ Home Screen
✅ Order Screen
✅ Add Taco Screen
✅ Add Drink Screen
✅ Add Chips & Salsa Screen
✅ Checkout Screen
✅ Receipt File Generation
✅ Timestamped Receipts
✅ Taco Customization
✅ Dynamic Pricing
✅ OOP Design
✅ Signature Taco Bonus
✅ Combo Meal Bonus
========================================
```

---

# ⭐ Why This Project Stands Out

This project goes beyond the minimum requirements by implementing:

* layered architecture
* reusable services
* inheritance-based signature tacos
* combo meal system
* clean UI formatting
* extensible class design
* centralized pricing logic
* receipt persistence
* strong OOP principles throughout the entire application

---

# 👩🏽‍💻 Author

## TacoVerse POS System

Created as part of the **TACO-licious Capstone Project** using Java and Object-Oriented Programming principles.
