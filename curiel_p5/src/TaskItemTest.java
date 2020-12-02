import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        assertThrows(InvalidDueDateException.class, () -> new TaskItem("Task", "Description", "000-1-10"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("", "Description", "2020-12-15"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() -> new TaskItem("Task", "Description", "2020-12-15"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() -> new TaskItem("Task", "Description", "2020-12-15"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task", "Description", "2020-12-15");

        list.add(task);

        assertThrows(InvalidDueDateException.class, () -> list.tasks.set(0, new TaskItem("Task", "Description", "000-1-10")));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task", "Description", "2020-10-22");

        list.add(task);

        assertDoesNotThrow(() -> list.tasks.set(0, new TaskItem("Task", "Description", "2020-12-15")));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task", "Description", "2020-05-25");

        list.add(task);

        assertThrows(InvalidTitleException.class, () -> list.tasks.set(0, new TaskItem("", "Description", "2020-12-15")));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Task", "Description", "2020-10-22");

        list.add(task);

        assertDoesNotThrow(() -> list.tasks.set(0, new TaskItem("Task", "Description", "2020-12-15")));

    }

}