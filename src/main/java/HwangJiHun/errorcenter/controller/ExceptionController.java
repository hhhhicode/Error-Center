package HwangJiHun.errorcenter.controller;

import HwangJiHun.errorcenter.model.MyException;
import HwangJiHun.errorcenter.service.ExceptionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ExceptionController {

    @Autowired
    ExceptionService exceptionService;

    @ResponseBody
    @PostMapping(value = "/ex/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public MyException saveException(@RequestBody MyException myException) {
        log.info("-> Get Exception Completion! = [{}] {}", myException.getProjectId(), myException.getDate());
        exceptionService.saveException(myException);

        return myException;
    }
}
