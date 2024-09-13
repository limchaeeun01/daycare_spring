package daycare.demo.openApi.domain;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import daycare.demo.openApi.service.DaycareService;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaycareItemDTO {

    @Autowired
    private DaycareService daycareService;

    public DaycareItemDTO() {
    }

    @JsonProperty("startIndex")
    private Integer startIndex;

    @JsonProperty("endIndex")
    private Integer endIndex;

    @JsonProperty("SIGUNNAME")
    private String sigunName; // 시군구명

    @JsonProperty("STCODE")
    private String stCode; // 어린이집 코드

    @JsonProperty("CRNAME")
    private String crName; // 어린이집 이름

    @JsonProperty("CRTYPENAME")
    private String crTypeName; // 어린이집 유형

    @JsonProperty("CRSTATUSNAME")
    private String crStatusName; // 상태 (예: 정상)

    @JsonProperty("ZIPCODE")
    private String zipCode; // 우편번호

    @JsonProperty("CRADDR")
    private String crAddr; // 주소

    @JsonProperty("CRTELNO")
    private String crTelNo; // 전화번호

    @JsonProperty("CRFAXNO")
    private String crFaxNo; // 팩스번호

    @JsonProperty("CRHOME")
    private String crHome; // 홈페이지

    @JsonProperty("NRTRROOMCNT")
    private String nrtrRoomCnt; // 보육실 수

    @JsonProperty("NRTRROOMSIZE")
    private String nrtrRoomSize; // 보육실 면적

    @JsonProperty("PLGRDCO")
    private String plGrdCo; // 놀이터 수

    @JsonProperty("CCTVINSTLCNT")
    private String cctvInstlCnt; // CCTV 설치 수

    @JsonProperty("CHCRTESCNT")
    private String chCrTesCnt; // 특수보육 교사 수

    @JsonProperty("CRCAPAT")
    private String crCapat; // 정원

    @JsonProperty("CRCHCNT")
    private String crChCnt; // 현원

    @JsonProperty("LA")
    private String la; // 위도

    @JsonProperty("LO")
    private String lo; // 경도

    @JsonProperty("CRCARGBNAME")
    private String crCarGbName; // 차량유형

    @JsonProperty("CRCNFMDT")
    private String crCnfMdt; // 인가일

    @JsonProperty("CRPAUSEBEGINDT")
    private String crPauseBeginDt; // 운영중단 시작일

    @JsonProperty("CRPAUSEENDDT")
    private String crPauseEndDt; // 운영중단 종료일

    @JsonProperty("CRABLDT")
    private String crAbldt; // 폐지일

    @JsonProperty("DATASTDRDT")
    private String dataStdrDt; // 데이터 기준일

    @JsonProperty("CRSPEC")
    private String crSpec; // 특이사항

    @JsonProperty("CLASS_CNT_TOT")
    private Integer classCntTot; // 전체 반 수

    @JsonProperty("CHILD_CNT_TOT")
    private Integer childCntTot; // 전체 어린이 수

    @JsonProperty("EM_CNT_TOT")
    private Integer emCntTot; // 전체 직원 수

    @JsonProperty("WORK_DTTM")
    private String workDttm; // 작업 시간

}
