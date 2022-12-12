package HwangJiHun.errorcenter.controller;

import HwangJiHun.errorcenter.model.MyException;
import HwangJiHun.errorcenter.model.ProjectId;
import HwangJiHun.errorcenter.service.ExceptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/external")
public class ExternalErrorController {

    private final ExceptionService exceptionService;

    public ExternalErrorController(ExceptionService exceptionService) {
        this.exceptionService = exceptionService;
    }

    @GetMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MyException> dashboardServing() {
        List<MyException> errorList = new ArrayList<>();
        errorList.add(exceptionService.findByProjectIdException(ProjectId.PoeItemValues.getProjectId()));

        return errorList;
    }
}
