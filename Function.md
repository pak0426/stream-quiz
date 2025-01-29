# 생성 메서드
- `Stream.of(T... values)`: 지정된 값들로 스트림 생성
- `Arrays.stream(array)`: 배열로부터 스트림 생성
- `Collection.stream()`: 컬렉션으로부터 스트림 생성
- `Stream.iterate()`: 초기값과 람다식으로 무한 스트림 생성
- `Stream.generate()`: Supplier로 무한 스트림 생성

# 중간 연산 메서드
- `filter(Predicate)`: 조건에 맞는 요소만 필터링
- `map(Function)`: 각 요소를 변환
- `flatMap(Function)`: 각 요소를 스트림으로 변환 후 하나의 스트림으로 평면화
- `distinct()`: 중복 제거
- `sorted()`: 정렬
- `peek(Consumer)`: 각 요소를 소비하면서 스트림을 그대로 반환
- `limit(long)`: 스트림 크기 제한
- `skip(long)`: 처음 n개 요소 건너뛰기

# 최종 연산 메서드
- `forEach(Consumer)`: 각 요소에 대해 작업 수행
- `count()`: 요소 개수 반환
- `collect(Collector)`: 스트림을 컬렉션으로 변환
- `reduce(BinaryOperator)`: 스트림의 요소를 하나로 줄임
- `anyMatch(Predicate)`: 조건을 만족하는 요소가 하나라도 있는지 확인
- `allMatch(Predicate)`: 모든 요소가 조건을 만족하는지 확인
- `noneMatch(Predicate)`: 모든 요소가 조건을 만족하지 않는지 확인
- `findFirst()`: 첫 번째 요소 반환
- `findAny()`: 아무 요소나 반환
- `min(Comparator)`: 최솟값 찾기
- `max(Comparator)`: 최댓값 찾기

# Collectors 유틸리티 메서드
- `toList()`: List로 수집
- `toSet()`: Set으로 수집
- `toMap()`: Map으로 수집
- `groupingBy()`: 그룹화
- `joining()`: 문자열 연결
- `counting()`: 개수 계산
- `summarizingInt/Long/Double()`: 숫자 통계 정보 수집