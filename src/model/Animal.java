/**
 * Animal model for Dunbar Veterinary Clinic Appointment System
 */
public class Animal {
    private String animalId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private Client owner;

    // Constructor
    public Animal(String animalId, String name, String species, String breed, int age, Client owner) {
        this.animalId = animalId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
    }

    // Getters
    public String getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public Client getOwner() {
        return owner;
    }
}
