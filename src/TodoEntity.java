public class TodoEntity {
    private String todo;

    private Boolean isDone;

    public TodoEntity() {
    }

    public TodoEntity(final String todo, final Boolean isDone) {
        this.todo = todo;
        this.isDone = isDone;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(final Boolean isDone) {
        this.isDone = isDone;
    }
}
