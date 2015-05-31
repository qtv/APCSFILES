/**
 * @title 18.03 Challenge Program - uses arrays & sorts & searches thru them
 * @author 
 * @date 5/25/15
 */
public class Contact {
    private String name, relation, bday, phone, email;
    
    public Contact (String name, String relation, String bday, String phone, String email) {
        this.name = name;
        this.relation = relation;
        this.bday = bday;
        this.phone = phone;
        this.email = email;
    }
    public String getName()
    {
        return name;
    }
    public String getRelation()
    {
        return relation;
    }
    public String getBDay()
    {
        return bday;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPhone()
    {
        return phone;
    }
   
    public String toString()
    {
        String a = getName() + "  " + getRelation() + "     " + getBDay() + "       " + getPhone() + " " + getEmail();
        return a;
    }
}