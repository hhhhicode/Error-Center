package HwangJiHun.errorcenter.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
public class MyException {
    private final int projectId;
    private final Timestamp date;
    private final String messageBody;
}