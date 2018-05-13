package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("!!!!!!!")
public class OneEditDistanceTest {


    @MethodSource
    @ParameterizedTest(name = "{index} => s={0}, p={1}, result={2}")
    public void shouldPass(String s, String p, boolean result) {
        Assertions.assertThat(OneEditDistance.compute(s,p)).isEqualTo(result);
    }

    private static Stream<Arguments> shouldPass(){
        return Stream.of(
                Arguments.of("aaa","aa",true),
                Arguments.of("aa","aaa",true),
                Arguments.of("aaa","abc",false),
                Arguments.of("acd","adc",false),
                Arguments.of("acd","acda",true),
                Arguments.of("acd","acdaa",false)
        );
    }
}
