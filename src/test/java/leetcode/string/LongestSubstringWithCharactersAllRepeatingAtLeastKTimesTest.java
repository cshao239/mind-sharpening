package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LongestSubstringWithCharactersAllRepeatingAtLeastKTimesTest {


    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(String s, int k, int result) {
        Assertions.assertThat(LongestSubstringWithCharactersAllRepeatingAtLeastKTimes.compute(s,k)).isEqualTo(result);
    }



    private static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of("sss",3,3),
                Arguments.of("sssbbb",2,6),
                Arguments.of("sssbbb",4,0),
                Arguments.of("sssbb",3,3),
                Arguments.of("aaddacdfca",3,5),
                Arguments.of("zzddcdfcca",3,4)
        );
    }
}
