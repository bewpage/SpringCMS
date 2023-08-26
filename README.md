# springCMS

## Description

`springCMS` is a web application built on the Spring framework that allows for managing articles, authors, and
categories. Users can add, edit, and delete articles, as well as assign them to specific authors and categories.

## Features

1. **Article Management:** Users can create, edit, and delete articles.
2. **Author Management:** Capability to add, edit, and delete authors.
3. **Category Management:** Users can add, edit, and delete categories and assign articles to chosen categories.
4. **Article Display:** Articles can be displayed based on their publication date, author, or category.

## Technologies

- **Spring Framework:** Used for managing application components and ensuring database integration.
- **Hibernate:** Responsible for object-relational mapping and database communication.
- **JSP:** For creating dynamic views.
- **Docker:** For containerizing the database environment.

## Docker Installation

The project includes a `docker-compose.yml` file that automates the configuration and deployment of the database
environment. To spin up the database:

1. Install [Docker](https://www.docker.com/products/docker-desktop) on your machine.
2. Open the terminal and navigate to the directory where the `docker-compose.yml` file is located.
3. Run the command: `docker-compose -p <here-your-project-name> -f ./docker/docker-compose.yml up -d`.

## How to Run

Assuming you already have the environment set up with the appropriate Java and Maven versions:

1. Clone the repository: `git clone git@github.com:bewpage/SpringCMS.git`.
2. Navigate to the project directory: `cd springCMS`.
3. Run the application using Maven: `mvn spring-boot:run`.
4. Open your browser and go to `http://localhost:8080`.

## Challenges Faced

1. Issues with lazy loading in Hibernate leading to `LazyInitializationException`.
2. Complications during article deletion related to foreign key constraints in the database.
3. Use of DAO classes for CRUD operations instead of traditional services.

## Acknowledgments

- [Spring Framework Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
