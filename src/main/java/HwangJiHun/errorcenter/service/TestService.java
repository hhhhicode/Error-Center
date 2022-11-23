package HwangJiHun.errorcenter.service;

import HwangJiHun.errorcenter.domain.feign.TestClient;
import HwangJiHun.errorcenter.model.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestClient testClient;

    public String callTestGetFeign(String string) {
        return testClient.testGetFeign(string);
    }

    public String callTestPostFeign(MyException myException) {
        return testClient.testPostFeign(myException);
    }
}
