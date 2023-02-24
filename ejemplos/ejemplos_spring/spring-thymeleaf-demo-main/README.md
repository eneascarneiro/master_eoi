# Requirements

* Java >= 11
* Maven >= 3.8

# Start it up

Just execute
`mvn spring-boot:run`

Then launch your favourite browser and go to `http://localhost:8080`. Enjoy!

## How to access to the database
Open http://localhost:8080/h2-console

* drive: org.h2.Driver
* JDBC URL: jdbc:h2:file:./target/h2db/db/demo;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1
* username: demo
* password: (empty)

## Users

* admin:123
* emingora:123
* nonactiveuser:123 (this user will not work just because active field is disabled)

## Roles

* `ROLE_ADMIN` (for admin user)
* `ROLE_USER` (for emingora user)

# TODO

* Unitary testing
* Integration testing
* Edit Profile section
* Change password screen
* Recover password screen
* Infinite scroll example

