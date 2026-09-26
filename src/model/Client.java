import java.util.ArrayList;
import java.util.List;

/**
 * Client model for Dunbar Veterinary Clinic Appointment System
 */
public class Client {
    private String clientId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean isActive;
    private List<Animal> animals;
    private List<Property> properties;

    // Constructor
    public Client(String clientId, String fullName, String phoneNumber, String email, String address) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isActive = true;
        this.animals = new ArrayList<>();
        this.properties = new ArrayList<>();
    }

    // Getters
    public String getClientId() {
        return clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Property> getProperties() {
        return properties;
    }

    // Add animal to client
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Add property to client
    public void addProperty(Property property) {
        properties.add(property);
    }

    // Deactivate client (out of scope for A2, keep method placeholder)
    public void deactivateClient() {
        this.isActive = false;
    }
}
