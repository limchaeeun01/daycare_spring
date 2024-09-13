package daycare.demo.openApi.util;

public enum CategoryCode {
    SIGUNNAME("시군명", ""),
    STCODE("어린이집 코드", ""),
    CRNAME("어린이집 이름", ""),
    CRTYPENAME("어린이집 유형", ""),
    CRSTATUSNAME("운영 상태", ""),
    ZIPCODE("우편번호", ""),
    CRADDR("주소", ""),
    CRTELNO("전화번호", ""),
    CRFAXNO("팩스번호", ""),
    CRHOME("홈페이지", ""),
    NRTRROOMCNT("보육실 수", "개"),
    NRTRROOMSIZE("보육실 면적", "㎡"),
    PLGRDCO("놀이터 수", "개"),
    CCTVINSTLCNT("CCTV 설치 대수", "대"),
    CHCRTESCNT("교사 수", "명"),
    CRCAPAT("정원 수", "명"),
    CRCHCNT("현원 수", "명"),
    LA("위도", "도"),
    LO("경도", "도"),
    CRCARGBNAME("보육 환경 인증", ""),
    CRCNFMDT("확인 일자", ""),
    CRPAUSEBEGINDT("운영 중지 시작일", ""),
    CRPAUSEENDDT("운영 중지 종료일", ""),
    CRABLDT("폐원 일자", ""),
    DATASTDRDT("데이터 기준일자", ""),
    CRSPEC("어린이집 특성", ""),
    CLASS_CNT_00("0세반 수", "개"),
    CLASS_CNT_01("1세반 수", "개"),
    CLASS_CNT_02("2세반 수", "개"),
    CLASS_CNT_03("3세반 수", "개"),
    CLASS_CNT_04("4세반 수", "개"),
    CLASS_CNT_05("5세반 수", "개"),
    CLASS_CNT_M2("장애반 수", "개"),
    CLASS_CNT_M5("기타반 수", "개"),
    CLASS_CNT_SP("특수반 수", "개"),
    CLASS_CNT_TOT("총 반 수", "개"),
    CHILD_CNT_00("0세반 아동 수", "명"),
    CHILD_CNT_01("1세반 아동 수", "명"),
    CHILD_CNT_02("2세반 아동 수", "명"),
    CHILD_CNT_03("3세반 아동 수", "명"),
    CHILD_CNT_04("4세반 아동 수", "명"),
    CHILD_CNT_05("5세반 아동 수", "명"),
    CHILD_CNT_M2("장애 아동 수", "명"),
    CHILD_CNT_M5("기타 아동 수", "명"),
    CHILD_CNT_SP("특수 아동 수", "명"),
    CHILD_CNT_TOT("총 아동 수", "명"),
    EM_CNT_0Y("영유아 교사 0세반", "명"),
    EM_CNT_1Y("영유아 교사 1세반", "명"),
    EM_CNT_2Y("영유아 교사 2세반", "명"),
    EM_CNT_4Y("영유아 교사 4세반", "명"),
    EM_CNT_6Y("영유아 교사 6세반", "명"),
    EM_CNT_A1("보육교사 1급", "명"),
    EM_CNT_A2("보육교사 2급", "명"),
    EM_CNT_A3("보육교사 3급", "명"),
    EM_CNT_A4("보육교사 4급", "명"),
    EM_CNT_A5("보육교사 5급", "명"),
    EM_CNT_A6("보육교사 6급", "명"),
    EM_CNT_A10("보육교사 10급", "명"),
    EM_CNT_A7("보육교사 7급", "명"),
    EM_CNT_A8("보육교사 8급", "명"),
    EM_CNT_TOT("총 교사 수", "명"),
    WORK_DTTM("작업 일시", "");


    private final String name;
    private final String unit;

    private CategoryCode(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

}