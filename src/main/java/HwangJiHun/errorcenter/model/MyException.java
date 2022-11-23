package HwangJiHun.errorcenter.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MyException {
    private final int projectId;
    private final String messageBody;
}