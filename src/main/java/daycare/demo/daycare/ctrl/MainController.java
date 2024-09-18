package daycare.demo.daycare.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;
import daycare.demo.daycare.service.MainService;
import daycare.demo.daycare.domain.ReviewRequestDTO;
import daycare.demo.daycare.domain.ReviewResponseDTO;
import daycare.demo.daycare.domain.PostRequestDTO;
import daycare.demo.daycare.domain.PostResponseDTO;
import daycare.demo.daycare.domain.CommentRequestDTO;
import daycare.demo.daycare.domain.CommentResponseDTO;
import daycare.demo.daycare.domain.LikeResponseDTO;

@RestController
@RequestMapping("/daycare")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody UserRequestDTO params) {
        System.out.println("client endpoint : /daydare/signup");
        System.out.println("params = " + params);
        mainService.signup(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/signup/idCheck/{id}")
    public ResponseEntity<Boolean> idCheck(@PathVariable(name = "id") String id) {
        System.out.println("client endpoint : /signup/idCheck/{id}");
        System.out.println("params = " + id);

        Map<String, String> map = new HashMap<>();
        map.put("id", id);

        boolean idCheck = mainService.idCheck(map);

        return new ResponseEntity<>(idCheck, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> params) {
        System.out.println("client endpoint : /login");
        System.out.println("params = " + params);

        Map<String, Object> response = new HashMap<>();
        boolean login = mainService.login(params);

        if (login) {
            UserResponseDTO user = mainService.getUser(params.get("id"));

            if (user != null) {
                response.put("success", true);
                response.put("uid", user.getUid());
                response.put("name", user.getName());
            } else {
                response.put("success", false);
                response.put("message", "User not found.");
            }
        } else {
            response.put("success", false);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable(name = "uid") Integer uid) {
        System.out.println("client endpoint : /user/{uid}");
        System.out.println("params = " + uid);

        UserResponseDTO response = mainService.getUser(uid);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<Void> postReview(@RequestBody ReviewRequestDTO params) {
        System.out.println("client endpoint : /review");
        System.out.println("params = " + params);
        mainService.postReview(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/review/{daycareId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReview(@PathVariable(name = "daycareId") String daycareId) {
        System.out.println("client endpoint : /daycare/review/{daycareId}");
        System.out.println("params = " + daycareId);

        List<ReviewResponseDTO> response = mainService.getReview(daycareId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/like")
    public ResponseEntity<Boolean> getLike(@RequestParam Integer uid, @RequestParam String daycareId) {
        System.out.println("client endpoint : /like");
        System.out.println("uid = " + uid);
        System.out.println("daycareId = " + daycareId);

        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("daycareId", daycareId);

        Boolean response = mainService.getLike(params);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/likeDaycare/{uid}")
    public ResponseEntity<List<LikeResponseDTO>> getLikeDaycare(@PathVariable(name = "uid") Integer uid) {
        System.out.println("client endpoint : /likeDaycare/{uid}");
        System.out.println("uid = " + uid);

        List<LikeResponseDTO> response = mainService.getLikeDaycare(uid);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/like/add")
    public ResponseEntity<Void> addLike(@RequestParam Integer uid, @RequestParam String daycareId) {
        System.out.println("client endpoint : /like/add");
        System.out.println("uid = " + uid);
        System.out.println("daycareId = " + daycareId);

        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("daycareId", daycareId);

        mainService.addLike(params);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/like/delete")
    public ResponseEntity<Void> deleteLike(@RequestParam Integer uid, @RequestParam String daycareId) {
        System.out.println("client endpoint : /like/delete");
        System.out.println("uid = " + uid);
        System.out.println("daycareId = " + daycareId);

        Map<String, Object> params = new HashMap<>();
        params.put("uid", uid);
        params.put("daycareId", daycareId);

        mainService.deleteLike(params);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/post/add")
    public ResponseEntity<Void> addPost(@RequestBody PostRequestDTO params) {
        System.out.println("client endpoint : /post/add");
        System.out.println("params = " + params);

        mainService.addPost(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostResponseDTO>> getPost() {
        System.out.println("client endpoint : /daycare/post");

        List<PostResponseDTO> response = mainService.getPost();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/post/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable(name = "postId") Integer postId) {
        System.out.println("client endpoint : /post/delete/{postId}");

        mainService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/post/update")
    public ResponseEntity<Void> updatePost(@RequestBody PostRequestDTO params) {
        System.out.println("client endpoint : /post/update/{postId}");

        mainService.updatePost(params);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/comment/{postId}")
    public ResponseEntity<List<CommentResponseDTO>> getComment(@PathVariable(name = "postId") Integer postId) {
        System.out.println("client endpoint : /comment/{id}");

        List<CommentResponseDTO> response = mainService.getComment(postId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/comment/add")
    public ResponseEntity<Void> addComment(@RequestBody CommentRequestDTO params) {
        System.out.println("client endpoint : /comment/add");
        System.out.println("params = " + params);

        mainService.addComment(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
