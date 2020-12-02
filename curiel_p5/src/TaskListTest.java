import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize()
    {
        TaskList list = new TaskList();
        int initialSize = list.tasks.size();
        list.add(new TaskItem("Task", "Description","2020-12-15"));

        assertNotEquals(list.tasks.size(),initialSize);
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");

        boolean initialStatus = item.getCompleted();
        item.setCompletion(true);
        assertNotEquals(item.getCompleted(),initialStatus);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList task = new TaskList();
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");
        task.add(item);

        assertThrows(IndexOutOfBoundsException.class , () -> task.setStatus(-1, true));
    }

    @Test
    public void editingTaskItemChangesValues()
    {
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");
        TaskList task = new TaskList();

        task.add(item);

        TaskItem newItem = new TaskItem("Task 2", "Description 2","2020-10-22");
        task.edit(0, newItem);

        assertNotEquals(item.getTitle(), task.tasks.get(0).getTitle());
        assertNotEquals(item.getDesc(), task.tasks.get(0).getDesc());
        assertNotEquals(item.getDueDate(), task.tasks.get(0).getDueDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");
        TaskList task = new TaskList();

        task.add(item);

        TaskItem newTask = new TaskItem("Task", "Description 2","2020-12-15");
        task.edit(0, newTask);

        assertNotEquals(item.getDesc(), task.tasks.get(0).getDesc());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskItem originalTask = new TaskItem("Task", "Description","2020-12-15");

        TaskList TL = new TaskList();
        TL.add(originalTask);

        TaskItem newTask = new TaskItem("Task", "Description","2020-12-15");

        assertThrows(IndexOutOfBoundsException.class , () -> TL.edit(1, newTask));
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);
        TaskItem newTask = new TaskItem("Task", "Description","2020-10-22");
        list.edit(0, newTask);

        assertNotEquals(task.getDueDate(), list.tasks.get(0).getDueDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);

        TaskItem newTask = new TaskItem("Task", "Description","2020-10-22");

        assertThrows(IndexOutOfBoundsException.class , () -> list.edit(-1, newTask));
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);

        TaskItem newTask = new TaskItem("Task 2", "Description","2020-12-15");
        list.edit(0, newTask);

        assertNotEquals(task.getTitle(), list.tasks.get(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);
        TaskItem newTask = new TaskItem("Task 2", "Description","2020-12-15");

        assertThrows(IndexOutOfBoundsException.class , () -> list.edit(-1, newTask));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class , () -> list.tasks.get(-1).getDesc());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();

        list.add(task);

        assertDoesNotThrow(() -> list.tasks.get(0).getDesc());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class , () -> list.tasks.get(-1).getDueDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();

        list.add(task);

        assertDoesNotThrow(() -> list.tasks.get(0).getDueDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class , () -> list.tasks.get(-1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        TaskItem task = new TaskItem("Task", "Description","2020-12-15");

        TaskList list = new TaskList();
        list.add(task);

        assertDoesNotThrow(() -> list.tasks.get(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty()
    {
        TaskList list = new TaskList();
        assertEquals(list.tasks.size(), 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {
        TaskList list = new TaskList();
        list.add(new TaskItem("Task", "Description","2020-12-15"));

        int initialList = list.tasks.size();

        list.remove(0);
        assertNotEquals(list.tasks.size(),initialList);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        TaskList list = new TaskList();
        list.add(new TaskItem("Task", "Description","2020-12-15"));

        assertThrows(IndexOutOfBoundsException.class , () ->  list.remove(-1));
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList task = new TaskList();
        TaskItem savedItem = new TaskItem("Task", "Description","2020-12-15");

        task.add(savedItem);

        String filename = "filename";
        task.write(filename);

        TaskList task2 = new TaskList();
        task2.load(filename);

        assertEquals(task2.tasks.get(0).getTitle(), task.tasks.get(0).getTitle());
        assertEquals(task2.tasks.get(0).getDesc(), task.tasks.get(0).getDesc());
        assertEquals(task2.tasks.get(0).getDueDate(), task.tasks.get(0).getDueDate());
        assertEquals(task2.tasks.get(0).getCompleted(), task.tasks.get(0).getCompleted());
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");
        boolean initialStatus = item.getCompleted();
        item.setCompletion(false);

        assertEquals(item.getCompleted(),initialStatus);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList task = new TaskList();
        TaskItem item = new TaskItem("Task", "Description","2020-12-15");

        task.add(item);


        assertThrows(IndexOutOfBoundsException.class , () -> task.tasks.get(-1).setCompletion(false));
    }
}
