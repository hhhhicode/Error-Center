package HwangJiHun.errorcenter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Clob;
import java.sql.Timestamp;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyException {
    private int projectId;
    private Timestamp date;
    private String errorMessage;
}