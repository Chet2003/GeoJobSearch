package com.example.cis4900.old_notes_infra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api/job")
public class JobController {

    // @GetMapping("/dummy")
    @GetMapping("/search")
    public Object getDummyData() {
        // Create dummy JSON data
        return DummyDataGenerator.generateDummyData();
    }

public class DummyDataGenerator {

    public static class Job {
        public String position;
        public String salary;
        public String description;
        public String location;

        public Job(String position, String salary, String description, String location) {
            this.position = position;
            this.salary = salary;
            this.description = description;
            this.location = location;
        }
    }

    public static List<Job> generateDummyData() {
        List<Job> jobs = new ArrayList<>();
            jobs.add(new Job("Engineer", "40,000", "Responsible for designing and implementing complex systems to meet client specifications. Requires strong problem-solving skills and proficiency in relevant programming languages.", "Guelph"));
            jobs.add(new Job("Developer", "60,000", "Works on developing and maintaining software applications, collaborating with cross-functional teams to deliver high-quality products. Proficiency in languages such as Java, Python, or JavaScript is required.", "Waterloo"));
            jobs.add(new Job("Cook", "120,000", "Leads the kitchen team in preparing and cooking a variety of dishes, ensuring high standards of food quality, taste, and presentation. Experience in a fast-paced kitchen environment is preferred.", "London"));
            
            // Additional jobs
            jobs.add(new Job("Marketing Coordinator", "45,000", "Plans and executes marketing campaigns across various channels, including social media, email, and print. Analyzes market trends and consumer behavior to optimize campaign performance.", "Toronto"));
            jobs.add(new Job("Financial Analyst", "70,000", "Conducts financial analysis and provides insights to support strategic decision-making. Prepares financial reports, forecasts, and budgets to guide business planning and performance evaluation.", "Montreal"));
            jobs.add(new Job("Graphic Designer", "55,000", "Creates visual concepts using computer software or by hand to communicate ideas that inspire, inform, or captivate consumers. Collaborates with clients or creative directors to translate project requirements into visual designs.", "Vancouver"));
            jobs.add(new Job("HR Manager", "80,000", "Oversees all aspects of human resources practices and processes, including recruitment, training, performance management, and employee relations. Develops and implements HR strategies aligned with organizational goals.", "Calgary"));
            jobs.add(new Job("Sales Representative", "50,000", "Sells products or services to potential customers, establishes and maintains customer relationships, and achieves sales targets. Identifies new business opportunities and follows up on leads.", "Edmonton"));
            jobs.add(new Job("Data Scientist", "90,000", "Applies statistical analysis and machine learning techniques to interpret complex data sets, generate actionable insights, and solve real-world business problems. Proficiency in programming languages like R or Python is required.", "Ottawa"));
            jobs.add(new Job("Customer Service Manager", "65,000", "Leads and supervises a team of customer service representatives, ensuring high-quality service delivery and customer satisfaction. Develops service procedures, policies, and standards.", "Halifax"));
            jobs.add(new Job("Architect", "85,000", "Designs and oversees the construction of buildings and structures, ensuring compliance with building codes, zoning regulations, and project specifications. Collaborates with clients, engineers, and contractors throughout the project lifecycle.", "Quebec City"));
            jobs.add(new Job("Content Writer", "40,000", "Creates engaging and informative content for websites, blogs, social media, and other digital platforms. Conducts research on industry-related topics and collaborates with the marketing team to develop content strategies.", "Winnipeg"));
            jobs.add(new Job("IT Support Specialist", "55,000", "Provides technical assistance and support to end-users for hardware, software, and network-related issues. Troubleshoots and resolves technical problems, escalating complex issues as needed.", "Regina"));
            jobs.add(new Job("Project Manager", "75,000", "Leads cross-functional teams to deliver projects on time, within budget, and according to specifications. Develops project plans, schedules, and budgets, and communicates progress to stakeholders.", "Saskatoon"));
            jobs.add(new Job("Executive Assistant", "60,000", "Provides administrative support to senior executives, managing schedules, coordinating meetings, and handling correspondence. Acts as a liaison between executives and internal/external stakeholders.", "Victoria"));
            jobs.add(new Job("Electrician", "70,000", "Installs, repairs, and maintains electrical systems and equipment in residential, commercial, or industrial settings. Ensures compliance with safety regulations and electrical codes.", "Hamilton"));
            jobs.add(new Job("Mechanical Engineer", "80,000", "Designs, develops, and tests mechanical devices, equipment, and systems. Applies principles of engineering, physics, and materials science to solve engineering problems.", "Kelowna"));
            jobs.add(new Job("Registered Nurse", "85,000", "Provides compassionate and comprehensive nursing care to patients in various healthcare settings. Collaborates with physicians and other healthcare professionals to assess, plan, and implement patient care.", "St. John's"));
            jobs.add(new Job("UX/UI Designer", "70,000", "Creates user-centric designs for digital products and platforms, focusing on usability, accessibility, and visual appeal. Conducts user research, wireframing, and prototyping to optimize the user experience.", "Fredericton"));
            jobs.add(new Job("Supply Chain Manager", "90,000", "Oversees all aspects of the supply chain, including procurement, logistics, inventory management, and distribution. Develops strategies to optimize efficiency, reduce costs, and improve quality.", "Charlottetown"));
            jobs.add(new Job("Real Estate Agent", "75,000", "Assists clients in buying, selling, or renting properties. Markets properties, negotiates sales contracts, and guides clients through the transaction process. Requires strong interpersonal and sales skills.", "Moncton"));
            jobs.add(new Job("Quality Assurance Analyst", "65,000", "Ensures the quality of software products through rigorous testing and analysis. Develops test plans, executes test cases, and reports defects to improve product reliability and user satisfaction.", "Yellowknife"));
            jobs.add(new Job("Mechanic", "55,000", "Repairs and maintains vehicles, diagnosing mechanical issues, and performing necessary repairs or replacements. Conducts inspections and ensures vehicles meet safety and performance standards.", "Whitehorse"));
            jobs.add(new Job("Legal Assistant", "50,000", "Provides administrative support to lawyers and legal professionals, including drafting documents, scheduling appointments, and managing client files. Conducts legal research and assists in case preparation.", "Iqaluit"));
            jobs.add(new Job("Event Planner", "60,000", "Plans and coordinates events, such as weddings, conferences, and parties, from conception to execution. Manages budgets, negotiates with vendors, and ensures events run smoothly.", "Halifax"));
            jobs.add(new Job("Fitness Instructor", "45,000", "Leads fitness classes and provides personalized training to help clients achieve their fitness goals. Designs exercise programs, demonstrates proper techniques, and motivates clients to stay active.", "Kelowna"));
            jobs.add(new Job("Web Developer", "70,000", "Designs and develops websites and web applications using programming languages such as HTML, CSS, and JavaScript. Collaborates with clients to understand requirements and deliver customized solutions.", "Regina"));
            jobs.add(new Job("Social Worker", "65,000", "Provides counseling, support, and advocacy services to individuals and families facing social, emotional, or economic challenges. Collaborates with other professionals to develop and implement intervention plans.", "Fredericton"));
        // Add more jobs as needed
        return jobs;
    }

    public static void main(String[] args) {
        List<Job> dummyJobData = generateDummyData();
        for (Job job : dummyJobData) {
            System.out.println("Position: " + job.position);
            System.out.println("Salary: " + job.salary);
            System.out.println("Description: " + job.description);
            System.out.println("Location: " + job.location);
            System.out.println();
        }
    }
}

}
