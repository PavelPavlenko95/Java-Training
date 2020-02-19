package by.pavelpavlenko.trainingcenter.entity;

import java.util.HashMap;
import java.util.Map;

public enum LectureStatus {

    NEW(1),

    PROCESSING(2),

    DONE(3);

    private int code;

    private static final Map<LectureStatus, Integer> LECTURE_STATUS_INTEGER_MAP = new HashMap<>();
    private static final Map<String, LectureStatus> STRING_LECTURE_STATUS_MAP = new HashMap<>();

    static {
        for (LectureStatus lectureStatus : values()) {
            LECTURE_STATUS_INTEGER_MAP.put(lectureStatus, lectureStatus.getCode());
            STRING_LECTURE_STATUS_MAP.put(lectureStatus.name(), lectureStatus);
        }
    }

    LectureStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Integer getCodeByLectureStatus(LectureStatus status) {
        return LECTURE_STATUS_INTEGER_MAP.get(status);
    }

    public static LectureStatus getLectureStatusByString(String name) {
        return STRING_LECTURE_STATUS_MAP.get(name.toUpperCase());
    }

}

