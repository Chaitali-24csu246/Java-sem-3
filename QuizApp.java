interface Evaluatable {
    void evaluate();
}
abstract class Quiz implements Evaluatable{
    String title;
    Quiz (){
    this.title="ANY QUIZ";
}
//parameterized constructor
Quiz (String title){
    this.title=title;}
void showTitle(){
    System.out.println("Quiz: "+title);
}

abstract void startQuiz();
}
class MCQQuiz extends Quiz {
    //constructor parameterized using super
    MCQQuiz(){
        super("MCQ Quiz");
    }
    void startQuiz(){
        System.out.println("Starting MCQ Quiz");
    }
    public void evaluate(){
        System.out.println("Evaluating MCQ Quiz");      }

}
class TrueFalseQuiz extends Quiz {
    TrueFalseQuiz(){
        super("True/False Quiz");
        }
    void startQuiz(){
        System.out.println("Starting True/False Quiz");
    }
    public void evaluate(){
        System.out.println("Evaluating True/False Quiz");      }

}
class CodingQuiz extends Quiz {
    CodingQuiz(){
        super("Coding Quiz");
    }
    void startQuiz(){
        System.out.println("Starting Coding Quiz");
    }
    public void evaluate(){
        System.out.println("Evaluating Coding Quiz");      }

}
public class QuizApp {
    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[3];//polymorphism (runtime)
        quizzes[0] = new MCQQuiz();
        quizzes[1] = new TrueFalseQuiz();
        quizzes[2] = new CodingQuiz();

        for(Quiz quiz : quizzes){
            quiz.showTitle();
            quiz.startQuiz();
            quiz.evaluate();
            System.out.println();   }    
    }       }