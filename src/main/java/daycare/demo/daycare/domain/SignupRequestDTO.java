package daycare.demo.daycare.domain;

import lombok.Data;

@Data
public class SignupRequestDTO {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private String phone;
}
