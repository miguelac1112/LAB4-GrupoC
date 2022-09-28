package com.example.lab4_gtics.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta", nullable = false)
    private Integer id;

    @Column(name = "correo", length = 45)
    private String correo;

    @Column(name = "direccion", nullable = false, length = 80)
    @Size(max = 80, message = "El tamaño máximo es 80 caracteres")
    @NotBlank
    private String direccion;

    @Column(name = "password", nullable = false, length = 128)
    @NotBlank(message = "Campo obligatorio")
    private String password;

    @Column(name = "telefono", nullable = false, length = 10)
    @Size(max = 9, message = "El tamaño máximo es de 9 digitos")
    @NotBlank
    private String telefono;

    @Column(name = "admin")
    private Integer admin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

}