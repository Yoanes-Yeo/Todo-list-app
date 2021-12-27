package android.example.todo;

public class Todo {
    private String task;
    private boolean completed;

    public Todo(String task){
        this.task = task;
        this.completed = false;
    }

    public void checkCompleted(){
        this.completed = !this.completed;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }
}
