import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(InvalidFirstNameException.class, ()-> { new ContactItem("", "", "", ""); });
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new ContactItem("R","C", "000-000-0000", " "));
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new ContactItem(" ","C", "000-000-0000", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new ContactItem("R"," ", "000-000-0000", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new ContactItem("R","C", " ", "email@address.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() -> new ContactItem("R","C", "000-000-0000", "email@address.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertThrows(InvalidLastNameException.class , () -> edit.edit(0,new ContactItem(" ","", "  ", " ")));


    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0,new ContactItem("R","C", "000-000-0000", " ")));
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0,new ContactItem(" ","C", "000-000-0000", "email@address.com")));
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0,new ContactItem("R"," ", "000-000-0000", "email@address.com")));
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0,new ContactItem("R","C", " ", "email@address.com")));
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        ContactList edit = new ContactList();
        edit.add(contact);

        assertDoesNotThrow(() -> edit.edit(0,new ContactItem(" "," ", " ", " ")));
    }

    @Test
    public void testToString()
    {
        ContactItem contact = new ContactItem("R","C", "000-000-0000", "email@address.com");
        String expected = "R C 000-000-0000 email@address.com";
        assertEquals(expected, contact.toString());
    }
}