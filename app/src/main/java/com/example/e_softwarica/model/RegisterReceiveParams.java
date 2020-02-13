package com.example.e_softwarica.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;




    public class RegisterReceiveParams {
        public String id;
        public String name;
        public String email;
        public String password;

        public RegisterReceiveParams(String id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
