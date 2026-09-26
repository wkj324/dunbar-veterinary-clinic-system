import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AppointmentService for Dunbar Veterinary Clinic Appointment System
 * Handle create, cancel and query appointment functions
 */
public class AppointmentService {
    private List<Appointment> appointmentList;

    public AppointmentService() {
        appointmentList = new ArrayList<>();
    }

    // 创建院内门诊预约
    public Appointment createClinicAppointment(String appointmentId, LocalDateTime startTime, Animal animal) {
        Appointment appointment = new Appointment(appointmentId, startTime, animal);
        appointmentList.add(appointment);
        return appointment;
    }

    // 创建农场出诊预约
    public Appointment createFarmAppointment(String appointmentId, LocalDateTime startTime, int durationMinutes, Property property) {
        Appointment appointment = new Appointment(appointmentId, startTime, durationMinutes, property);
        appointmentList.add(appointment);
        return appointment;
    }

    // 取消预约
    public boolean cancelAppointment(String appointmentId) {
        for(Appointment apt : appointmentList){
            if(apt.getAppointmentId().equals(appointmentId) && !apt.isCancelled()){
                apt.cancelAppointment();
                return true;
            }
        }
        return false;
    }

    // 查询当日所有预约（区分已取消）
    public List<Appointment> getDailyAppointments(LocalDate date) {
        return appointmentList.stream()
                .filter(apt -> apt.getStartTime().toLocalDate().isEqual(date))
                .collect(Collectors.toList());
    }

    // 获取全部预约
    public List<Appointment> getAllAppointments(){
        return appointmentList;
    }
}
