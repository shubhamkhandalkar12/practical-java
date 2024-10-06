import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

class Society implements Serializable {
    private String registrationId;
    private String name;
    private String address;

    
    public Society(String registrationId, String name, String address) {
        this.registrationId = registrationId;
        this.name = name;
        this.address = address;
    }

    
    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Registration ID: " + registrationId + ", Name: " + name + ", Address: " + address;
    }
}

public class q4 {
    public static void main(String[] args) {
    
        Society society1 = new Society("ID1", "John Doe", "123 Main St");
        Society society2 = new Society("ID2", "Jane Smith", "456 Elm St");
        Society society3 = new Society("ID3", "Bob Johnson", "789 Oak St");

        
        ArrayList<Society> societyList = new ArrayList<>();
        societyList.add(society1);
        societyList.add(society2);
        societyList.add(society3);


        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("society_data.ser"))) {
            outputStream.writeObject(societyList);
            System.out.println("Society data written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("society_data.ser"))){
            ArrayList<Society> readSocietyList = (ArrayList<Society>) inputStream.readObject();
            System.out.println("Society data read from the file:");
            Iterator<Society> iterator = readSocietyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
