# Interface Filter Strategy: Applying the Strategy Pattern

## 💡 Overview
This project serves as a hands-on demonstration of Object-Oriented Programming (OOP) principles in Java, specifically utilizing **interfaces** to implement various filtering strategies. The core objective is to create distinct, reusable filtering logic that can be applied to different data types (Strings and Rectangles) via a common `Filter` interface.

## 🎯 Learning Outcomes
This lab fulfills the following learning objectives:
1.  Demonstrate the creation and implementation of interfaces in Java.
2.  Apply the **Strategy Pattern** by allowing the main program to switch between filtering behaviors at runtime. 
3.  Design and implement specific filtering logic for different data types.
4.  Understand the benefits of loose coupling and flexible code architecture.

## 🛠️ Implementation Details

### Interfaces Created
| Interface Name | Description |
| :--- | :--- |
| `ShortWordFilter` | Implements the provided `Filter` interface to identify and filter out `String` objects that are below a defined minimum length. |
| `BigRectangleFilter` | Implements the provided `Filter` interface to identify and filter out `Rectangle` objects that exceed a defined size or area threshold. |

### Core Components
| Component | Responsibility |
| :--- | :--- |
| **`Driver` Program** | The main execution class. Responsible for instantiating the data sets (e.g., list of words, list of rectangles) and demonstrating the use of both the `ShortWordFilter` and `BigRectangleFilter`. |
| **`Filter` Interface** | (Provided) The base interface that defines the required method signature for all filtering strategies. |

### Execution
The `Driver` program applies the custom filters sequentially:
1.  Creates a list of sample `String` objects.
2.  Applies the `ShortWordFilter`.
3.  Prints the filtered list (only long words remain).
4.  Creates a list of sample `Rectangle` objects.
5.  Applies the `BigRectangleFilter`.
6.  Prints the filtered list (only small/medium rectangles remain).

## 📊 UML Diagrams
UML diagrams for all created interfaces and classes (`ShortWordFilter`, `BigRectangleFilter`, `Driver` class).
<img width="622" height="505" alt="Lab 3 UML" src="https://github.com/user-attachments/assets/8be3fd1e-dbd6-413c-9413-aa15dbacacba" />
