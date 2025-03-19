
Propósito:

La aplicación es una demostracion de como manejar la libreria Spring Security con JWT.
Como es una demo no se usa base de datos, el usuario, pass y su rol se configura en el applicarion.properties



Tecnologias principales:

- Proyecto Spring Boot 2.7.18
- Java 8

Librerias principales:

- spring-boot-starter-web
- spring-boot-starter-security
- jjwt

Librerias adicionales:

- lombok
- springfox (Swagger)
- spring-boot-starter-validation

Instalacion local:

mvn clean install -DskipTests

Probar con Swagger:

http://localhost:8080/swagger-ui/index.html
