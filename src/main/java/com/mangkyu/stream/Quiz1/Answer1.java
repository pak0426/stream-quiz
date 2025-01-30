package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer1 {

    private static final String TARGET = "좋아";
    private static final int TARGET_LENGTH = TARGET.length();

    /**
     * map을 통해 각 행의 1열에 대한 공백 제거
     * flatMap을 통해 1열의 문자열을 split으로 분리한걸 문자열 스트림으로 변환
     * Collectors.toMap을 통해 Map으로 변환하는데 취미 이름을 키로 두고 같은 취미가 발견되면 +1을 계속해서 카운팅함
     */
    public Map<String, Integer> quiz1() throws IOException, CsvException {
        // https://jeong-pro.tistory.com/212
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> newValue += oldValue));
    }

    public Map<String, Integer> quiz2() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .filter(line -> line[0].startsWith("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> ++newValue));
    }

    public int quiz3() throws IOException, CsvException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);
    }

    private int countContains(String src, int fromIndex) {
        int index = src.indexOf(TARGET, fromIndex);
        if (index >= 0) {
            return 1 + countContains(src, index + TARGET_LENGTH);
        }
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
