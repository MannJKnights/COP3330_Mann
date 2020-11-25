import java.io.Serializable;

public class ContactItem implements Serializable
{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    // Constructor to set the 4 components
    public ContactItem(String firstName, String lastName, String phone, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    // First Name getter
    public String getFirstName()
    {
        return this.firstName;
    }

    // First Name setter
    public void setFirstName(String newFName)
    {
        this.firstName = newFName;
    }

    // Last Name getter
    public String getLastName()
    {
        return this.lastName;
    }

    // Last Name setter
    public void setLastName(String newLName)
    {
        this.lastName = newLName;
    }

    // Phone getter
    public String getPhone()
    {
        // Checks if phone is correct format if it isn't empty
        if(!formatCheckPhone(phone) && !phone.isEmpty())
        {
            System.out.println("WARNING - Phone Number May be Invalid!");
            return null;
        }
        else
        {
            return this.phone;
        }
    }

    // Phone setter
    public void setPhone(String newPhone)
    {
        // Checks if phone is in correct format if it isn't empty
        if(!formatCheckPhone(newPhone) && !newPhone.isEmpty())
        {
            System.out.println("WARNING - Phone Number May be Invalid!");
        }
        else
        {
            this.phone = newPhone;
        }
    }

    // Email getter
    public String getEmail()
    {
        // Checks if email is in correct format if it isn't empty
        if(!formatCheckEmail(email) && !email.isEmpty())
        {
            System.out.println("WARNING - Email Address May be Invalid!");
            return null;
        }
        else
        {
            return this.email;
        }
    }

    // Email setter
    public void setEmail(String newEmail)
    {
        // Checks if email is in correct format if it isn't empty
        if(!formatCheckEmail(newEmail) && !newEmail.isEmpty())
        {
            System.out.println("WARNING - Email Address May be Invalid!");
        }
        else
        {
            this.email = newEmail;
        }
    }

    // Format checker for phone
    public boolean formatCheckPhone(String test)
    {
        if(test.matches("\\d{3}-\\d{3}-\\d{4}"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Format checker for email
    public boolean formatCheckEmail(String test)
    {
        if(test.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Checks if all compents are empty
    public boolean emptyChecker()
    {
        if(!firstName.isEmpty() || !lastName.isEmpty() || !phone.isEmpty() || !email.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // A toString method to put the final object together
    @Override
    public String toString()
    {
        return "Name: " + firstName + " " + lastName + "\n" + "Phone: " + phone + "\n" + "Email: " + email;
    }
}