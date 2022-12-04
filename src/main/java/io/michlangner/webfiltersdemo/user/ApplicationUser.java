package io.michlangner.webfiltersdemo.user;


import lombok.Data;

import java.util.List;

@Data
public class ApplicationUser {

    String userName;
    String password;
    List<String> roles;
}
