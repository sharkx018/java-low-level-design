package Problems.stackoverflow;

public class Tag {
    private int id;
    private String name;

    public Tag( String name){
        this.id = generateId();
        this.name = name;
    }

    private int generateId(){
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
