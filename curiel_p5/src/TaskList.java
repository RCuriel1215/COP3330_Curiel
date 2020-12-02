import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Formatter;

public class TaskList
{
    public final ArrayList<TaskItem> tasks;

    public TaskList()
    {
        tasks = new ArrayList<>();
    }

    public void add(TaskItem task)
    {
        tasks.add(task);
    }

    public void edit(int index, TaskItem task)
    {
        tasks.set(index, task);
    }

    public void remove(int index)
    {
        tasks.remove(index);
    }

    public void display()
    {
        System.out.println("Current Tasks\n"+
                "-------------\n");

        if(tasks.size() == 0)
        {
            System.out.println("No tasks available.");
        }
        for(int i = 0; i < tasks.size(); i++)
        {
            TaskItem thisTask = tasks.get(i);

            if(thisTask.getCompleted() != true)
            {
                System.out.println(i + ") [" +
                        thisTask.getDueDate() + "] " +
                        thisTask.getTitle() + ": "+
                        thisTask.getDesc());
            }
        }

    }

    public void setStatus(int index, boolean status) {
        if(index < 0 || index >= tasks.size())
        {
            throw new IndexOutOfBoundsException("Invalid entry.");
        }
        else {
            tasks.get(index).setCompletion(status);
        }
    }

    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            for(int i = 0; i < tasks.size(); i++)
            {
                TaskItem task = tasks.get(i);
                output.format("%s;%s;%s;%b%n", task.getTitle(), task.getDesc(), task.getDueDate());
            }

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("No file found.");
        }
        catch(Exception ex)
        {
            System.out.println("An unexpected error has occurred");
            ex.printStackTrace();
        }
    }

    public void load(String filename)
    {
        String title;
        String desc;
        String dueDate;

        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine())
            {
                String[] taskArray = scan.nextLine().split(";");
                title = taskArray[0];
                desc = taskArray[1];
                dueDate = taskArray[2];

                add(new TaskItem(title, desc, dueDate));
            }

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("No file found.");
        }
        catch(Exception ex)
        {
            System.out.println("An unexpected error has occurred");
            ex.printStackTrace();
        }

    }
}