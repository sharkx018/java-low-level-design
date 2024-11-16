package Problems.stackoverflow;

import java.util.Arrays;
import java.util.List;

public class StackOverFlowDemo {
    public static void main(String[] args) {
        StackOverFlow stackOverFlow = StackOverFlow.getInstance();

        // register user
        User alice = stackOverFlow.registerUser("Alice", "alice@exampl.com");
        User bob = stackOverFlow.registerUser("Bob", "bob@exampl.com");
        User charlie = stackOverFlow.registerUser("Charlie", "charlie@exampl.com");

        // alice ask the question
        Question aliceJavaQuestion = stackOverFlow.askQuestion(alice,
                "What is polymorphism in Java",
                "Can someone explain me polymorphism in java with expample",
                Arrays.asList("java", "oop"));

        // bob answer the question
        Answer bobJavaAnswer =stackOverFlow.answerQuestion(bob, aliceJavaQuestion, "Polymorphism in Java is the ability of an object to take on many forms...");

        // charlie add comments in alice question
        stackOverFlow.addComment(charlie, aliceJavaQuestion, "Great question! I'm also interested in learning about this.");

        // alice comments on bob's answer
        stackOverFlow.addComment(alice, bobJavaAnswer, "Thanks for the explanation! Could you provide a code example?");

        // charlie votes on question and answer
        stackOverFlow.voteQuestion(charlie, aliceJavaQuestion, 1);
        stackOverFlow.voteAnswer(charlie, bobJavaAnswer, 1);

        stackOverFlow.acceptAnswer(bobJavaAnswer);

        // bob asks question
        Question bobPythonQuestion = stackOverFlow.askQuestion(bob,
                "How to use list comprehensions in Python?",
                "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?",
                Arrays.asList("python", "list-comprehension"));


        // alice answers the question
        Answer alicePythonAnswer = stackOverFlow.answerQuestion(alice, bobPythonQuestion, "List comprehensions in Python provide a concise way to create lists...");

        // charlie upvotes the answer and question
        stackOverFlow.voteQuestion(charlie, bobPythonQuestion, 1);
        stackOverFlow.voteAnswer(charlie, alicePythonAnswer, 1);

        // print the current state
        System.out.println("Question: " + aliceJavaQuestion.getTitle());
        System.out.println("Asked by: " + aliceJavaQuestion.getAuthor().getUsername());
        System.out.println("Tags: " + aliceJavaQuestion.getTags().stream().map(Tag::getName).reduce((a, b)-> a + ", "+b).orElse(""));
        System.out.println("Votes: "+ aliceJavaQuestion.getVoteCount());
        System.out.println("Comments: "+ aliceJavaQuestion.getComments().size());
        System.out.println("Answered By: "+ bobJavaAnswer.getAuthor().getUsername()+":");
        System.out.println(bobJavaAnswer.getContent());
        System.out.println("Votes: " + bobJavaAnswer.getVoteCount());
        System.out.println("Accepted: " + bobJavaAnswer.isAccepted());
        System.out.println("Comments: " + bobJavaAnswer.getComments().size());

        System.out.println();
        System.out.println();

        System.out.println("Users reputations:");
        System.out.println("Alice: "+ alice.getReputation());
        System.out.println("Bob: "+ bob.getReputation());
        System.out.println("Charlie: "+ charlie.getReputation());


        // demonstrate search functionality
        System.out.println("Search Result for java:");
        List<Question> searchResults =  stackOverFlow.searchQuestion("java");
        for(Question question: searchResults){
            System.out.println(question.getTitle());
        }

        System.out.println("Search result for python:");
        searchResults = stackOverFlow.searchQuestion("python");
        for(Question question: searchResults){
            System.out.println(question.getTitle());
        }


        System.out.println("Bob Questions:");
        List<Question> bobQuestions = stackOverFlow.getQuestionByUser(bob);
        for(Question q: bobQuestions){
            System.out.println(q.getTitle());
        }

    }
}
