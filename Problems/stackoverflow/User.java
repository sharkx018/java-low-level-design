package Problems.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private int reputation;

    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;


    private static  int QUESTION_REPUTATION = 5;
    private static  int ANSWER_REPUTATION = 10;
    private static  int COMMENT_REPUTATION = 2;

    public User(int id, String username, String email){
        this.id = id;
        this.username = username;
        this.email = email;
        this.reputation = 0;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question question = new Question(this, content, title, tags);
        this.questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content){
        Answer answer = new Answer(this, question, content);
        this.answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String comment){
        Comment comment1 = new Comment(comment, this);
        this.comments.add(comment1);
        commentable.addComment(comment1);
        updateReputation(COMMENT_REPUTATION);
        return comment1;

    }

    public synchronized void updateReputation(int value){
        this.reputation += value;
        if(reputation < 0){
            reputation = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public int getReputation() {
        return reputation;
    }

}
