package daycare.demo.daycare.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentResponseDTO {
    private Integer commentId;
    private Integer postId;
    private Integer uid;
    private String content;
    private String date;
}
