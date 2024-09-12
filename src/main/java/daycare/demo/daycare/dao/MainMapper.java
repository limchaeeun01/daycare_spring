package daycare.demo.daycare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import daycare.demo.daycare.domain.SignupRequestDTO;

@Mapper
public interface MainMapper {

    public void signupInsertRow(SignupRequestDTO params);

    public Integer idCheckSelectRow(Map<String, String> map);
}
