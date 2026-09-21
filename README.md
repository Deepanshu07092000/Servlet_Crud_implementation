# Java EE / Jakarta EE CRUD Web Application

A lightweight, robust, multi-tier Java EE web application built using **Servlets**, **JPA (Hibernate)**, **JSTL**, and **Bootstrap 5**, deployed on **Apache Tomcat 10+**. 

This application demonstrates a standard **Model-View-Controller (MVC)** design pattern, implementing complete Create, Read, Update, and Delete (CRUD) operations for user account management with MySQL persistence.

---

## 🛠️ Tech Stack & Dependencies

* **Language:** Java 17 / 21
* **Web Specifications:** Jakarta EE 10 (Servlet API 6.0, JSP 3.1, JSTL 3.0)
* **ORM Framework:** Hibernate ORM Core 6.4.4.Final
* **Database:** MySQL 8.3.0
* **Frontend:** Bootstrap 5.3.2 & Bootstrap Icons
* **Build Tool:** Apache Maven
* **Server:** Apache Tomcat 10.1+ (via IntelliJ SmartTomcat)

---

## 🚀 Application Architecture & Workflow

The application adheres strictly to the **MVC (Model-View-Controller)** architectural pattern:

```text
               +----------------------------------+
               |           Browser (UI)           |
               +----------------------------------+
                             │      ▲
              HTTP Request   │      │  HTML / JSTL View
          (GET/POST/Redirect)|      │
                             ▼      │
               +----------------------------------+
               |     UserServlet (Controller)     |
               +----------------------------------+
                             │      ▲
            DAO Invocations  │      │  Domain Objects / Lists
                             ▼      │
               +----------------------------------+
               |        UserDAO (Data Access)     |
               +----------------------------------+
                             │      ▲
            JPA Transactions │      │  Entities / Result Sets
                             ▼      │
               +----------------------------------+
               |      MySQL Database (Storage)    |
               +----------------------------------+
