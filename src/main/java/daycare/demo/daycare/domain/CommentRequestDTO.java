package daycare.demo.daycare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentRequestDTO {
    private Integer postId;
    private Integer uid;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
}
