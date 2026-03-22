package FIleEx;

import java.io.*;

/**
 * ============================================================
 *  FIle.ScrambledOutputStream 학습 예제
 * ============================================================
 *
 *  이 예제를 통해 배울 수 있는 것들:
 *    1. FilterOutputStream의 동작 원리 (데코레이터 패턴)
 *    2. 바이트 단위 스트림 처리
 *    3. 문자 → 바이트 매핑(치환 암호)의 구현
 *    4. try-with-resources를 활용한 안전한 스트림 관리
 *
 *  실행 방법:
 *    javac FIle.ScrambledOutputStream.java FIle.ScrambledOutputStreamExample.java
 *    java FIle.ScrambledOutputStreamExample
 */
public class ScrambledOutputStreamExample {

    public static void main(String[] args) throws IOException {

        System.out.println("=== FIle.ScrambledOutputStream 학습 예제 ===\n");

        // ── 예제 1: 기본 동작 이해하기 ──────────────────────────
        example1_BasicScramble();

        // ── 예제 2: 시저 암호 (Caesar Cipher) ───────────────────
        example2_CaesarCipher();

        // ── 예제 3: 암호화 → 복호화 왕복 테스트 ─────────────────
        example3_RoundTrip();

        // ── 예제 4: 파일에 암호화하여 저장하기 ──────────────────
        example4_WriteToFile();
    }

    // ─────────────────────────────────────────────────────────────
    //  예제 1: 기본 동작 이해하기
    // ─────────────────────────────────────────────────────────────
    //  map 배열의 역할:
    //    write(b) 호출 시, 실제로는 map[b] 값이 출력됨
    //    즉, 입력 바이트를 다른 바이트로 "치환"하는 것
    // ─────────────────────────────────────────────────────────────
    static void example1_BasicScramble() throws IOException {
        System.out.println("── 예제 1: 기본 동작 이해하기 ──");

        // 항등 매핑: 모든 바이트를 자기 자신으로 매핑 (변환 없음)
        int[] identityMap = createIdentityMap();

        // 'A'(65)를 'Z'(90)로, 'B'(66)를 'Y'(89)로 바꾸는 매핑 추가
        identityMap['A'] = 'Z';
        identityMap['B'] = 'Y';
        identityMap['C'] = 'X';

        // ByteArrayOutputStream: 메모리에 바이트를 모아두는 스트림
        //   → 파일 대신 메모리에 쓰므로 테스트하기 편리함
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        try (ScrambledOutputStream scrambled = new ScrambledOutputStream(buffer, identityMap)) {
            String original = "ABC Hello";
            scrambled.write(original.getBytes());
            // flush: 버퍼에 남은 데이터를 강제로 내보냄
            scrambled.flush();
        }

        String result = buffer.toString();
        System.out.println("  입력: \"ABC Hello\"");
        System.out.println("  출력: \"" + result + "\"");
        System.out.println("  → A→Z, B→Y, C→X로 치환됨. 나머지는 그대로.\n");
    }

    // ─────────────────────────────────────────────────────────────
    //  예제 2: 시저 암호 (Caesar Cipher)
    // ─────────────────────────────────────────────────────────────
    //  각 알파벳을 N칸 뒤로 밀어서 암호화하는 고전 암호 기법
    //  예) shift=3이면 A→D, B→E, ... X→A, Y→B, Z→C
    // ─────────────────────────────────────────────────────────────
    static void example2_CaesarCipher() throws IOException {
        System.out.println("── 예제 2: 시저 암호 (shift=3) ──");

        int shift = 3;
        int[] caesarMap = createCaesarMap(shift);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        try (ScrambledOutputStream scrambled = new ScrambledOutputStream(buffer, caesarMap)) {
            String original = "HELLO WORLD";
            scrambled.write(original.getBytes());
            scrambled.flush();
        }

        System.out.println("  입력: \"HELLO WORLD\"");
        System.out.println("  출력: \"" + buffer.toString() + "\"");
        System.out.println("  → 각 대문자가 3칸씩 뒤로 이동\n");
    }

