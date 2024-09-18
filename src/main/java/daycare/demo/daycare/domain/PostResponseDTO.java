package daycare.demo.daycare.domain;

import lombok.Data;

@Data
public class PostResponseDTO {
    private Integer postId;
    private Integer uid;
    private String title;
    private String content;
    private String date;
}
