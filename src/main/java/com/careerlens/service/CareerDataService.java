
package com.careerlens.service;

import com.careerlens.model.CareerOption;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CareerDataService {

    public List<CareerOption> getCareerOptions() {
        return Arrays.asList(

                new CareerOption(
                        "Java Backend Developer",
                        "Develops server-side applications, APIs and backend systems using Java and related technologies.",
                        Arrays.asList("java", "sql", "spring boot", "rest api", "spring security", "docker"),
                        Arrays.asList("backend development", "software engineering", "web development"),
                        Map.of("java", 25, "spring boot", 20, "sql", 15, "rest api", 15, "spring security", 10, "docker", 15),
                        Map.of("backend development", 50, "software engineering", 30, "web development", 20)
                ),

                new CareerOption(
                        "Full Stack Developer",
                        "Develops both frontend and backend components of web applications.",
                        Arrays.asList("java", "javascript", "html", "css", "sql", "react"),
                        Arrays.asList("web development", "frontend development", "software engineering"),
                        Map.of("java", 20, "javascript", 20, "react", 20, "sql", 15, "html", 10, "css", 15),
                        Map.of("web development", 40, "frontend development", 35, "software engineering", 25)
                ),

                new CareerOption(
                        "Data Analyst",
                        "Analyzes data to generate insights and support business decision-making.",
                        Arrays.asList("sql", "python", "excel", "statistics", "power bi"),
                        Arrays.asList("data analysis", "business analytics", "data visualization"),
                        Map.of("sql", 25, "python", 20, "statistics", 20, "excel", 15, "power bi", 20),
                        Map.of("data analysis", 40, "business analytics", 35, "data visualization", 25)
                ),

                new CareerOption(
                        "Data Scientist",
                        "Uses statistics, programming and machine learning to solve data-driven problems.",
                        Arrays.asList("python", "statistics", "machine learning", "sql", "pandas", "numpy"),
                        Arrays.asList("data science", "machine learning", "artificial intelligence"),
                        Map.of("python", 25, "machine learning", 25, "statistics", 20, "sql", 10, "pandas", 10, "numpy", 10),
                        Map.of("data science", 40, "machine learning", 35, "artificial intelligence", 25)
                ),

                new CareerOption(
                        "DevOps Engineer",
                        "Automates software development, deployment and infrastructure operations.",
                        Arrays.asList("linux", "docker", "kubernetes", "git", "jenkins", "aws"),
                        Arrays.asList("devops", "cloud computing", "software engineering"),
                        Map.of("linux", 15, "docker", 20, "kubernetes", 20, "git", 10, "jenkins", 15, "aws", 20),
                        Map.of("devops", 45, "cloud computing", 35, "software engineering", 20)
                ),

                new CareerOption(
                        "Cloud Engineer",
                        "Designs, deploys and manages cloud infrastructure and services.",
                        Arrays.asList("aws", "azure", "linux", "docker", "networking", "terraform"),
                        Arrays.asList("cloud computing", "cloud engineering", "infrastructure"),
                        Map.of("aws", 25, "azure", 15, "linux", 15, "docker", 15, "networking", 15, "terraform", 15),
                        Map.of("cloud computing", 40, "cloud engineering", 35, "infrastructure", 25)
                ),

                new CareerOption(
                        "Cybersecurity Analyst",
                        "Protects systems and networks by identifying, monitoring and responding to security threats.",
                        Arrays.asList("networking", "linux", "python", "cybersecurity", "siem", "security"),
                        Arrays.asList("cybersecurity", "network security", "information security"),
                        Map.of("networking", 20, "linux", 15, "python", 15, "cybersecurity", 25, "siem", 15, "security", 10),
                        Map.of("cybersecurity", 45, "network security", 30, "information security", 25)
                )
        );
    }
}
