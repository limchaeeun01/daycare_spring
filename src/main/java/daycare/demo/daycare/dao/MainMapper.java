package daycare.demo.daycare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import daycare.demo.daycare.domain.PostRequestDTO;
import daycare.demo.daycare.domain.PostResponseDTO;
import daycare.demo.daycare.domain.ReviewRequestDTO;
import daycare.demo.daycare.domain.ReviewResponseDTO;
import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;
import daycare.demo.daycare.domain.CommentRequestDTO;
import daycare.demo.daycare.domain.CommentResponseDTO;
import daycare.demo.daycare.domain.LikeResponseDTO;

@Mapper
public interface MainMapper {

    public void signupInsertRow(UserRequestDTO params);

    public Integer idCheckSelectRow(Map<String, String> map);

    public Integer loginSelectRow(Map<String, String> map);

    public UserResponseDTO userSelectRow(String id);

    public UserResponseDTO userSelectRow_2(Integer uid);

    public void reviewInsertRow(ReviewRequestDTO params);

    public List<ReviewResponseDTO> reviewSelectRow(String daycareId);

    public Integer likeSelectRow(Map<String, Object> map);

    public void likeInsertRow(Map<String, Object> map);

    public void likeDeleteRow(Map<String, Object> map);

    public void postInsertRow(PostRequestDTO params);

    public void postDeleteRow(Integer postId);

    public List<PostResponseDTO> postSelectRow();

    public void postUpdateRow(PostRequestDTO params);

    public List<CommentResponseDTO> commentSelectRow(Integer postId);

    public void commentInsertRow(CommentRequestDTO params);

    public List<LikeResponseDTO> likeDaycareSelectRow(Integer uid);

    
}
