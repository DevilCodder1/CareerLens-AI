# CareerLens AI — Intelligent Career Recommendation System

CareerLens AI is a career guidance platform that helps students and job seekers discover suitable career paths based on their skills, interests, preferred roles, and career goals.

The backend uses a weighted scoring algorithm to recommend careers, identify skill gaps, and generate personalized learning roadmaps.

## Features

- **User Management:** Register users, retrieve profiles, and manage user records.
- **Authentication:** Password hashing with BCrypt and JWT token generation during login.
- **Career Profiles:** Store education, CGPA, skills, interests, preferred role, and career goals.
- **Career Details:** Explore seven career paths and their required skills.
- **Weighted Recommendations:** Rank careers using skill, interest, and preferred-role scores.
- **Skill Matching:** Match user skills against career requirements.
- **Skill Gap Analysis:** Identify skills a user needs to develop for a selected career.
- **Learning Roadmaps:** Generate prioritized learning steps with explanations for missing skills.

## Technology Stack

- **Language:** Java 21
- **Backend Framework:** Spring Boot
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **API Testing:** Postman
- **Authentication:** BCrypt and JWT
- **Version Control:** Git and GitHub

## Career Paths Supported

1. Java Backend Developer
2. Full Stack Developer
3. Data Analyst
4. Data Scientist
5. DevOps Engineer
6. Cloud Engineer
7. Cybersecurity Analyst

## How Career Recommendations Work

CareerLens AI calculates a match score using three factors:

| Factor | Weight |
|---|---:|
| Skill score | 60% |
| Interest score | 20% |
| Preferred-role score | 20% |

The final score is calculated as:

`Match Score = (Skill Score × 0.60) + (Interest Score × 0.20) + (Role Score × 0.20)`

Skill and interest scores use career-specific weights. The preferred-role score rewards a matching career name.

Recommendations are sorted from the highest match score to the lowest. The system also reports matched skills and missing skills for each career.

## API Endpoints

Base URL: `http://localhost:8080`

### Authentication

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/auth/login` | Log in and generate a JWT token |

### Users

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/users` | Register a user |
| GET | `/api/users` | Retrieve all users |
| GET | `/api/users/{id}` | Retrieve a user by ID |
| DELETE | `/api/users/{id}` | Delete a user |

### Career Profiles

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/career-profiles/{userId}` | Create a career profile |
| GET | `/api/career-profiles/{userId}` | Retrieve a career profile |

### Career Details

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/careers` | Retrieve all career options |
| GET | `/api/careers/{careerName}` | Retrieve details for a career |

### Recommendations and Learning

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/recommendations/{userId}` | Get ranked career recommendations |
| GET | `/api/recommendations/{userId}/skill-gap/{careerName}` | Identify missing skills |
| GET | `/api/recommendations/{userId}/roadmap/{careerName}` | Generate a learning roadmap |

Replace `{userId}` and `{careerName}` with actual values. URL-encode spaces in career names when necessary.

## Getting Started

### Prerequisites

Install the following:

- Java Development Kit (JDK) 21
- Apache Maven
- PostgreSQL
- IntelliJ IDEA or another Java IDE
- Postman (optional, for API testing)

### 1. Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd careerlens
```

Replace the placeholder with your actual GitHub repository URL.

### 2. Configure PostgreSQL

Create a PostgreSQL database for the application.

Update `src/main/resources/application.properties` with your local database settings. For example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/careerlens
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
```

Set `DB_USERNAME` and `DB_PASSWORD` in your environment before starting the application. Adjust the database name and other settings to match your local setup.

Never commit real database passwords, JWT signing secrets, or other credentials to GitHub.

### 3. Build the project

From the directory containing `pom.xml`, run:

```bash
mvn clean compile
```

### 4. Start the application

Run the Spring Boot main application class from your IDE, or use:

```bash
mvn spring-boot:run
```

The application should be available at `http://localhost:8080`, provided the database is configured correctly and port 8080 is available.

### 5. Test with Postman

Example request:

```http
GET http://localhost:8080/api/careers
```

To retrieve recommendations for user ID 4:

```http
GET http://localhost:8080/api/recommendations/4
```

A career recommendation response includes the career name, overall match score, individual factor scores, matched skills, and missing skills.

## Project Structure

```text
src/main/java/com/careerlens/
├── controller/
│   ├── AuthController.java
│   ├── CareerController.java
│   ├── CareerProfileController.java
│   └── CareerRecommendationController.java
├── dto/
├── entity/
├── model/
│   └── CareerOption.java
├── repository/
├── security/
│   └── JwtService.java
└── service/
    ├── CareerDataService.java
    ├── CareerProfileService.java
    ├── CareerRecommendationService.java
    ├── CareerService.java
    └── UserService.java
```

## Current Project Status

The backend includes user management, career profiles, career details, weighted career recommendations, skill-gap analysis, and learning-roadmap generation.

Recommendation scoring has been tested with multiple user profiles through Postman.

## Future Improvements

- Improve learning-roadmap explanations for every supported skill.
- Add stronger validation and consistent API error responses.
- Add automated unit and integration tests.
- Develop a React frontend for an interactive user experience.
- Explore machine-learning or language-model integration for more advanced career guidance.

## Author

**Shivam Kumar**

GitHub: [DevilCodder](https://github.com/DevilCodder)

## License

No license has been specified yet. Add a license if you intend to distribute or reuse this project publicly.
