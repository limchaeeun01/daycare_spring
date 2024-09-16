package daycare.demo.daycare.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import daycare.demo.daycare.domain.UserRequestDTO;
import daycare.demo.daycare.domain.UserResponseDTO;
import daycare.demo.daycare.domain.ReviewRequestDTO;
import daycare.demo.daycare.domain.ReviewResponseDTO;

@Mapper
public interface MainMapper {

    public void signupInsertRow(UserRequestDTO params);

    public Integer idCheckSelectRow(Map<String, String> map);

    public Integer loginSelectRow(Map<String, String> map);

    public UserResponseDTO userSelectRow(String id);

    public void reviewInsertRow(ReviewRequestDTO params);

    public List<ReviewResponseDTO> reviewSelectRow(String daycareId);
}
