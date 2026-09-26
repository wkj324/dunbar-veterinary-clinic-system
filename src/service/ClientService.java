import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ClientService for Dunbar Veterinary Clinic Appointment System
 * Handle create and query client records
 * Edit/deactivate client is out of scope for individual A2
 */
public class ClientService {
    private List<Client> clientList;

    public ClientService() {
        clientList = new ArrayList<>();
    }

    // 创建客户
    public Client createClient(String clientId, String fullName, String phoneNumber, String email, String address) {
        Client newClient = new Client(clientId, fullName, phoneNumber, email, address);
        clientList.add(newClient);
        return newClient;
    }

    // 根据ID查询客户
    public Optional<Client> findClientById(String clientId) {
        return clientList.stream()
                .filter(client -> client.getClientId().equals(clientId))
                .findFirst();
    }

    // 查询全部客户
    public List<Client> getAllClients() {
        return new ArrayList<>(clientList);
    }
}
