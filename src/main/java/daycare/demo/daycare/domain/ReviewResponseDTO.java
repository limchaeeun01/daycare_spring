package daycare.demo.daycare.domain;

import lombok.Data;

@Data
public class ReviewResponseDTO {

    private Integer reviewId;
    private Integer uid;
    private Float rating;
    private String content;
    private String date;
}
