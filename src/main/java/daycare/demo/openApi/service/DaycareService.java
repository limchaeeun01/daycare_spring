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
        // OpenAPI 호출 URL 생성
        String url = UriComponentsBuilder.fromHttpUrl(API_URL).toUriString();

        // API 호출 및 응답 데이터 파싱
        DaycareItems response = restTemplate.getForObject(url, DaycareItems.class);

        if (response != null && response.getChildCareInfo() != null) {
            // 데이터의 name만 출력
            response.getChildCareInfo().getRow().forEach(item -> System.out.println(item.getCrName()));
        } else {
            System.out.println("No data received from API.");
        }

        // 검색 조건에 맞게 데이터 필터링
        return response.getChildCareInfo().getRow().stream()
                .filter(item -> item.getSigunName().contains(sigun))
                .filter(item -> item.getCrTypeName().contains(type))
                .filter(item -> item.getCrName().contains(name))
                .collect(Collectors.toList());
    }
}
