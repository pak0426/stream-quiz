package com.mangkyu.stream.Quiz5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        int result = Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
        return result;
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        int result = Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .reduce(Integer.MIN_VALUE, Math::max);
        return result;
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {
        List<Integer> result = new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        return result;
    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        return Collections.emptyList();
    }

}
