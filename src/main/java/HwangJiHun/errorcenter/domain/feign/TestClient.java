package HwangJiHun.errorcenter.domain.feign;

import HwangJiHun.errorcenter.domain.feign.config.PostConfiguration;
import HwangJiHun.errorcenter.model.MyException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "test1", url = "http://localhost:8090")
public interface TestClient {

    @GetMapping("/testget/get/{string}")
    String testGetFeign(@PathVariable("string") String string);

    @PostMapping(value = "/testpost/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    String testPostFeign(MyException myException);
}
