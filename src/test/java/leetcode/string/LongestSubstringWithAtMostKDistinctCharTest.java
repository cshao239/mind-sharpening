package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestSubstringWithAtMostKDistinctCharTest {
    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, int k, String result) {
        Assertions.assertThat(LongestSubstringWithAtMostKDistinctChar.compute(s,k)).isEqualTo(result);
    }


    private static Stream<Arguments> testCompute(){
        return Stream.of(
                Arguments.of("abcd",2,"ab"),
                Arguments.of("abbacc",2,"abba"),
                Arguments.of("cabbacc",2,"abba"),
                Arguments.of("cabbaccddd",2,"ccddd")
        );
    }
}
