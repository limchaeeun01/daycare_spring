package daycare.demo.daycare.domain;

import lombok.Data;

@Data
public class UserResponseDTO {

    private Integer uid;
    private String id;
    private String name;
    private String email;
    private String phone;

    public Integer getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }
}
