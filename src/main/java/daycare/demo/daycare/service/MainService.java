package daycare.demo.daycare.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daycare.demo.daycare.dao.MainMapper;
import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;
import daycare.demo.daycare.domain.ReviewRequestDTO;
import daycare.demo.daycare.domain.ReviewResponseDTO;
import daycare.demo.daycare.domain.PostRequestDTO;
import daycare.demo.daycare.domain.PostResponseDTO;
import daycare.demo.daycare.domain.CommentRequestDTO;
import daycare.demo.daycare.domain.CommentResponseDTO;
import daycare.demo.daycare.domain.LikeResponseDTO;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public void signup(UserRequestDTO params) {
        System.out.println("debug >>> service signup " + mainMapper);
        mainMapper.signupInsertRow(params);
    }

    public boolean idCheck(Map<String, String> map) {
        System.out.println("debug >>> service idCheck " + mainMapper);

        Integer count = mainMapper.idCheckSelectRow(map);
        Boolean result = (count > 0) ? true : false;
        return result;
    }

    public boolean login(Map<String, String> map) {
        System.out.println("debug >>> service login " + mainMapper);

        Integer count = mainMapper.loginSelectRow(map);
        Boolean result = (count > 0) ? true : false;
        return result;
    }

    public UserResponseDTO getUser(String id) {
        System.out.println("debug >>> service  getUser " + mainMapper);
        UserResponseDTO result = mainMapper.userSelectRow(id);
        return result;
    }

    public UserResponseDTO getUser(Integer uid) {
        System.out.println("debug >>> service  getUser " + mainMapper);
        UserResponseDTO result = mainMapper.userSelectRow_2(uid);
        return result;
    }

    public void postReview(ReviewRequestDTO params) {
        System.out.println("debug >>> service postReview " + mainMapper);
        mainMapper.reviewInsertRow(params);
    }

    public List<ReviewResponseDTO> getReview(String daycareId) {
        System.out.println("debug >>> service  getReview " + mainMapper);
        List<ReviewResponseDTO> result = mainMapper.reviewSelectRow(daycareId);
        return result;
    }

    public boolean getLike(Map<String, Object> map) {
        System.out.println("debug >>> service getLike " + mainMapper);

        Integer count = mainMapper.likeSelectRow(map);
        Boolean result = (count > 0) ? true : false;
        return result;
    }

    public void addLike(Map<String, Object> map) {
        System.out.println("debug >>> service addLike " + mainMapper);
        mainMapper.likeInsertRow(map);
    }

    public void deleteLike(Map<String, Object> map) {
        System.out.println("debug >>> service deleteLike " + mainMapper);
        mainMapper.likeDeleteRow(map);
    }

    public void addPost(PostRequestDTO params) {
        System.out.println("debug >>> service addPost " + mainMapper);
        mainMapper.postInsertRow(params);
    }

    public List<PostResponseDTO> getPost() {
        System.out.println("debug >>> service getPost " + mainMapper);
        List<PostResponseDTO> result = mainMapper.postSelectRow();
        return result;
    }

    public List<CommentResponseDTO> getComment(Integer postId) {
        System.out.println("debug >>> service getComment " + mainMapper);
        List<CommentResponseDTO> result = mainMapper.commentSelectRow(postId);
        return result;
    }

    public void addComment(CommentRequestDTO params) {
        System.out.println("debug >>> service addComment " + mainMapper);
        mainMapper.commentInsertRow(params);
    }

    public List<LikeResponseDTO> getLikeDaycare(Integer uid) {
        System.out.println("debug >>> service getLikeDaycare " + mainMapper);
        List<LikeResponseDTO> result = mainMapper.likeDaycareSelectRow(uid);
        return result;
    }

}
