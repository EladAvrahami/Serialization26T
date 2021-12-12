package Targil1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();/*יצירת קולקשיין עם חמישה מופעים */
        persons.add(new Person("mazal","haifa","052-444-1212","kavkaznaya plenicha"));
        persons.add(new Person("Natan","Ramat-Gan ","052-123-456","The good the bad and natan"));
        persons.add(new Person("Ofer","kfar chulon","050-123-6543","all you need is pulse"));
        persons.add(new Person("Eyal","Hertzliya","classfied","i so rich !!!, thanks mom"));
        persons.add(new Person("Jonathan","Natanya","050-go-chapus","i am not a french !!!!"));

        //writeData(person);
        //readData(personId);
        for (Person item:persons){/*לוקח אובייקט מתוך רשימת אנשים לכתיבה    */
            writeData(item);
        }

        readData(persons.get((int)(Math.random()* persons.size())).getUserID());/*תקראה מרשימת האנשים לאחר שהגרלת מס רנדומלי בגודל המערך ואותו מס יהיה האיידי*/
    }

    private static void writeData(Person person){

        try {
            //indicates which file will be created or opened
            FileOutputStream fileOut = new FileOutputStream(person.getUserID()+".students");/*מזהה יהיה שם הקובץ*/
            //open the stream to the class for getting the data
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //write the object to the class
            out.writeObject(person);
            //close the streamer
            out.close();
            //close the file
            fileOut.close();
            //send a message when all is done :)
            System.out.println("New configuration file was created :)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Person readData(String userId){
        //create an empty object so we can insert the information inside
        Person returnResult = null;

        try {
            //indicates which file will be open/created
            FileInputStream fileIn = new FileInputStream(userId+".students");
            //use stream to read data from the file
            ObjectInputStream inData = new ObjectInputStream(fileIn);
            //read the object and casting to our class
            returnResult = (Person) inData.readObject();
            //close the stream
            inData.close();
            //close the file
            fileIn.close();
            //print the results
            System.out.println(returnResult);
            return returnResult;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
