package hw.homework6_String_operations.task4;

public class SocialProfile {
    String name, lastName, mail, country;

    public SocialProfile(String name,String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public SocialProfile(String name,String lastName, String mail) {
        this(name, lastName);
        this.mail = mail;
    }

    public SocialProfile(String name,String lastName, String mail, String country){
        this(name, lastName, mail);
        this.country = country;
    }

    @Override
    public String toString() {
        if (name != null && lastName != null && mail == null && country == null){
            return "Name: " + name + ", lastname: " + lastName;
        }else if (name != null && lastName != null && mail != null && country == null) {
            return "Name: " + name + ", lastname: " + lastName + ", mail: " + mail;
        }else
            return "Name: " + name + ", lastname: " + lastName + ", mail: " + mail + ", country: " + country;

    }
}
