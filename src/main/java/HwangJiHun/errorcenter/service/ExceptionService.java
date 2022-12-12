package HwangJiHun.errorcenter.service;

import HwangJiHun.errorcenter.model.MyException;
import HwangJiHun.errorcenter.model.ProjectId;
import HwangJiHun.errorcenter.repository.ExceptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ExceptionService {

    private final ExceptionRepository exceptionRepository;

    public ExceptionService(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    public void saveException(MyException myException) {
        MyException savedException = exceptionRepository.save(myException);
        log.info("<- Save Exception Completion! = [{}] {}", savedException.getProjectId(), savedException.getDate());
    }

    public MyException findByProjectIdException(int projectId) {

        Optional<MyException> findException = exceptionRepository.findByProjectIdLimit1(projectId);
        if (findException.isEmpty()) {
            return new MyException();
        }
        return findException.get();
    }
}
