package com.megaCab.JavaFiles;

public class User {
    private String id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String nic;
    private String telephone;
    private String userType;
    private String email;

    public User(String id, String username, String password, String userType ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userType = userType;

    }

    public User(String id, String username, String password, String name, String address, String nic, String telephone, String userType, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.telephone = telephone;
        this.userType = userType;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}