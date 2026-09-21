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

📝 Troubleshooting & Common Gotchas
Expression Language (EL) Issues: Ensure isELIgnored="false" is declared at the top of JSP files when using Jakarta EE 10, or ensure web.xml declares Servlet version 6.0.

Missing JSTL Dependencies: Tomcat 10+ requires both jakarta.servlet.jsp.jstl-api (v3.0.0) and org.glassfish.web:jakarta.servlet.jsp.jstl (v3.0.1) in the runtime classpath (WEB-INF/lib).
