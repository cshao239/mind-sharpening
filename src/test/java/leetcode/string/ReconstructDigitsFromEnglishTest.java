package leetcode.string;

import leetcode.util.Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReconstructDigitsFromEnglishTest {
    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, String result) {
        Assertions.assertThat(Utils.isAnagram(ReconstructDigitsFromEnglish.compute(s),result)).isTrue();
    }


    private static Stream<Arguments> testCompute(){
        return Stream.of(
                Arguments.of("owoztneoer","012"),
                Arguments.of("fviefuro","54")
        );
    }
}
