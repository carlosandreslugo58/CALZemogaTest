* software prerequisites:
IntelliJ Community edition 2021.2.3
Java 11

* Steps to build the app:
1. Download (git remote add origin https://github.com/carlosandreslugo58/CALZemogaTest.git) and open the project in IntelliJ.
2. Execute class CalZemogaTestApplication.java
3. For open the page:  http://localhost:8091/gui/PortfolioPage
4. For call endpoints from postman:
4.1 GET http://localhost:8091/portfolios/115
4.2 PUT(body - JSON) http://localhost:8091/portfolios/115
{
    "idportfolio": 115,
    "description": "Updated Test for CAL",
    "experience_summary": "20 years plus",
    "id": 101,
    "image_url": "https://i2-prod.irishmirror.ie/incoming/article6306257.ece/ALTERNATES/s810/MAIN-Lewis-Hamilton-of-Great-Britain-and-Mercedes-GP-looks-on-during-the-drivers-paradse-before-the-Formula-One-Grand.jpg",
    "last_names": "Hamilton",
    "names": "Lewis",
    "tittle": "Sir",
    "twitter_user_id": "Pilot",
    "twitter_user_name": null,
    "user_id": "@LewisHamilton",
    "address": "BBB",
    "email": "lh@gmail.com",
    "experience": "10 years",
    "image_path": null,
    "name": "Lewis Hamilton",
    "phone": "123456789",
    "twitter_user": "@LewisHamilton",
    "zip_code": "12345",
    "title": "Mr."
}


Technologies used:
Spring boot
Lombok
JPA - Hibernate
Spring social web
Thymeleaf
MySQL
Mockito
JUnit 4.4

Total time it took to complete the test: 5 h.