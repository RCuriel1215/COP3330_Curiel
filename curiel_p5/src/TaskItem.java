public class TaskItem
{
    protected String title;
    protected String desc;
    protected String dueDate;
    protected boolean complete;


    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    private boolean isDescValid(String desc) {
        return desc.length() >= 0;
    }

    private boolean isDueDateValid(String dueDate)
    {
        String[] dueDateArray = dueDate.split("-");
        int month;
        int day;

        if(dueDateArray.length != 3) {
            return false;
        }

        if(dueDateArray[0].length()!= 4 || dueDateArray[1].length()!=2 || dueDateArray[2].length()!=2)
        {
            return false;
        }

        month = Integer.parseInt(dueDateArray[1]);
        day = Integer.parseInt(dueDateArray[2]);

        if(month > 12)
        {
            return false;
        }

        if(day > 31)
        {
            return false;
        }

        return true;
    }
    public TaskItem(String title, String desc, String dueDate)
    {
        if(isTitleValid(title))
        {
            this.title = title;
            getTitle();
        }
        else
        {
            throw new InvalidTitleException("Name is not valid.");
        }

        if(isDescValid(desc))
        {
            this.desc = desc;
            getDesc();
        }
        else
        {
            throw new InvalidDescException("Description is not valid.");
        }

        if(isDueDateValid(dueDate))
        {
            this.dueDate = dueDate;
            getDueDate();
        }
        else
        {
            throw new InvalidDueDateException("Due date is not valid.");
        }

        this.complete = false;

    }


    public String getTitle()
    {
        return this.title;
    }

    public String getDesc()
    {
        return this.desc;
    }

    public String getDueDate()
    {
        return this.dueDate;
    }

    public boolean getCompleted()
    {
        return this.complete;
    }

    public void setTitle()
    {
        this.title = title;
    }

    public void setDesc()
    {
        this.desc = desc;
    }

    public void setDueDate()
    {
        this.dueDate = dueDate;
    }

    public void setCompletion(boolean status)
    {
        this.complete = status;
    }


}
class InvalidTitleException extends IllegalArgumentException
{
    public InvalidTitleException(String msg)
    {
        super(msg);
    }
}

class InvalidDescException extends IllegalArgumentException
{
    public InvalidDescException(String msg)
    {
        super(msg);
    }
}

class InvalidDueDateException extends IllegalArgumentException
{
    public InvalidDueDateException(String msg)
    {
        super(msg);
    }
}
