package HwangJiHun.errorcenter.service;

import HwangJiHun.errorcenter.model.MyException;
import HwangJiHun.errorcenter.repository.ExceptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExceptionService {

    private final ExceptionRepository exceptionRepository;

    public ExceptionService(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    public void saveException(MyException myException) {
        MyException savedException = exceptionRepository.save(myException);
        log.info("Save Exception Completion! = {}", savedException);
    }
}
