package daycare.demo.daycare.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daycare.demo.daycare.dao.MainMapper;
import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;

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

    public UserResponseDTO getUser(String id){
        System.out.println("debug >>> service getUser " + mainMapper);
        UserResponseDTO result = mainMapper.userSelectRow(id);
        return result;
    }
}
