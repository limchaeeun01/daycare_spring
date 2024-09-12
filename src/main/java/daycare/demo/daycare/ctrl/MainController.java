package daycare.demo.daycare.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daycare.demo.daycare.domain.SignupRequestDTO;
import daycare.demo.daycare.service.MainService;

@RestController
@RequestMapping("/daycare")
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignupRequestDTO params) {
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

}
