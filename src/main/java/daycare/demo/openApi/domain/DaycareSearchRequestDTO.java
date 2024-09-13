package daycare.demo.openApi.domain;

import lombok.Data;

@Data
public class DaycareSearchRequestDTO {
    private String sigun;
    private String type;
    private String name;
}
