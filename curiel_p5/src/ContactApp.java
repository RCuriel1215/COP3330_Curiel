import java.util.Scanner;

public class ContactApp
{

    private static ContactList contacts;

    public static void printOperationMenu()
    {
        Scanner scan = new Scanner(System.in);

        int userOption = 0;
        int editOption = 0;
        int removeOption = 0;

        while (userOption != 6)
        {
            System.out.println("List Operation Menu\n" +
                    "------------------\n" +
                    "1) View the list\n" +
                    "2) Add an item\n" +
                    "3) Edit an item\n" +
                    "4) Remove an item\n" +
                    "5) Save the current list\n" +
                    "6) Quit to main menu\n");

            userOption = scan.nextInt();
            switch (userOption)
            {
                case 1:
                    contacts.display();
                    break;
                case 2:
                    add(newContact());
                    break;
                case 3:
                    contacts.display();
                    System.out.println("Which one to edit? ");
                    editOption = scan.nextInt();
                    contacts.edit(editOption, newContact());
                    System.out.println("Contact updated.\n");
                    break;
                case 4:
                    contacts.display();
                    System.out.println("Which one to remove? ");
                    removeOption = scan.nextInt();
                    contacts.remove(removeOption);
                    System.out.println("Task deleted.\n");
                    break;
                case 5:
                    System.out.println("Enter filename to save into: ");
                    String filename = scan.nextLine();
                    contacts.write(filename);
                    break;
                case 6:
                    break;

            }
        }

    }


    private static void add(ContactItem contact)
    {
        contacts.add(contact);
    }

    private static ContactItem newContact()
    {
        Scanner scan = new Scanner(System.in);
        boolean x = true;
        ContactItem contact = null;

        while(x = true)
        {

            try
            {
                String firstName;
                String lastName;
                String phoneNum;
                String emailAddr;

                System.out.print("Enter contact first name: ");
                firstName = scan.nextLine();

                System.out.print("Enter contact last name: ");
                lastName = scan.nextLine();

                System.out.print("Enter contact phone number (xxx-xxx-xxxx): ");
                phoneNum = scan.nextLine();

                System.out.print("Enter contact email address: ");
                emailAddr = scan.nextLine();

                contact = new ContactItem(firstName, lastName, phoneNum, emailAddr);

                break;

            }
            catch(InvalidFirstNameException ex)
            {
                System.out.println("Invalid first name");
            }
            catch(InvalidLastNameException ex)
            {
                System.out.println("Invalid last name");
            }
            catch (InvalidEmailException ex)
            {
                System.out.println("Invalid description");
            }
            catch (InvalidPhoneNumberException ex)
            {
                System.out.println("Invalid due date.");
            }
        }

        return contact;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int userOption = 0;
        contacts = new ContactList();
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
                    contacts = new ContactList();
                    printOperationMenu();
                    break;
                case 2:
                    System.out.println("Which file to load? ");
                    fileName = scan.nextLine();
                    contacts = new ContactList();
                    contacts.load(fileName);
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
