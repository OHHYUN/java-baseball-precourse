package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(135);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(713)
                    .thenReturn(589);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    void 게임종료_후_재시작_에러출력() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(713)
                .thenReturn(589);
            run("713", "3", "1", "589", "2");
            verify("3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 끝",
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                "[ERROR] 1이나 2를 입력해주세요.",
                "3스트라이크",
                "3개의 숫자를 모두 맞히셨습니다! 게임 끝",
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    @Test
    void 세글자_입력_검증() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(589);
            run("71544", "ㅁㄹㅁㄴㄹㄴ", "asdfsfaf", "$()*!@!#", "589", "2");
            verify("[ERROR] : 3자리 숫자를 입력해주세요",
                "[ERROR] : 3자리 숫자를 입력해주세요",
                "[ERROR] : 3자리 숫자를 입력해주세요",
                "[ERROR] : 3자리 숫자를 입력해주세요",
                "3스트라이크",
                "게임 끝"
                );
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
