import java.time.LocalDateTime;

/**
 * Appointment model for Dunbar Veterinary Clinic Appointment System
 */
public class Appointment {
    public enum AppointmentType {
        CLINIC_VISIT,  //院内门诊，15分钟固定时长
        FARM_CALL      //农场出诊，自定义时长
    }

    private String appointmentId;
    private LocalDateTime startTime;
    private int durationMinutes;
    private AppointmentType type;
    private Animal animal;     // 门诊预约绑定动物
    private Property property; // 农场出诊绑定地产
    private boolean isCancelled;

    // 院内门诊预约构造方法（固定15min）
    public Appointment(String appointmentId, LocalDateTime startTime, Animal animal) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.durationMinutes = 15;
        this.type = AppointmentType.CLINIC_VISIT;
        this.animal = animal;
        this.property = null;
        this.isCancelled = false;
    }

    // 农场出诊预约构造方法（自定义时长）
    public Appointment(String appointmentId, LocalDateTime startTime, int durationMinutes, Property property) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.type = AppointmentType.FARM_CALL;
        this.property = property;
        this.animal = null;
        this.isCancelled = false;
    }

    // 取消预约
    public void cancelAppointment() {
        this.isCancelled = true;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public AppointmentType getType() {
        return type;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Property getProperty() {
        return property;
    }

    public boolean isCancelled() {
        return isCancelled;
    }
}
