package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortCharactersByFrequencyTest {
    @ParameterizedTest
    @MethodSource
    public void testCompute(String s, String result){
        Assertions.assertThat(SortCharactersByFrequency.compute(s)).isEqualTo(result);
    }


    private static Stream<Arguments> testCompute(){
        return Stream.of (
                Arguments.of("cccaaa", "aaaccc"),
                Arguments.of("Aabb", "bbAa")
        );
    }
}
