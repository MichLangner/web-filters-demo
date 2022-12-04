package io.michlangner.webfiltersdemo.user;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;

@ConfigurationProperties(value = "sda")
@Data
public class ApplicationUsersProperties {

    List<ApplicationUser> appUser;

    public ApplicationUsersProperties(List<ApplicationUser> appUser) {
        this.appUser = appUser;
    }

    @PostConstruct
    public void printAllUsers(){
        appUser.forEach(System.out::println);

    }
}
