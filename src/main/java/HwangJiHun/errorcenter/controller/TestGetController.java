package HwangJiHun.errorcenter.controller;

import HwangJiHun.errorcenter.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/testget")
public class TestGetController {

    @Autowired
    TestService testService;

    @GetMapping("/start")
    public String testStartHandle() {
        return testService.callTestGetFeign("이 string 은 잘 갑니까?");
    }

    @GetMapping("/get/{string}")
    public String testTargetHandle(@PathVariable("string") String string) {

        return string + "을 받았습니다.";
    }
}
