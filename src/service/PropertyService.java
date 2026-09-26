import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * PropertyService for Dunbar Veterinary Clinic Appointment System
 * Handle create and query property records, bind property to client
 */
public class PropertyService {
    private List<Property> propertyList;

    public PropertyService() {
        propertyList = new ArrayList<>();
    }

    // 创建地产并绑定客户
    public Property createProperty(String propertyId, String locationName, String address, String visitNote, Client owner) {
        Property newProperty = new Property(propertyId, locationName, address, visitNote, owner);
        propertyList.add(newProperty);
        owner.addProperty(newProperty);
        return newProperty;
    }

    // 根据ID查询地产
    public Optional<Property> findPropertyById(String propertyId) {
        return propertyList.stream()
                .filter(property -> property.getPropertyId().equals(propertyId))
                .findFirst();
    }

    // 获取某个客户名下所有地产
    public List<Property> getPropertiesByClient(Client client) {
        return client.getProperties();
    }

    // 查询全部地产
    public List<Property> getAllProperties() {
        return new ArrayList<>(propertyList);
    }
}
