HB Watch demo

* Docker postgresql database
Set up a docker database by writing these commands in the command line (you need to have docker installed to make this work).

docker pull postgres

docker run --name watch-db -e POSTGRES_USER=root -e POSTGRES_PASSWORD=catalog-db -e POSTGRES_DB=catalog-db -p 5432:5432 -d postgres

* Add application properties
Add the following into the application.properties file that can be found here catalog-service/src/main/resources/application.properties:


spring.application.name=catalog-service

spring.datasource.url=jdbc:postgresql://localhost:5432/catalog-db
spring.datasource.username=root
spring.datasource.password=catalog-db
spring.jpa.hibernate.ddl-auto=create-drop
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
