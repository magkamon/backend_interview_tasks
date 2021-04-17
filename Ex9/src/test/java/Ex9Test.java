import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Ex9Test {

    @Test
    void doesContainSameLettersIsFalseWhenNullArguments() {
        //given
        String firstWord = null;
        String secondWord = "notNull";
        //when
        boolean areTheSame = Ex9.doesContainSameLetters(firstWord, secondWord);
        //then
        assertThat(areTheSame).isFalse();
    }

    @Test
    void doesContainSameLettersIsFalseWhenEmptyArguments() {
        //given
        String firstWord = "";
        String secondWord = "notNull";
        //when
        boolean areTheSame = Ex9.doesContainSameLetters(firstWord, secondWord);
        //then
        assertThat(areTheSame).isFalse();
    }

    @Test
    void doesContainSameLettersIsTrueWhenSameLetters() {
        //given
        String firstWord = "MARA";
        String secondWord = "rama";
        //when
        boolean areTheSame = Ex9.doesContainSameLetters(firstWord, secondWord);
        //then
        assertThat(areTheSame).isTrue();
    }

    @Test
    void doesContainSameLettersIsFalseWhenNotSameLetters() {
        //given
        String firstWord = "MARA";
        String secondWord = "ramax";
        //when
        boolean areTheSame = Ex9.doesContainSameLetters(firstWord, secondWord);
        //then
        assertThat(areTheSame).isFalse();
    }

}
