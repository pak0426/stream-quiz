package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Quiz1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();

        /**
         * List를 stream으로 변환
         * flatMap을 통해 취미를 split으로 쪼개 배열 스트림으로 변환
         * Collectors.groupingBy를 통해 취미 당 개수를 세기 위한 그룹화
         * Collectors.counting을 통해 개수를 세고, collectingAndThen를 통해 값을 int로 변환
         */
        Map<String, Integer> result = csvLines.stream()
                .flatMap(arr -> Arrays.stream(arr[1].split(":")))
                .map(String::trim)
                .collect(Collectors.groupingBy(
                        hobby -> hobby,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue
                        )
                ));
        return result;
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return new HashMap<>();
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
