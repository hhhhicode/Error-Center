package HwangJiHun.errorcenter.controller;

import HwangJiHun.errorcenter.model.MyException;
import HwangJiHun.errorcenter.service.TestService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/testpost")
public class TestPostController {

    @Autowired
    TestService testService;

    @GetMapping("/start")
    public String testStartHandle() {
        MyException myException = new MyException(1, new Timestamp(System.currentTimeMillis()), new IllegalAccessException("IllegalAccessException Test Message").getMessage());
        return testService.callTestPostFeign(myException);
    }

    @PostMapping (value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public String testTargetHandle(@RequestBody String messageBody) {

        return messageBody;
    }
}
