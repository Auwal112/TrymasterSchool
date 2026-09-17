package com.trymaster.data;

import java.util.ArrayList;

public class DashboardData {

    public static DashboardStats getStats() {

        return new DashboardStats(
                12,  // quizzes completed
                3,   // courses enrolled
                1,   // courses completed
                5,   // badges
                1,   // certificates
                7    // learning streak
        );
    }


    public static ArrayList<Course> getCourses() {

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course(
                1,
                "Java Programming",
                "course_java",
                12,
                9
        ));

        courses.add(new Course(
                2,
                "Python Programming",
                "course_python",
                15,
                5
        ));

        courses.add(new Course(
                3,
                "Mathematics",
                "course_math",
                10,
                10
        ));

        return courses;
    }


    public static ArrayList<Certificate> getCertificates() {

        ArrayList<Certificate> certificates = new ArrayList<>();

        certificates.add(new Certificate(
                1,
                "Java Programming",
                "September 2026"
        ));

        certificates.add(new Certificate(
                2,
                "Mathematics",
                "August 2026"
        ));

        return certificates;
    }


    public static ArrayList<Badge> getBadges() {

        ArrayList<Badge> badges = new ArrayList<>();

        badges.add(new Badge(
                1,
                "First Quiz",
                "Completed your first quiz",
                R.drawable.ic_badge
        ));

        badges.add(new Badge(
                2,
                "Quiz Master",
                "Completed 10 quizzes",
                R.drawable.ic_badge
        ));

        badges.add(new Badge(
                3,
                "Perfect Score",
                "Scored 100% in a quiz",
                R.drawable.ic_badge
        ));

        badges.add(new Badge(
                4,
                "Learner",
                "Enrolled in your first course",
                R.drawable.ic_badge
        ));

        return badges;
    }


    public static ArrayList<QuizResult> getQuizResults() {

        ArrayList<QuizResult> results = new ArrayList<>();

        results.add(new QuizResult(
                1,
                "Java Programming Basics",
                "Programming",
                8,
                10
        ));

        results.add(new QuizResult(
                2,
                "Mathematics Basics",
                "Mathematics",
                9,
                10
        ));

        results.add(new QuizResult(
                3,
                "Science Basics",
                "Science",
                7,
                10
        ));

        results.add(new QuizResult(
                4,
                "Computer Science",
                "Computer Science",
                10,
                10
        ));

        return results;
    }
}
