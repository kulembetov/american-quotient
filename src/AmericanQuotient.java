import java.util.Scanner;
import java.util.Random;

// American Quotient: How American Are You? - A quiz game to measure your knowledge of U.S. history, geography, civics, and culture.
public class AmericanQuotient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // defining questions array
        String[] questions = {
                "What city is known as the birthplace of jazz?",
                "Which state is famous for Hollywood?",
                "What year was the Declaration of Independence signed?",
                "Who wrote the novel 'To Kill a Mockingbird'?",
                "What is the capital of the United States?",
                "Which U.S. president is on the $1 bill?",
                "What is the largest national park in the U.S.?",
                "Which state is known as 'The Land of 10,000 Lakes'?",
                "Where is the Grand Canyon located?",
                "What is the official currency of the United States?",
                "Who is in charge of the executive branch?",
                "We elect a U.S. Senator for how many years?",
                "Who makes federal laws?",
                "What are the two parts of the U.S. Congress?",
                "How many justices are on the Supreme Court?",
                "Who wrote the Declaration of Independence?",
                "What territory did the United States buy from France in 1803?",
                "Who was President during the Great Depression and World War II?",
                "What did Martin Luther King Jr. do?",
                "During the Cold War, what was the main concern of the United States?",
                "What is the name of the national anthem?",
                "Which amendment provides the right to freedom of speech?",
                "What was the main purpose of the Lewis and Clark expedition?",
                "What is the economic system in the United States?",
                "Which state is known for its potatoes?",
                "What year did the United States land a man on the moon?",
                "What is the tallest mountain in North America?",
                "Who was the first woman to fly solo across the Atlantic?",
                "What is the smallest U.S. state by area?"
        };
        // options for each question, corresponding to the questions array
        String[][] options = {
                {"A. Chicago", "B. New Orleans", "C. New York", "D. Los Angeles"},
                {"A. New York", "B. Florida", "C. California", "D. Nevada"},
                {"A. 1776", "B. 1783", "C. 1790", "D. 1765"},
                {"A. Ernest Hemingway", "B. Harper Lee", "C. J.D. Salinger", "D. Mark Twain"},
                {"A. Philadelphia", "B. Washington D.C.", "C. New York City", "D. Boston"},
                {"A. Abraham Lincoln", "B. George Washington", "C. Thomas Jefferson", "D. Benjamin Franklin"},
                {"A. Yellowstone", "B. Yosemite", "C. Denali", "D. Wrangell-St. Elias"},
                {"A. Michigan", "B. Minnesota", "C. Wisconsin", "D. Alaska"},
                {"A. Utah", "B. Arizona", "C. Nevada", "D. Colorado"},
                {"A. Euro", "B. Dollar", "C. Pound", "D. Yen"},
                {"A. The President", "B. The Speaker of the House", "C. The Chief Justice", "D. The Majority Leader"},
                {"A. 4", "B. 6", "C. 8", "D. 10"},
                {"A. The President", "B. The Senate", "C. Congress", "D. The Supreme Court"},
                {"A. The Senate and House of Representatives", "B. The Supreme Court and the House of Representatives", "C. The Senate and the Courts", "D. The House of Representatives and the Courts"},
                {"A. 9", "B. 10", "C. 11", "D. 12"},
                {"A. George Washington", "B. Thomas Jefferson", "C. John Adams", "D. James Madison"},
                {"A. Alaska", "B. Louisiana", "C. Texas", "D. California"},
                {"A. Franklin D. Roosevelt", "B. Herbert Hoover", "C. Harry S. Truman", "D. Dwight D. Eisenhower"},
                {"A. Developed the polio vaccine", "B. Led the United States during the Civil War", "C. Fought for civil rights and equality", "D. Made the first flight in a powered airplane"},
                {"A. Communism", "B. Terrorism", "C. Imperialism", "D. Fascism"},
                {"A. The Star-Spangled Banner", "B. America the Beautiful", "C. God Bless America", "D. Yankee Doodle"},
                {"A. 1st Amendment", "B. 2nd Amendment", "C. 4th Amendment", "D. 5th Amendment"},
                {"A. To find a direct water route to the Pacific", "B. To study the area's plants, animal life, and geography", "C. To establish trade with Native American tribes", "D. All of the above"},
                {"A. Capitalist", "B. Socialist", "C. Communist", "D. Mixed Economy"},
                {"A. Idaho", "B. Washington", "C. Maine", "D. Utah"},
                {"A. 1969", "B. 1972", "C. 1965", "D. 1980"},
                {"A. Mount McKinley (Denali)", "B. Mount Rainier", "C. Mount Whitney", "D. Mount Elbert"},
                {"A. Amelia Earhart", "B. Sally Ride", "C. Harriet Quimby", "D. Bessie Coleman"},
                {"A. Rhode Island", "B. Delaware", "C. Connecticut", "D. New Jersey"}
        };
        // answers for each question, must be updated as questions change or are added
        char[] answers = {
                'B', 'C', 'A', 'B', 'B', 'B', 'D', 'B', 'B', 'B',
                'A', 'B', 'C', 'A', 'A', 'B', 'B', 'A', 'C', 'A',
                'A', 'A', 'D',
                'A', 'A', 'A', 'A', 'A', 'A'
        };
        // user responses array to store answers from the user
        char[] userResponses = new char[questions.length];
        // initialize store
        int score = 0;
        // for randomizing question order
        int[] questionOrder = new int[questions.length];

        // randomizing question order to enhance game replayability
        for (int i = 0; i < questionOrder.length; i++) {
            // fill array sequentially
            questionOrder[i] = i;
        }
        // swap question with random index
        for (int i = 0; i < questionOrder.length; i++) {
            int randomIndex = random.nextInt(questionOrder.length);
            int temp = questionOrder[i];
            questionOrder[i] = questionOrder[randomIndex];
            questionOrder[randomIndex] = temp;
        }

        System.out.println("Welcome to American Quotient: How American Are You?! Test your U.S. knowledge.");

        // main quiz loop, iterating over shuffled questions
        for (int i = 0; i < questionOrder.length; i++) {
            int questionIndex = questionOrder[i];
            System.out.println("\nQuestion " + (i + 1));
            System.out.println(questions[questionIndex]);
            for (String option : options[questionIndex]) {
                System.out.println(option);
            }

            // capturing user's response
            char response;
            do {
                System.out.print("Choose A, B, C, or D: ");
                response = scanner.nextLine().toUpperCase().charAt(0);
                if (response < 'A' || response > 'D') {
                    System.out.println("Invalid choice. Try again.");
                }
            } while (response < 'A' || response > 'D');

            // store response
            userResponses[questionIndex] = response;

            // update score if answer is correct
            if (response == answers[questionIndex]) {
                score++;
            }
        }

        // calculate and display final score as a percentage
        double percentage = (double) score / questions.length * 100;
        System.out.printf("\nQuiz complete! Your score: %d/%d - %.2f%%\n", score, questions.length, percentage);

        if (percentage <= 25) {
            System.out.println("There's always room for improvement. Keep learning!");
        } else if (percentage <= 50) {
            System.out.println("Good effort! A little more study and you'll be there.");
        } else if (percentage <= 75) {
            System.out.println("Great job! You definitely know your U.S. facts. Are you sure you don't already have a U.S. passport?");
        } else {
            System.out.println("Outstanding! Celebrate your knowledge. You're a true American history buff!");
        }

        System.out.println("Thank you for playing!");

        scanner.close();
    }
}