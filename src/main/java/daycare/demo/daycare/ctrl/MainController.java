package daycare.demo.daycare.ctrl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;
import daycare.demo.daycare.service.MainService;
import daycare.demo.daycare.domain.ReviewRequestDTO;
import daycare.demo.daycare.domain.ReviewResponseDTO;

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

    /* 
    @GetMapping("/user")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable(name = "id") String id) {
        System.out.println("client endpoint : /user/{id}");
        System.out.println("params = " + id);

        Map<String, String> map = new HashMap<>();
        map.put("id", id);

        UserResponseDTO user = mainService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
     */
}
