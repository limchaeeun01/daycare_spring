package daycare.demo.openApi.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import daycare.demo.openApi.domain.DaycareItemDTO;
import daycare.demo.openApi.domain.DaycareSearchRequestDTO;
import daycare.demo.openApi.service.DaycareService;

@RestController
@RequestMapping("/daycare/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DaycareController {

    @Autowired
    private DaycareService daycareService;

    @PostMapping("/search")
    public List<DaycareItemDTO> searchDaycare(@RequestBody DaycareSearchRequestDTO params) {
        System.out.println("client endpoint : /daycare/api/search");
        System.out.println("params = " + params);
        return daycareService.searchDaycares(params.getSigun(), params.getType(), params.getName());
    }
}
