package com.mhm.Springboot_Rest.service;

import com.mhm.Springboot_Rest.model.JobPost;
import com.mhm.Springboot_Rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        repo.save(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>();
//         Java Developer Job Post
        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));

        // Frontend Developer Job Post
        jobs.add(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")));

        // Data Scientist Job Post
        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                List.of("Python", "Machine Learning", "Data Analysis")));

        // Network Engineer Job Post
        jobs.add(new JobPost(4, "Network Engineer",
                "Design and implement computer networks for efficient data communication", 5,
                List.of("Networking", "Cisco", "Routing", "Switching")));

        // Mobile App Developer Job Post
        jobs
                .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")));

        // DevOps Engineer Job Post
        jobs.add(
                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));

        // UI/UX Designer Job Post
        jobs
                .add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
                        2, List.of("User Experience", "User Interface Design", "Prototyping")));

        // Cybersecurity Analyst Job Post
        jobs
                .add(new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
                        4, List.of("Cybersecurity", "Network Security", "Incident Response")));
        repo.saveAll(jobs);
    }

    public List<JobPost> keywordsearch(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
