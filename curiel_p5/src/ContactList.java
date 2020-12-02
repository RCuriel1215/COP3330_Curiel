import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Formatter;

public class ContactList
{
    public final ArrayList<ContactItem> contacts;

    public ContactList()
    {
        contacts = new ArrayList<>();
    }

    public void add(ContactItem contact)
    {
        contacts.add(contact);
    }

    public void edit(int index, ContactItem contact)
    {
        contacts.set(index, contact);
    }

    public void remove(int index)
    {
        contacts.remove(index);
    }

    public void display()
    {
        System.out.println("Current Contacts\n"+
                "-------------\n");

        if(contacts.size() == 0)
        {
            System.out.println("No contacts available.");
        }
        for(int i = 0; i < contacts.size(); i++)
        {
            ContactItem thisContact = contacts.get(i);

                System.out.println(i + ") Name: " + thisContact.getFirstName() + " " + thisContact.getLastName()
                        + " \nPhone Number: " + thisContact.getPhoneNum()
                        + "\nEmail Address: " + thisContact.getEmailAddr());

        }

    }


    public void write(String filename)
    {
        try(Formatter output = new Formatter(filename))
        {
            output.format("contactlist%n");

            for(int i = 0; i < contacts.size(); i++)
            {
                ContactItem contact = contacts.get(i);
                output.format("%s;%s;%s;%s%n", contact.getFirstName(), contact.getLastName(), contact.getPhoneNum(), contact.getEmailAddr());
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
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine())
            {
                String[] contactArray = scan.nextLine().split(";");

                if(contactArray.length == 1)
                {
                    ContactItem contact = new ContactItem(contactArray[0], "", "", "");
                    contacts.add(contact);
                }

                if(contactArray.length == 2)
                {
                    ContactItem contact = new ContactItem(contactArray[0], contactArray[1], "", "");
                    contacts.add(contact);
                }

                if(contactArray.length == 3)
                {
                    ContactItem contact = new ContactItem(contactArray[0], contactArray[1], contactArray[2], "");
                    contacts.add(contact);
                }

                if(contactArray.length == 4)
                {
                    ContactItem contact = new ContactItem(contactArray[0], contactArray[1], contactArray[2], contactArray[3]);
                    contacts.add(contact);
                }


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
