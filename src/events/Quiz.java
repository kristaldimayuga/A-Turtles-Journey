// File: events/Quiz
package events;

import db.DatabaseConnection;
import models.Turtle;
import utility.Utility;

import java.sql.*;
import java.util.*;

public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
        loadQuestionsFromDatabase();
    }

    private void loadQuestionsFromDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quiz");

            while (rs.next()) {
                int questionId = rs.getInt("quiz_id");
                String question = rs.getString("question");
                String correctAnswer = rs.getString("correct_answer");
                List<String> options = Arrays.asList(
                        correctAnswer,
                        rs.getString("wrong_answer_1"),
                        rs.getString("wrong_answer_2"),
                        rs.getString("wrong_answer_3")
                );
                Collections.shuffle(options); // Shuffle options
                questions.add(new Question(questionId, question, options, correctAnswer));
            }
        } catch (SQLException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
    }

    public void playQuiz(Turtle turtle, List<Integer> questionIds) {
        // Filter questions based on the provided IDs
        List<Question> selectedQuestions = new ArrayList<>();
        for (Question q : questions) {
            if (questionIds.contains(q.getId())) {
                selectedQuestions.add(q);
            }
        }

        for (Question q : selectedQuestions) {
            boolean validAnswer = false;
            while (!validAnswer) {
                Utility.typeWriter(q.getQuestion(), 30);
                for (int i = 0; i < q.getOptions().size(); i++) {
                    Utility.typeWriter((i + 1) + ": " + q.getOptions().get(i), 30);
                }

                String answer = Utility.getUserInput().trim();
                if (answer.isEmpty()) {
                    Utility.typeWriter("You didn't enter anything. Please try again.", 30);
                    continue;
                }

                try {
                    int choice = Integer.parseInt(answer);
                    if (choice >= 1 && choice <= q.getOptions().size()) {
                        validAnswer = true;
                        if (!q.isCorrectAnswer(choice)) {
                            turtle.setHealth(turtle.getHealth() - 20);
                            Utility.typeWriter("Incorrect! Health reduced to " + turtle.getHealth(), 30);
                            if (turtle.getHealth() <= 0) {
                                Utility.typeWriter("You failed! Restarting quiz...", 30);
                                turtle.setHealth(100); // Reset health and restart quiz
                                playQuiz(turtle, questionIds);
                                return;
                            }
                        } else {
                            Utility.typeWriter("Correct answer!", 30);
                        }
                    } else {
                        Utility.typeWriter("Invalid choice. Please select a number between 1 and " + q.getOptions().size(), 30);
                    }
                } catch (NumberFormatException e) {
                    Utility.typeWriter("Invalid input. Please enter a number corresponding to the options.", 30);
                }
            }
        }
        Utility.typeWriter("Quiz completed successfully!", 30);
    }

    private static class Question {
        private int id;
        private String question;
        private List<String> options;
        private String correctAnswer;

        public Question(int id, String question, List<String> options, String correctAnswer) {
            this.id = id;
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public int getId() {
            return id;
        }

        public String getQuestion() {
            return question;
        }

        public List<String> getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(int choice) {
            return options.get(choice - 1).equals(correctAnswer);
        }
    }
}
