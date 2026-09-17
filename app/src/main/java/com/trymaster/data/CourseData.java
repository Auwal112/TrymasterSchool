package com.trymaster.data;


import java.util.ArrayList;
import java.util.List;
import com.trymaster.database.*;

public class CourseData {

    public static ArrayList<Course> getCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        Course java = new Course(
            1,
            "Java Programming",
            "Learn the fundamentals of Java programming from variables to object-oriented programming.",
            "Build a strong foundation in Java and develop real applications."
        );

        Course python = new Course(
            2,
            "Python Programming",
            "Learn Python programming and develop problem-solving skills.",
            "Understand Python fundamentals and use Python to build useful programs."
        );

        Course mathematics = new Course(
            3,
            "Mathematics Basics",
            "Develop a strong foundation in mathematics for programming and technical studies.",
            "Improve mathematical reasoning and problem-solving skills."
        );

        Course computerScience = new Course(
            4,
            "Computer Science Fundamentals",
            "Learn the fundamental concepts behind computers, algorithms and programming.",
            "Understand how computers solve problems and process information."
        );

        courses.add(java);
        courses.add(python);
        courses.add(mathematics);
        courses.add(computerScience);

        return courses;
    }


    public static ArrayList<Topic> getTopics() {

        ArrayList<Topic> topics = new ArrayList<>();

        // =========================
        // JAVA PROGRAMMING
        // =========================

        topics.add(new Topic(
					   1,
					   1,
					   4,
					   "Introduction to Java",
					   "Understand what Java is and how Java programs work.",
					   "https://example.com/java-introduction",
					   "java_introduction.pdf"
				   ));

        topics.add(new Topic(
					   2,
					   1,
					   5,
					   "Variables and Data Types",
					   "Learn how Java stores and represents different types of data.",
					   "https://example.com/java-variables",
					   "java_variables.pdf"
				   ));

        topics.add(new Topic(
					   3,
					   1,
					   6,
					   "Conditional Statements",
					   "Learn how to make decisions using if, else and switch.",
					   "https://example.com/java-conditionals",
					   "java_conditionals.pdf"
				   ));

        topics.add(new Topic(
					   4,
					   1,
					   7,
					   "Loops",
					   "Understand repetition using for, while and do-while loops.",
					   "https://example.com/java-loops",
					   "java_loops.pdf"
				   ));

        topics.add(new Topic(
					   5,
					   1,
					   8,
					   "Object-Oriented Programming",
					   "Understand classes, objects, inheritance and encapsulation.",
					   "https://example.com/java-oop",
					   "java_oop.pdf"
				   ));


        // =========================
        // PYTHON PROGRAMMING
        // =========================

        topics.add(new Topic(
					   6,
					   2,
					   9,
					   "Introduction to Python",
					   "Understand Python syntax and write your first Python programs.",
					   "https://example.com/python-introduction",
					   "python_introduction.pdf"
				   ));

        topics.add(new Topic(
					   7,
					   2,
					   10,
					   "Variables and Data Types",
					   "Learn how Python represents numbers, strings and other data.",
					   "https://example.com/python-data-types",
					   "python_data_types.pdf"
				   ));

        topics.add(new Topic(
					   8,
					   2,
					   11,
					   "Conditions",
					   "Use conditional statements to control program execution.",
					   "https://example.com/python-conditions",
					   "python_conditions.pdf"
				   ));

        topics.add(new Topic(
					   9,
					   2,
					   12,
					   "Loops",
					   "Learn how to repeat operations using Python loops.",
					   "https://example.com/python-loops",
					   "python_loops.pdf"
				   ));

        topics.add(new Topic(
					   10,
					   2,
					   13,
					   "Functions",
					   "Learn how to organize reusable code using functions.",
					   "https://example.com/python-functions",
					   "python_functions.pdf"
				   ));


        // =========================
        // MATHEMATICS
        // =========================

        topics.add(new Topic(
					   11,
					   3,
					   14,
					   "Numbers and Operations",
					   "Understand basic numerical operations and their properties.",
					   "https://example.com/math-numbers",
					   "math_numbers.pdf"
				   ));

        topics.add(new Topic(
					   12,
					   3,
					   15,
					   "Algebra",
					   "Learn variables, equations and algebraic expressions.",
					   "https://example.com/math-algebra",
					   "math_algebra.pdf"
				   ));

        topics.add(new Topic(
					   13,
					   3,
					   16,
					   "Functions",
					   "Understand functions, inputs, outputs and graphical representation.",
					   "https://example.com/math-functions",
					   "math_functions.pdf"
				   ));

        topics.add(new Topic(
					   14,
					   3,
					   17,
					   "Geometry",
					   "Learn fundamental concepts involving shapes, angles and measurements.",
					   "https://example.com/math-geometry",
					   "math_geometry.pdf"
				   ));

        topics.add(new Topic(
					   15,
					   3,
					   18,
					   "Probability",
					   "Understand basic probability and uncertainty.",
					   "https://example.com/math-probability",
					   "math_probability.pdf"
				   ));


        // =========================
        // COMPUTER SCIENCE
        // =========================

        topics.add(new Topic(
					   16,
					   4,
					   19,
					   "What is Computer Science?",
					   "Understand the fundamental ideas behind computer science.",
					   "https://example.com/cs-introduction",
					   "cs_introduction.pdf"
				   ));

        topics.add(new Topic(
					   17,
					   4,
					   20,
					   "Algorithms",
					   "Learn how problems can be solved using step-by-step procedures.",
					   "https://example.com/algorithms",
					   "algorithms.pdf"
				   ));

        topics.add(new Topic(
					   18,
					   4,
					   21,
					   "Data Structures",
					   "Understand how data can be organized and stored efficiently.",
					   "https://example.com/data-structures",
					   "data_structures.pdf"
				   ));

        topics.add(new Topic(
					   19,
					   4,
					   22,
					   "Graphs",
					   "Learn how relationships and networks can be represented using graphs.",
					   "https://example.com/graphs",
					   "graphs.pdf"
				   ));

        topics.add(new Topic(
					   20,
					   4,
					   23,
					   "Problem Solving",
					   "Develop systematic approaches to solving computational problems.",
					   "https://example.com/problem-solving",
					   "problem_solving.pdf"
				   ));

        return topics;
    }


    // Get topics belonging to one course
    public static ArrayList<Topic> getTopicsByCourse(int courseId) {

        ArrayList<Topic> result = new ArrayList<>();

        for (Topic topic : getTopics()) {

            if (topic.getCourse_id() == courseId) {
                result.add(topic);
            }
        }

        return result;
    }
}
