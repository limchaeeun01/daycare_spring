package daycare.demo.openApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import daycare.demo.openApi.domain.DaycareItemDTO;
import daycare.demo.openApi.domain.DaycareItems;

@Service
public class DaycareService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "http://openapi.seoul.go.kr:8088/5a696a4a6b74776f33377172777252/json/ChildCareInfo/1/1000/";

    public List<DaycareItemDTO> searchDaycares(String sigun, String type, String name) {

        String url = UriComponentsBuilder.fromHttpUrl(API_URL).toUriString();

        DaycareItems response = restTemplate.getForObject(url, DaycareItems.class);

        if (response != null && response.getChildCareInfo() != null) {

            List<DaycareItemDTO> filteredList = response.getChildCareInfo().getRow().stream()
                    .filter(item -> item.getSigunName().contains(sigun))
                    .filter(item -> item.getCrTypeName().contains(type))
                    .filter(item -> item.getCrName().contains(name))
                    .collect(Collectors.toList());

            // 필터링된 데이터를 출력
            filteredList.forEach(item -> System.out.println(item.getCrName()));

            return filteredList;
        } else {
            System.out.println("No data received from API.");
            return List.of(); // 빈 리스트 반환
        }
    }
}