    // ─────────────────────────────────────────────────────────────
    //  예제 3: 암호화 → 복호화 왕복 테스트
    // ─────────────────────────────────────────────────────────────
    //  암호화 맵의 역(inverse) 맵을 만들면 복호화 가능
    //  encrypt(decrypt(x)) == x 를 확인
    // ─────────────────────────────────────────────────────────────
    static void example3_RoundTrip() throws IOException {
        System.out.println("── 예제 3: 암호화 ↔ 복호화 왕복 테스트 ──");

        int shift = 5;
        int[] encryptMap = createCaesarMap(shift);
        int[] decryptMap = createInverseMap(encryptMap);

        String original = "Java Stream!";

        // 1단계: 암호화
        ByteArrayOutputStream encBuffer = new ByteArrayOutputStream();
        try (ScrambledOutputStream enc = new ScrambledOutputStream(encBuffer, encryptMap)) {
            enc.write(original.getBytes());
            enc.flush();
        }
        String encrypted = encBuffer.toString();

        // 2단계: 복호화 (역매핑 사용)
        ByteArrayOutputStream decBuffer = new ByteArrayOutputStream();
        try (ScrambledOutputStream dec = new ScrambledOutputStream(decBuffer, decryptMap)) {
            dec.write(encrypted.getBytes());
            dec.flush();
        }
        String decrypted = decBuffer.toString();

        System.out.println("  원본:   \"" + original + "\"");
        System.out.println("  암호화: \"" + encrypted + "\"");
        System.out.println("  복호화: \"" + decrypted + "\"");
        System.out.println("  일치 여부: " + original.equals(decrypted) + "\n");
    }

    // ─────────────────────────────────────────────────────────────
    //  예제 4: 파일에 암호화하여 저장하기
    // ─────────────────────────────────────────────────────────────
    //  실제 파일 I/O와 함께 사용하는 실전 예제
    //  FileOutputStream을 ScrambledOutputStream으로 감싸서 사용
    // ─────────────────────────────────────────────────────────────
    static void example4_WriteToFile() throws IOException {
        System.out.println("── 예제 4: 파일에 암호화하여 저장하기 ──");

        int[] encryptMap = createCaesarMap(7);
        int[] decryptMap = createInverseMap(encryptMap);
        String filename = "scrambled_output.txt";
        String message = "This is a secret message!";

        // 암호화하여 파일에 저장
        //   FileOutputStream → ScrambledOutputStream으로 감쌈
        //   = 데코레이터 패턴의 핵심!
        try (FileOutputStream fos = new FileOutputStream(filename);
             ScrambledOutputStream scrambled = new ScrambledOutputStream(fos, encryptMap)) {
            scrambled.write(message.getBytes());
            scrambled.flush();
        }
        System.out.println("  \"" + message + "\" → " + filename + " 에 암호화 저장 완료");

        // 파일에서 읽어서 복호화
        byte[] fileBytes = readAllBytes(filename);
        String encryptedContent = new String(fileBytes);

        ByteArrayOutputStream decBuffer = new ByteArrayOutputStream();
        try (ScrambledOutputStream dec = new ScrambledOutputStream(decBuffer, decryptMap)) {
            dec.write(fileBytes);
            dec.flush();
        }
        String decryptedContent = decBuffer.toString();

        System.out.println("  파일 내용 (암호화): \"" + encryptedContent + "\"");
        System.out.println("  복호화 결과:        \"" + decryptedContent + "\"");

        // 정리: 테스트 파일 삭제
        new File(filename).delete();
        System.out.println("  (테스트 파일 삭제 완료)\n");
    }

    // ═════════════════════════════════════════════════════════════
    //  유틸리티 메서드들
    // ═════════════════════════════════════════════════════════════

    /**
     * 항등 매핑 생성: map[i] = i (모든 바이트가 자기 자신으로 매핑)
     * 이것을 기반으로 원하는 바이트만 바꿔서 커스텀 매핑을 만들 수 있음
     */
    static int[] createIdentityMap() {
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = i;
        }
        return map;
    }

    /**
     * 시저 암호 매핑 생성
     * 대문자(A-Z)와 소문자(a-z)만 shift만큼 밀고,
     * 나머지 문자(숫자, 공백, 특수문자)는 그대로 둠
     *
     * @param shift 밀어낼 칸 수 (1~25)
     */
    static int[] createCaesarMap(int shift) {
        int[] map = createIdentityMap();

        // 대문자 매핑: A(65) ~ Z(90)
        for (int i = 0; i < 26; i++) {
            map['A' + i] = 'A' + (i + shift) % 26;
        }

        // 소문자 매핑: a(97) ~ z(122)
        for (int i = 0; i < 26; i++) {
            map['a' + i] = 'a' + (i + shift) % 26;
        }

        return map;
    }

    /**
     * 역매핑 생성: 암호화 맵의 반대 방향 매핑
     * 만약 encryptMap[65] = 68 이면, inverseMap[68] = 65
     * → 암호화의 반대 = 복호화
     */
    static int[] createInverseMap(int[] map) {
        int[] inverse = new int[256];
        for (int i = 0; i < 256; i++) {
            inverse[map[i]] = i;
        }
        return inverse;
    }

    /**
     * 파일의 모든 바이트를 읽어오는 헬퍼 메서드
     * (Java 7+ 에서는 Files.readAllBytes를 사용할 수도 있음)
     */
    static byte[] readAllBytes(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
            return bos.toByteArray();
        }
    }
}
