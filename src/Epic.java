import java.util.ArrayList;

public class Epic extends Task {

    public Epic(String nameTask, String description) {
        this.nameTask = nameTask;
        this.description = description;
        this.id = counter;
        counter++;

    }

}
