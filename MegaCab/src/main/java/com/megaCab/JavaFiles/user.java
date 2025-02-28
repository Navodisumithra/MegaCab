package com.megaCab.JavaFiles;

public class user {
        private String name;
        private String address;
        private String nic;
        private String telephone;

        public user(String name, String address, String nic,String telephone ) {
            this.name = name;
            this.address = address;
            this.nic = nic;
            this.telephone = telephone;
        }

        public String getName() { return name; }
        public String getEmail() { return address; }
        public String getPassword() { return nic; }
    public String getTelephone() { return telephone;}
}
