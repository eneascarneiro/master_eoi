package com.app.gestionturnos.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;


    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String birth;

    @Column
    private String contractStart;

    @Column
    private String contractEnd;

    @Column
    private String occupation;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

    @Column
    private String salary;

    @Column
    private String obs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Set<Vacation> vacations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Set<Absense> absenses;

    @OneToMany(mappedBy="empleadoperm")
    private Set<PermRemunerados> permRemunerados;

    @OneToMany(mappedBy="empleadopermc21")
    private Set<PermRemuneradoscon2> permRemunerados1;

    @OneToMany(mappedBy="empleadopermc22")
    private Set<PermRemuneradoscon2> permRemunerados2;

    @OneToMany(mappedBy="empleadoemisor")
    private Set<Mensajes> mensajesemisor;

    @OneToMany(mappedBy="empleadoreceptor")
    private Set<Mensajes> mensajerecepor;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoEmpleado")
    private Employee empleadoGaleriaEmbed;

    @ManyToOne
    private Employee employee;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getContractStart() {
        return this.contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return this.contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Set<Vacation> getVacations() {
        return this.vacations;
    }

    public void setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
    }

    public Set<Absense> getAbsenses() {
        return this.absenses;
    }

    public void setAbsenses(Set<Absense> absenses) {
        this.absenses = absenses;
    }

    public String getSalary() {
        try {
            return String.format("%,.2f", Double.valueOf(this.salary));
        } catch (Exception e) {
            return this.salary;
        }
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
