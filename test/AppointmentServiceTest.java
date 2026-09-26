import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for AppointmentService, Dunbar Veterinary Clinic System
 */
public class AppointmentServiceTest {

    @Test
    void testCreateClinicAppointment() {
        Client testClient = new Client("C001", "Tom Smith", "0411111111", "tom@test.com", "123 Street");
        Animal testAnimal = new Animal("A001", "Max", "Dog", "Labrador", 5, testClient);
        AppointmentService service = new AppointmentService();
        LocalDateTime time = LocalDateTime.of(2026,9,20,10,0);

        Appointment apt = service.createClinicAppointment("APT001", time, testAnimal);

        assertNotNull(apt);
        assertEquals(Appointment.AppointmentType.CLINIC_VISIT, apt.getType());
        assertEquals(15, apt.getDurationMinutes());
        assertFalse(apt.isCancelled());
    }

    @Test
    void testCreateFarmAppointment() {
        Client testClient = new Client("C002", "Bob Farm", "0422222222", "bob@farm.com", "Farm Road");
        Property testProperty = new Property("P001", "Hill Farm", "Hill Road", "Bring cattle medicine", testClient);
        AppointmentService service = new AppointmentService();
        LocalDateTime time = LocalDateTime.of(2026,9,20,14,0);

        Appointment apt = service.createFarmAppointment("APT002", time, 60, testProperty);

        assertNotNull(apt);
        assertEquals(Appointment.AppointmentType.FARM_CALL, apt.getType());
        assertEquals(60, apt.getDurationMinutes());
    }

    @Test
    void testCancelAppointment() {
        Client testClient = new Client("C001", "Tom Smith", "0411111111", "tom@test.com", "123 Street");
        Animal testAnimal = new Animal("A001", "Max", "Dog", "Labrador", 5, testClient);
        AppointmentService service = new AppointmentService();
        LocalDateTime time = LocalDateTime.of(2026,9,20,10,0);
        Appointment apt = service.createClinicAppointment("APT001", time, testAnimal);

        boolean cancelResult = service.cancelAppointment("APT001");

        assertTrue(cancelResult);
        assertTrue(apt.isCancelled());
    }

    @Test
    void testGetDailyAppointments() {
        Client testClient = new Client("C001", "Tom Smith", "0411111111", "tom@test.com", "123 Street");
        Animal testAnimal = new Animal("A001", "Max", "Dog", "Labrador", 5, testClient);
        AppointmentService service = new AppointmentService();
        LocalDateTime time1 = LocalDateTime.of(2026,9,20,10,0);
        LocalDateTime time2 = LocalDateTime.of(2026,9,21,10,0);
        service.createClinicAppointment("APT001", time1, testAnimal);
        service.createClinicAppointment("APT002", time2, testAnimal);

        var list = service.getDailyAppointments(LocalDate.of(2026,9,20));

        assertEquals(1, list.size());
        assertEquals("APT001", list.get(0).getAppointmentId());
    }
}
