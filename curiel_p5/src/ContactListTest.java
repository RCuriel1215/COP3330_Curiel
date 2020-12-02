import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList contact = new ContactList();
        int sizeBefore = contact.contacts.size();

        contact.add(new ContactItem("R", "C", "000-000-0000", "email@address.com"));
        int sizeAfter = contact.contacts.size();

        assertTrue(sizeAfter > sizeBefore);

    }
    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertThrows(InvalidFirstNameException.class , () -> edit.edit(0,new ContactItem("","", "", "")));
    }
    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertThrows(IndexOutOfBoundsException.class , () -> edit.edit(-1, new ContactItem("R","C", "000-000-0000", "email@address.com")));
    }
    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0, new ContactItem(" ", "C", "000-000-0000", "email@address.com")));
    }
    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0, new ContactItem("R", " ", "000-000-0000", "email@address.com")));
    }
    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0, new ContactItem("R", "C", " ", "email@address.com")));
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0, new ContactItem("O", "M", "111-000-0000", "email@address.com")));
    }
    @Test
    public void newListIsEmpty()
    {
        ContactList contact = new ContactList();
        assertEquals(contact.contacts.size(),0);
    }
    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList contact = new ContactList();
        contact.add(new ContactItem("R","C", "000-000-0000", "email@address.com"));

        int sizeBefore = contact.contacts.size();
        contact.remove(0);
        int sizeAfter = contact.contacts.size();

        assertTrue(sizeBefore > sizeAfter);
    }
    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList contact2 = new ContactList();
        contact2.add(contact);


        assertThrows(IndexOutOfBoundsException.class , () -> contact2.remove(-1));


    }
    @Test
    public void savedContactListCanBeLoaded()
    {
        assertDoesNotThrow( ()-> {
                    ContactList contacts = new ContactList();
                    contacts.add(new ContactItem("R","C", "000-000-0000", "email@address.com"));
                    contacts.load("test.txt"); });

    }
}