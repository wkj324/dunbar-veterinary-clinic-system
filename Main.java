import java.time.LocalDateTime;

/**
 * Main entry for Dunbar Veterinary Clinic Appointment System
 * Simple demo to test core workflow
 */
public class Main {
    public static void main(String[] args) {
        // Initialize services
        ClientService clientService = new ClientService();
        AnimalService animalService = new AnimalService();
        PropertyService propertyService = new PropertyService();
        AppointmentService appointmentService = new AppointmentService();
        AppointmentController appointmentController = new AppointmentController(appointmentService);

        // 1. Create a client
        Client client1 = clientService.createClient("C001", "Tom Smith", "0411111111", "tom@example.com", "123 Main Street");
        System.out.println("Created Client: " + client1.getFullName());

        // 2. Create animal for client
        Animal dog = animalService.createAnimal("A001", "Max", "Dog", "Labrador", 5, client1);
        System.out.println("Created Animal: " + dog.getName());

        // 3. Create farm property for client
        Property farm = propertyService.createProperty("P001", "Hill Farm", "Rural Lane 45", "Remember to bring cattle vaccine", client1);
        System.out.println("Created Property: " + farm.getLocationName());

        // 4. Create clinic appointment (15min fixed)
        LocalDateTime clinicTime = LocalDateTime.of(2026, 9, 20, 10, 0);
        Appointment clinicApt = appointmentController.createClinicAppointment("APT001", clinicTime, dog);
        System.out.println("Created Clinic Appointment ID: " + clinicApt.getAppointmentId());

        // 5. Create farm call appointment (custom 60 min)
        LocalDateTime farmTime = LocalDateTime.of(2026, 9, 20, 14, 0);
        Appointment farmApt = appointmentController.createFarmAppointment("APT002", farmTime, 60, farm);
        System.out.println("Created Farm Appointment ID: " + farmApt.getAppointmentId());

        // 6. Cancel clinic appointment
        boolean cancelSuccess = appointmentController.cancelAppointment("APT001");
        System.out.println("Cancel APT001 result: " + cancelSuccess);

        // 7. Print all appointments on 2026-09-20
        System.out.println("\n=== Daily Appointment List ===");
        var dailyList = appointmentController.getDailyAppointments(clinicTime.toLocalDate());
        for(Appointment apt : dailyList){
            String cancelledTag = apt.isCancelled() ? " [CANCELLED]" : "";
            System.out.printf("ID:%s | Type:%s | Time:%s%s%n",
                    apt.getAppointmentId(), apt.getType(), apt.getStartTime(), cancelledTag);
        }
    }
}
