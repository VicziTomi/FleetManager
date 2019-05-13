package hu.flowacademy.carsharing.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "plate_number")
    private String plateNumber;

    @Column
    private String brand;

    @Column
    private String type;

    @Column(name = "prod_year")
    private int prodYear;

    @Column(name = "exp_date")
    private LocalDate expDate;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservation;


    public Car() {
    }

    public Car(String plateNumber, String brand, String type, int prodYear, LocalDate expDate) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.type = type;
        this.prodYear = prodYear;
        this.expDate = expDate;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
}
