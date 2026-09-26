import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * AppointmentController for Dunbar Veterinary Clinic Appointment System
 * Receive requests and call appointment service
 */
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // 创建院内门诊预约
    public Appointment createClinicAppointment(String appointmentId, LocalDateTime startTime, Animal animal) {
        return appointmentService.createClinicAppointment(appointmentId, startTime, animal);
    }

    // 创建农场出诊预约
    public Appointment createFarmAppointment(String appointmentId, LocalDateTime startTime, int durationMinutes, Property property) {
        return appointmentService.createFarmAppointment(appointmentId, startTime, durationMinutes, property);
    }

    // 取消预约
    public boolean cancelAppointment(String appointmentId) {
        return appointmentService.cancelAppointment(appointmentId);
    }

    // 获取单日预约列表
    public List<Appointment> getDailyAppointments(LocalDate date) {
        return appointmentService.getDailyAppointments(date);
    }

    // 获取全部预约
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }
}
