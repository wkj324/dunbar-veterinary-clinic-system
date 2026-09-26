import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * AnimalService for Dunbar Veterinary Clinic Appointment System
 * Handle create and query animal records, bind animal to client
 */
public class AnimalService {
    private List<Animal> animalList;

    public AnimalService() {
        animalList = new ArrayList<>();
    }

    // 创建动物并绑定客户
    public Animal createAnimal(String animalId, String name, String species, String breed, int age, Client owner) {
        Animal newAnimal = new Animal(animalId, name, species, breed, age, owner);
        animalList.add(newAnimal);
        owner.addAnimal(newAnimal);
        return newAnimal;
    }

    // 根据ID查询动物
    public Optional<Animal> findAnimalById(String animalId) {
        return animalList.stream()
                .filter(animal -> animal.getAnimalId().equals(animalId))
                .findFirst();
    }

    // 获取某个客户名下所有动物
    public List<Animal> getAnimalsByClient(Client client) {
        return client.getAnimals();
    }

    // 查询全部动物
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animalList);
    }
}
