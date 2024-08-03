import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class question {
    String question;
    List<String> options;
    int correctAnswer;

    question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswer;
    }
}

class quizGenerator {
    ArrayList<question> questions;
    int total = 0;// to calculate score

    quizGenerator() {
        questions = new ArrayList<>();
    }

    public void addQuestion(question questions) {
        this.questions.add(questions);
    }

    public void StartQuiz() {
        for (question q : questions) {
            System.out.println(q.getQuestion());
            List<String> option = q.getOptions();
            for (int i = 0; i < option.size(); i++) {
                System.out.println((i + 1) + "." + option.get(i));
            }
            System.out.println("ENTER YOUR OPTION: ");
            Scanner input = new Scanner(System.in);
            int answerIndex = input.nextInt() - 1; // decrease by 1 coz index are starting from 0
            if (q.isCorrect(answerIndex)) {
                System.out.println("CORRECT");
                total++;

            } else {
                System.out.println("INCORRECT");
                System.out.println("THE COORECT ANSWER IS " + option.get(q.correctAnswer));
            }
        }
        if (total == questions.size()) {
            System.out.println("CONGRATULATIONS YOU HAVE COMPLETED THE QUIZ!!!");// if user answer all the qustion right
                                                                                 // it will print
        } else
            System.out.println("YOUR TOTAL SCORE IS " + total + "/" + questions.size());// or else ethis will print

    }

    public static void main(String[] args) {
        quizGenerator quiz = new quizGenerator();
        quiz.addQuestion(new question("What is the largest mammal in the world?",
                List.of("Elephant", "Blue whale", "Giraffe", "Hippopotamus"), 1));
        quiz.addQuestion(new question("What is the square root of 64?", List.of("6", "7", "8", "9"), 2));
        quiz.addQuestion(new question("Which ocean is the largest?",
                List.of("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), 3));
        quiz.addQuestion(new question("What is the largest continent?",
                List.of("Africa", "Asia", "Europe", "South America"), 1));
        quiz.addQuestion(new question("How many colors are there in a rainbow?", List.of("5", "6", "7", "8"), 2));
        quiz.addQuestion(new question("Which animal is known for its black and white stripes?",
                List.of("Zebra", "Tiger", "Penguin", "Panda"), 0));
        quiz.addQuestion(new question("What is the name of the galaxy we live in?",
                List.of("Andromeda Galaxy", "Sombrero Galaxy", "Milky Way Galaxy", "Whirlpool Galaxy"), 2));
        quiz.StartQuiz();

    }
}
