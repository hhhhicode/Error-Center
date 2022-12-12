package HwangJiHun.errorcenter.model;

import lombok.Getter;

@Getter
public enum ProjectId {
    PoeItemValues(80),
    CoronaMonitor(81),
    Members(91),
    ErrorCenter(90);

    private final int projectId;

    ProjectId(int projectId) {
        this.projectId = projectId;
    }
}
