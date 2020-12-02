import java.util.Scanner;

public class TaskApp
{
    private static TaskList tasks;

    public static void printOperationMenu()
    {
        Scanner scan = new Scanner(System.in);
        int userOption = 0;
        int editOption = 0;
        int removeOption = 0;
        int completeOption = 0;

        while (userOption != 8)
        {
            System.out.println("List Operation Menu\n" +
                    "------------------\n" +
                    "1) View the list\n" +
                    "2) Add an item\n" +
                    "3) Edit an item\n" +
                    "4) Remove an item\n" +
                    "5) Mark item as completed\n" +
                    "6) Un-mark item as completed\n" +
                    "7) Save the current list\n" +
                    "8) Quit to main menu\n");

            userOption = scan.nextInt();
            switch (userOption)
            {
                case 1:
                    tasks.display();
                    break;
                case 2:
                    add(newTask());
                    break;
                case 3:
                    tasks.display();
                    System.out.println("Which one to edit? ");
                    editOption = scan.nextInt();
                    tasks.edit(editOption, newTask());
                    System.out.println("Task updated.\n");
                    break;
                case 4:
                    tasks.display();
                    System.out.println("Which one to remove? ");
                    removeOption = scan.nextInt();
                    tasks.remove(removeOption);
                    System.out.println("Task deleted.\n");
                    break;
                case 5:
                    tasks.display();
                    System.out.println("Which one to mark as complete? ");
                    completeOption = scan.nextInt();
                    tasks.setStatus(completeOption, true);
                    System.out.println("Item status is complete.");
                    break;
                case 6:
                    tasks.display();
                    System.out.println("Which one to mark as incomplete? ");
                    int incompleteOption = scan.nextInt();
                    tasks.setStatus(incompleteOption, false);
                    System.out.println("Item status is incomplete.");
                    break;
                case 7:
                    System.out.println("Which file to save into? ");
                    String filename = scan.nextLine();
                    tasks.write(filename);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid entry.\n");


            }
        }

    }


    private static void add(TaskItem task)
    {
        tasks.add(task);
    }
    private static TaskItem newTask()
    {
        Scanner scan = new Scanner(System.in);
        boolean x = true;
        TaskItem task = null;

        while(x = true)
        {

            try
            {
                String title;
                String desc;
                String dueDate;

                System.out.print("Enter title of task: ");
                title = scan.nextLine();

                System.out.print("Enter description of task: ");
                desc = scan.nextLine();

                System.out.print("Enter due date of task (YYYY-MM-DD): ");
                dueDate = scan.nextLine();

                task = new TaskItem(title, desc, dueDate);

                break;

            }
            catch(InvalidTitleException ex)
            {
                System.out.println("Invalid title");
            }
            catch (InvalidDescException ex)
            {
                System.out.println("Invalid description");
            }
            catch (InvalidDueDateException ex)
            {
                System.out.println("Invalid due date.");
            }
        }

        return task;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int userOption = 0;
        tasks = new TaskList();
        String fileName;


        while (userOption != 3)
        {
            System.out.println("Main Menu\n" +
                    "---------\n" +
                    "1) Create a new list\n" +
                    "2) Load existing list\n" +
                    "3) Quit\n");

            userOption = scan.nextInt();
            switch (userOption)
            {
                case 1:
                    tasks = new TaskList();
                    printOperationMenu();
                    break;
                case 2:
                    System.out.println("Which file to load? ");
                    fileName = scan.nextLine();
                    tasks = new TaskList();
                    tasks.load(fileName);
                    printOperationMenu();
                    break;
                case 3:
                    userOption = 3;
                    System.out.println("Exiting program.\n");
                    break;
                default:
                    System.out.println("Invalid entry.\n");
                    break;

            }

        }

    }

}