package Problems.stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {

    private static StackOverFlow instance;
    private Map<Integer, User> users;
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
    private Map<String, Tag> tags;

    private StackOverFlow(){
        users = new ConcurrentHashMap<>();
        questions = new ConcurrentHashMap<>();
        answers = new ConcurrentHashMap<>();
        tags = new ConcurrentHashMap<>();
    }

    public synchronized static StackOverFlow getInstance(){
        if(instance == null){
            instance = new StackOverFlow();
        }
        return instance;
    }

    // registerUser
    public User registerUser(String username, String email){
        int id = users.size() + 1;
        User user = new User(id, username, email);
        this.users.put(user.getId(), user);

        return user;

    }

    // ask Question
    public Question askQuestion(User user, String title, String content, List<String> tags){
        Question question = user.askQuestion(content, title, tags);
        this.questions.put(question.getId(), question);
        for(Tag tag: question.getTags()){
            this.tags.putIfAbsent(tag.getName(), tag);
        }

        return question;
    }

    // answer question
    public Answer answerQuestion(User user, Question question, String content){
        Answer answer = user.answerQuestion(question, content);
        this.answers.put(answer.getId(), answer);
        return answer;
    }


    // vote question
    public void voteQuestion(User user, Question question, int value){
        question.vote(user, value);
    }

    // vote answer
    public void voteAnswer(User user, Answer answer, int value){
        answer.vote(user, value);
    }

    // add comment
    public void addComment(User user, Commentable commentable, String content){
        user.addComment(commentable, content);
    }

    // accept answer
    public void acceptAnswer(Answer answer){
        answer.markAsAccepted();
    }

    // search questions
    public List<Question> searchQuestion(String query){
        return this.questions
                .values()
                .stream()
                .filter(
                    q->q.getTitle().toLowerCase().equals(query) ||
                    q.getContent().toLowerCase().equals(query) ||
                    q.getTags().stream().anyMatch(t -> t.getName().toLowerCase().equals(query)))
                .collect(Collectors.toList());
    }

    // get questions by userid;
    public List<Question> getQuestionByUser(User user){
        return user.getQuestions();
    }

    // getters
    public User getUser(int id){
        return this.users.get(id);
    }

    public Question getQuestion(int id){
        return this.questions.get(id);
    }

    public Answer getAnswer(int id){
        return this.answers.get(id);
    }

    public Tag getTag(String name){
        return this.tags.get(name);
    }
}
