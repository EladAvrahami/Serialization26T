package Targil1;

import java.io.Serializable;
import java.util.UUID;

public class Person implements Serializable {
    private static final long serialVersionUID = System.currentTimeMillis();
    private String userID;
    private String name;
    private String add;
    private String phoneNumber;
    private String memo;

    public Person(String name, String add, String phoneNumber, String memo) {
        this.userID = UUID.randomUUID().toString();/*יצירת id רנדומלי */
        this.name = name;
        this.add = add;
        this.phoneNumber = phoneNumber;
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", add='" + add + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }

    public String getUserID() {
        return userID;
    }
}
