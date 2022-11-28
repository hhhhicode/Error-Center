package HwangJiHun.errorcenter.repository;

import HwangJiHun.errorcenter.model.MyException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ExceptionRepositoryTest {

    @Autowired
    ExceptionRepository exceptionRepository;

    @Test
    @Transactional
    @DisplayName("예외 저장 확인")
    void save() {
        MyException myException = new MyException();
        myException.setDate(new Timestamp(System.currentTimeMillis()));
        myException.setErrorMessage("Test Exception");
        myException.setProjectId(0);

        log.info("myException = {}", myException);

        MyException saveMyException = exceptionRepository.save(myException);

        Optional<MyException> findMyException = exceptionRepository.findById(saveMyException.getId());

        assertThat(saveMyException).usingRecursiveComparison().isEqualTo(findMyException.orElse(null));
    }
}