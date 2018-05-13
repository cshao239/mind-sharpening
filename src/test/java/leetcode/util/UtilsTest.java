package leetcode.util;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
public class UtilsTest {

    @Test
    public void testReverseString() {
        Assertions.assertThat(Utils.reserveString("cba")).isEqualTo("abc");
        org.assertj.core.api.Assertions.assertThat("").isEqualTo(Utils.reserveString(""));
        org.assertj.core.api.Assertions.assertThat((String) null).isEqualTo(Utils.reserveString((String)null));
    }

    @Test
    public void testArrayRepresentation(){
        log.info(Arrays.toString(Utils.countRepresentation("abc")));
    }


    @ParameterizedTest
    @MethodSource
    public void testStro(int i, boolean result) {
        Assertions.assertThat(Utils.isStrobogrammatic(i)).isEqualTo(result);
    }

    private static Stream<Arguments> testStro() {
        return Stream.of(
                Arguments.of("1",true),
                Arguments.of("11",true),
                Arguments.of("619",true),
                Arguments.of("6969",true),
                Arguments.of("808",true),
                Arguments.of("4",false),
                Arguments.of("5",false),
                Arguments.of("6",false),
                Arguments.of("1341234",false),
                Arguments.of("62345234",false)
        );
    }


    @Test
    public void testAllStro(){
        log.info (Utils.allStrobogrammatic(4,4).toString());
    }

}
