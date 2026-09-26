/**
 * Property model for Dunbar Veterinary Clinic Appointment System
 */
public class Property {
    private String propertyId;
    private String locationName;
    private String address;
    private String visitNote;
    private Client owner;

    // Constructor
    public Property(String propertyId, String locationName, String address, String visitNote, Client owner) {
        this.propertyId = propertyId;
        this.locationName = locationName;
        this.address = address;
        this.visitNote = visitNote;
        this.owner = owner;
    }

    // Getters
    public String getPropertyId() {
        return propertyId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }

    public String getVisitNote() {
        return visitNote;
    }

    public Client getOwner() {
        return owner;
    }

    // Update visit note
    public void setVisitNote(String visitNote) {
        this.visitNote = visitNote;
    }
}
