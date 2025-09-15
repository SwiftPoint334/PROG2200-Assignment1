public class Player extends Person {

    private PlayerPosition postion;
    private int jerseyNumber;
    private double iceTime;

    public Player(String name, int age, PlayerPosition position, int jerseyNumber, double iceTime) {
        super(name, age);
        this.postion = position;
        this.jerseyNumber = jerseyNumber;
        this.iceTime = iceTime;
    }

    public PlayerPosition getPostion() {
        return postion;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public double getIceTime() {
        return iceTime;
    }

    @Override
    public String toString() {
        return("Name: " + getName() + ", Age: " + getAge() + ", Position: " + postion + ", Jersey Number: " + jerseyNumber + ", Ice Time: " + iceTime);
    }

}
