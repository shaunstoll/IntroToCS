public class ComparablePerson implements Comparable<ComparablePerson> {
    
    private String firstName;
    private String lastName;
    
    public ComparablePerson(String last, String first) {
        lastName = last;
        firstName = first;
    }
    
    public int compareTo(ComparablePerson other) {
        int lastNameComp = lastName.compareTo(other.lastName);
        if (lastNameComp == 0) {return firstName.compareTo(other.firstName);}
        else {return lastNameComp;}
    }
    
    public static void main(String[] args) {
        ComparablePerson comp = new ComparablePerson("A", "Bob");
        ComparablePerson other = new ComparablePerson("A", "Cichael");
        System.out.println(comp.compareTo(other));
    }
}