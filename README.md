## Migros One Demo Project
This is a demo project for Migros One. The functionality provided by this project is to:
- Check whether the input courier has entered any of the Migros stores' radius of 100M
- Check the total distance covered by any courier

## Installation
### Prerequisites
- JDK17 for running the project on local machine
- Any API platform to send requests and receive answers from the provided API (like [Postman](https://www.postman.com/))

### How to run?
- Install the provided JAR file
- Open the terminal and navigate to the directory which the JAR file is located
```bash 
cd path/to/your/jar
```
- Run the JAR file with 
```bash 
java -jar courier-service-1.0.0.jar
```

## Endpoints
Detailed list of the available endpoints, including request methods, URLs, and descriptions.

#### Example:
- GET /getCourierTotalDistance?courier={input} - Retrieves the total distance traveled by the {input}
- POST /addCourierInfo - Logs the input courier and stores if courier enters radius of 100 meters from Migros
  stores. Reentries to the same store's circumference over 1 minute does not count
  as "entrance".  

## Tools Used

- IntelliJ IDEA 2024.1.2
- Apache Maven
- JDK17
- Git
- Postman
- Spring Framework

## Contact

- Email: tayl98@gmail.com
- GitHub: https://github.com/taylangurel


