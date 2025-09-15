public class Coach extends Person {

    private CoachRole role;

    public Coach(String name, int age, CoachRole role) {
        super(name, age);
        this.role = role;
    }

    public CoachRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return("Name: " + getName() + ", Age: " + getAge() + ", Role: " + role);
    }

}
