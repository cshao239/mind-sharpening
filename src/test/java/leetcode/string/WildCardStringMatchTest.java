package leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("!!!!!!!")
public class WildCardStringMatchTest {


    @MethodSource
    @ParameterizedTest(name = "{index} => s={0}, p={1}, result={2}")
    @DisplayName("Should pass leetcode.string.WildCardStringMatchTest")
    public void shouldPass(String s, String p, boolean result) {
        Assertions.assertThat(WildCardStringMatch.match(s,p)).isEqualTo(result);
    }

    private static Stream<Arguments> shouldPass(){
        return Stream.of(
                Arguments.of("aaa","aa",false),
                Arguments.of("aa","aaa",false),
                Arguments.of("aaa","a*",true),
                Arguments.of("abc","a?c",true),
                Arguments.of("abcbac","a*ac",true),
                Arguments.of("abcdecfgc","*cdecfgc",true),
                Arguments.of("abcdecfgc","*cfgc",true),
                Arguments.of("abcdecfgc","*c",true)
        );
    }
}
