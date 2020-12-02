public class ContactItem
{
    protected String firstName;
    protected String lastName;
    protected String phoneNum;
    protected String emailAddr;

    private boolean isFirstNameValid(String firstName)
    {
        return firstName.length() != 0;
    }

    private boolean isLastNameValid(String lastName)
    {
        return lastName.length() != 0;
    }

    private boolean isPhoneNumValid(String phoneNum)
    {
        return phoneNum.length() != 0;
    }

    private boolean isEmailValid(String emailAddr)
    {
        return emailAddr.length() != 0;

    }

    private boolean isContactValid(String firstName, String lastName, String phoneNumber, String emailAddress)
    {
        boolean valid;
        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && emailAddress.isBlank())
        {
            valid = false;
        }
        else
        {
            valid = true;
        }

        return valid;


    }
    public ContactItem(String firstName, String lastName, String phoneNum, String emailAddr)
    {


        if(isFirstNameValid(firstName))
        {
            this.firstName = firstName;
            getFirstName();

        }
        else
        {
            throw new InvalidFirstNameException("First name not valid.");
        }

        if(isLastNameValid(lastName))
        {
            this.lastName = lastName;
            getLastName();

        }
        else
        {
            throw new InvalidLastNameException("Last name not valid.");
        }

        if(isPhoneNumValid(phoneNum))
        {
            this.phoneNum = phoneNum;
            getPhoneNum();
        }
        else
        {
            throw new InvalidPhoneNumberException("Phone number is not valid.");
        }

        if(isEmailValid(emailAddr))
        {
            this.emailAddr = emailAddr;
            getEmailAddr();
        }
        else
        {
            throw new InvalidEmailException("Email is not valid.");
        }


    }


    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getPhoneNum()
    {
        return this.phoneNum;
    }

    public String getEmailAddr()
    {
        return this.emailAddr;
    }


}
class InvalidFirstNameException extends IllegalArgumentException
{
    public InvalidFirstNameException(String msg)
    {

        super(msg);
    }
}

class InvalidLastNameException extends IllegalArgumentException
{
    public InvalidLastNameException(String msg)
    {

        super(msg);
    }
}


class InvalidPhoneNumberException extends IllegalArgumentException
{
    public InvalidPhoneNumberException(String msg)
    {

        super(msg);
    }
}

class InvalidEmailException extends IllegalArgumentException
{
    public InvalidEmailException(String msg)
    {

        super(msg);
    }
}
class InvalidContactException extends IllegalArgumentException
{
    public InvalidContactException(String msg)
    {

        super(msg);
    }
}