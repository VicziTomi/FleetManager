package hu.flowacademy.carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "login_name")
    private String loginName;

    @Column
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "licence_exp_date")
    private LocalDate licenceExpDate;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "driver")
    private List<Reservation> reservations;


    public Driver() {
    }

    public Driver(String loginName, String password, String fullName, LocalDate licenceExpDate, boolean active) {
        this.loginName = loginName;
        this.password = password;
        this.fullName = fullName;
        this.licenceExpDate = licenceExpDate;
        this.active = active;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getLicenceExpDate() {
        return licenceExpDate;
    }

    public void setLicenceExpDate(LocalDate licenceExpDate) {
        this.licenceExpDate = licenceExpDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
