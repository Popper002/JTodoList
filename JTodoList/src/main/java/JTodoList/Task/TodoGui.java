package JTodoList.Task;

import JTodoList.Todo.Todo;
import javafx.beans.property.*;

import java.time.LocalDate;

public class TodoGui extends Todo {
    private final StringProperty shortDescription;
    private final StringProperty details;
    private final ObjectProperty<LocalDate> deadline;
    private final BooleanProperty complete;

    public TodoGui(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = new SimpleStringProperty(shortDescription);
        this.details = new SimpleStringProperty(details);
        this.deadline = new SimpleObjectProperty(deadline);
        this.complete = new SimpleBooleanProperty(false);
    }
}
