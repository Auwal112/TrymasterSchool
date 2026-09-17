package com.trymaster.database;

import java.util.ArrayList;
import java.util.List;

public class Quizdata {

    public static ArrayList<Quiz> getQuizList() {

        ArrayList<Quiz> quizList = new ArrayList<>();

        // =====================================================
        // QUIZ 1: COMPUTER SCIENCE
        // =====================================================

        ArrayList<Question> computerQuestions = new ArrayList<>();

        computerQuestions.add(new Question(
								  1,
								  "What does CPU stand for?",
								  "Central Processing Unit",
								  "Computer Processing Unit",
								  "Central Program Unit",
								  "Computer Personal Unit",
								  "Central Processing Unit"
							  ));

        computerQuestions.add(new Question(
								  2,
								  "Which of these is an input device?",
								  "Monitor",
								  "Keyboard",
								  "Speaker",
								  "Projector",
								  "Keyboard"
							  ));

        computerQuestions.add(new Question(
								  3,
								  "What does RAM stand for?",
								  "Random Access Memory",
								  "Read Access Memory",
								  "Rapid Access Machine",
								  "Random Application Memory",
								  "Random Access Memory"
							  ));

        computerQuestions.add(new Question(
								  4,
								  "Which of these is an operating system?",
								  "Python",
								  "Linux",
								  "HTML",
								  "SQL",
								  "Linux"
							  ));

        computerQuestions.add(new Question(
								  5,
								  "Which data structure follows FIFO?",
								  "Stack",
								  "Queue",
								  "Tree",
								  "Graph",
								  "Queue"
							  ));

        computerQuestions.add(new Question(
								  6,
								  "Which data structure follows LIFO?",
								  "Queue",
								  "Stack",
								  "Array",
								  "Graph",
								  "Stack"
							  ));

        computerQuestions.add(new Question(
								  7,
								  "What does SQL mainly work with?",
								  "Images",
								  "Databases",
								  "Graphics",
								  "Audio",
								  "Databases"
							  ));

        computerQuestions.add(new Question(
								  8,
								  "Which device is used to display information?",
								  "Keyboard",
								  "Mouse",
								  "Monitor",
								  "Microphone",
								  "Monitor"
							  ));

        computerQuestions.add(new Question(
								  9,
								  "Which of these is a programming language?",
								  "Java",
								  "HTTP",
								  "HTML",
								  "Wi-Fi",
								  "Java"
							  ));

        computerQuestions.add(new Question(
								  10,
								  "What is the brain of a computer commonly called?",
								  "RAM",
								  "Hard Drive",
								  "CPU",
								  "Keyboard",
								  "CPU"
							  ));

        Quiz computerQuiz = new Quiz(
			1,
			"Computer Science Basics",
			"Test your knowledge of fundamental computer science concepts.",
			"Computer Science",
			10,
			computerQuestions
        );

        quizList.add(computerQuiz);


        // =====================================================
        // QUIZ 2: MATHEMATICS
        // =====================================================

        ArrayList<Question> mathQuestions = new ArrayList<>();

        mathQuestions.add(new Question(
							  1,
							  "What is 12 × 5?",
							  "50",
							  "55",
							  "60",
							  "65",
							  "60"
						  ));

        mathQuestions.add(new Question(
							  2,
							  "What is the square root of 81?",
							  "7",
							  "8",
							  "9",
							  "10",
							  "9"
						  ));

        mathQuestions.add(new Question(
							  3,
							  "What is 15 + 27?",
							  "32",
							  "40",
							  "42",
							  "45",
							  "42"
						  ));

        mathQuestions.add(new Question(
							  4,
							  "What is 100 ÷ 4?",
							  "20",
							  "25",
							  "30",
							  "40",
							  "25"
						  ));

        mathQuestions.add(new Question(
							  5,
							  "What is 2³?",
							  "4",
							  "6",
							  "8",
							  "12",
							  "8"
						  ));

        mathQuestions.add(new Question(
							  6,
							  "How many degrees are in a right angle?",
							  "45°",
							  "60°",
							  "90°",
							  "180°",
							  "90°"
						  ));

        mathQuestions.add(new Question(
							  7,
							  "What is 7²?",
							  "14",
							  "21",
							  "49",
							  "56",
							  "49"
						  ));

        mathQuestions.add(new Question(
							  8,
							  "What is the perimeter of a square with side 5 cm?",
							  "10 cm",
							  "15 cm",
							  "20 cm",
							  "25 cm",
							  "20 cm"
						  ));

        mathQuestions.add(new Question(
							  9,
							  "What is 3/4 as a decimal?",
							  "0.25",
							  "0.50",
							  "0.75",
							  "1.25",
							  "0.75"
						  ));

        mathQuestions.add(new Question(
							  10,
							  "What comes next: 2, 4, 6, 8, ...?",
							  "9",
							  "10",
							  "11",
							  "12",
							  "10"
						  ));

        Quiz mathQuiz = new Quiz(
			2,
			"Mathematics Basics",
			"Practice basic arithmetic and mathematical reasoning.",
			"Mathematics",
			10,
			mathQuestions
        );

        quizList.add(mathQuiz);


        // =====================================================
        // QUIZ 3: SCIENCE
        // =====================================================

        ArrayList<Question> scienceQuestions = new ArrayList<>();

        scienceQuestions.add(new Question(
								 1,
								 "Which planet is known as the Red Planet?",
								 "Earth",
								 "Mars",
								 "Jupiter",
								 "Venus",
								 "Mars"
							 ));

        scienceQuestions.add(new Question(
								 2,
								 "What gas do humans need to breathe?",
								 "Carbon dioxide",
								 "Nitrogen",
								 "Oxygen",
								 "Hydrogen",
								 "Oxygen"
							 ));

        scienceQuestions.add(new Question(
								 3,
								 "What is H₂O commonly known as?",
								 "Salt",
								 "Water",
								 "Oxygen",
								 "Hydrogen",
								 "Water"
							 ));

        scienceQuestions.add(new Question(
								 4,
								 "Which organ pumps blood around the body?",
								 "Liver",
								 "Lung",
								 "Heart",
								 "Kidney",
								 "Heart"
							 ));

        scienceQuestions.add(new Question(
								 5,
								 "What force pulls objects toward Earth?",
								 "Magnetism",
								 "Gravity",
								 "Friction",
								 "Electricity",
								 "Gravity"
							 ));

        scienceQuestions.add(new Question(
								 6,
								 "How many bones are approximately in an adult human body?",
								 "106",
								 "206",
								 "306",
								 "406",
								 "206"
							 ));

        scienceQuestions.add(new Question(
								 7,
								 "Which part of a plant absorbs water from the soil?",
								 "Flower",
								 "Leaf",
								 "Root",
								 "Fruit",
								 "Root"
							 ));

        scienceQuestions.add(new Question(
								 8,
								 "What is the closest star to Earth?",
								 "Moon",
								 "Mars",
								 "Sun",
								 "Sirius",
								 "Sun"
							 ));

        scienceQuestions.add(new Question(
								 9,
								 "Which state of matter has a fixed volume but no fixed shape?",
								 "Solid",
								 "Liquid",
								 "Gas",
								 "Plasma",
								 "Liquid"
							 ));

        scienceQuestions.add(new Question(
								 10,
								 "Which instrument measures temperature?",
								 "Barometer",
								 "Thermometer",
								 "Speedometer",
								 "Hygrometer",
								 "Thermometer"
							 ));

        Quiz scienceQuiz = new Quiz(
			3,
			"Science Basics",
			"Test your knowledge of basic science concepts.",
			"Science",
			10,
			scienceQuestions
        );

        quizList.add(scienceQuiz);


        // =====================================================
        // QUIZ 4: JAVA PROGRAMMING
        // =====================================================

        ArrayList<Question> javaQuestions = new ArrayList<>();

        javaQuestions.add(new Question(
							  1,
							  "Which keyword is used to create a class in Java?",
							  "class",
							  "Class",
							  "new",
							  "object",
							  "class"
						  ));

        javaQuestions.add(new Question(
							  2,
							  "Which keyword is used to create an object?",
							  "create",
							  "object",
							  "new",
							  "make",
							  "new"
						  ));

        javaQuestions.add(new Question(
							  3,
							  "Which data type stores whole numbers?",
							  "String",
							  "int",
							  "boolean",
							  "double",
							  "int"
						  ));

        javaQuestions.add(new Question(
							  4,
							  "Which data type stores true or false?",
							  "int",
							  "String",
							  "boolean",
							  "char",
							  "boolean"
						  ));

        javaQuestions.add(new Question(
							  5,
							  "Which symbol normally ends a Java statement?",
							  ".",
							  ",",
							  ";",
							  ":",
							  ";"
						  ));

        javaQuestions.add(new Question(
							  6,
							  "Which collection can contain duplicate elements?",
							  "ArrayList",
							  "HashSet",
							  "Set",
							  "None",
							  "ArrayList"
						  ));

        javaQuestions.add(new Question(
							  7,
							  "What does OOP stand for?",
							  "Object Oriented Programming",
							  "Open Operating Program",
							  "Object Operating Process",
							  "Online Object Programming",
							  "Object Oriented Programming"
						  ));

        javaQuestions.add(new Question(
							  8,
							  "Which loop is commonly used when the number of iterations is known?",
							  "for loop",
							  "while loop",
							  "if statement",
							  "switch",
							  "for loop"
						  ));

        javaQuestions.add(new Question(
							  9,
							  "Which keyword is used for class inheritance?",
							  "implements",
							  "extends",
							  "inherits",
							  "super",
							  "extends"
						  ));

        javaQuestions.add(new Question(
							  10,
							  "What is the usual entry point of a Java program?",
							  "start()",
							  "run()",
							  "main()",
							  "begin()",
							  "main()"
						  ));

        Quiz javaQuiz = new Quiz(
			4,
			"Java Programming",
			"Test your knowledge of fundamental Java programming.",
			"Programming",
			10,
			javaQuestions
        );

        quizList.add(javaQuiz);


        // =====================================================
        // QUIZ 5: GENERAL KNOWLEDGE
        // =====================================================

        ArrayList<Question> generalQuestions = new ArrayList<>();

        generalQuestions.add(new Question(
								 1,
								 "What is the capital of Nigeria?",
								 "Kano",
								 "Lagos",
								 "Abuja",
								 "Kaduna",
								 "Abuja"
							 ));

        generalQuestions.add(new Question(
								 2,
								 "How many days are in a normal year?",
								 "364",
								 "365",
								 "366",
								 "360",
								 "365"
							 ));

        generalQuestions.add(new Question(
								 3,
								 "Which is the largest ocean?",
								 "Atlantic Ocean",
								 "Indian Ocean",
								 "Pacific Ocean",
								 "Arctic Ocean",
								 "Pacific Ocean"
							 ));

        generalQuestions.add(new Question(
								 4,
								 "How many continents are commonly recognized?",
								 "5",
								 "6",
								 "7",
								 "8",
								 "7"
							 ));

        generalQuestions.add(new Question(
								 5,
								 "Which planet is the largest in our solar system?",
								 "Earth",
								 "Mars",
								 "Jupiter",
								 "Saturn",
								 "Jupiter"
							 ));

        generalQuestions.add(new Question(
								 6,
								 "How many hours are in one day?",
								 "12",
								 "18",
								 "24",
								 "48",
								 "24"
							 ));

        generalQuestions.add(new Question(
								 7,
								 "Which month comes after June?",
								 "May",
								 "July",
								 "August",
								 "September",
								 "July"
							 ));

        generalQuestions.add(new Question(
								 8,
								 "In which direction does the sun rise?",
								 "West",
								 "North",
								 "South",
								 "East",
								 "East"
							 ));

        generalQuestions.add(new Question(
								 9,
								 "How many sides does a triangle have?",
								 "2",
								 "3",
								 "4",
								 "5",
								 "3"
							 ));

        generalQuestions.add(new Question(
								 10,
								 "Which animal is commonly known as the king of the jungle?",
								 "Tiger",
								 "Lion",
								 "Elephant",
								 "Leopard",
								 "Lion"
							 ));

        Quiz generalQuiz = new Quiz(
			5,
			"General Knowledge",
			"Test yourself with simple general knowledge questions.",
			"General Knowledge",
			10,
			generalQuestions
        );

        quizList.add(generalQuiz);


        // =====================================================
        // RETURN ALL QUIZZES
        // =====================================================

        return quizList;
    }
}
