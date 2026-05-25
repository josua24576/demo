package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private Integer usia;
    private String pekerjaan;

    public Integer getUsia() {
        return usia;
    }

    public void setUsia(Integer usia) {
        this.usia = usia;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    // getter setter
    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}