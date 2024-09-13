package daycare.demo.openApi.domain;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import daycare.demo.openApi.domain.DaycareItemDTO;

@Data
@AllArgsConstructor
public class DaycareItems {

    public DaycareItems() {}

    @JsonProperty("ChildCareInfo")
    private ChildCareInfo childCareInfo;

    @Data
    public static class ChildCareInfo {

        private List<DaycareItemDTO> row;
    }
}
