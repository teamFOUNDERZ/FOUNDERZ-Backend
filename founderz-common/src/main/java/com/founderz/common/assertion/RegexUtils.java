package com.founderz.common.assertion;

/**
 * 자주 사용되는 정규표현식을 위한 유틸리티 열거형 클래스입니다. <br/>
 * 문자열 검증에 사용되는 정규표현식을 제공합니다.
 */
public enum RegexUtils {
    /**
     * 전화번호 형식 검증을 위한 정규표현식
     * <p>형식: 010-0000-0000</p>
     * <ul>
     *   <li>시작은 반드시 010, 011로 시작</li>
     *   <li>중간 자리는 4자리의 숫자</li>
     *   <li>마지막 자리는 4자리의 숫자</li>
     * </ul>
     */
    TEL("^01(?:0|1)-(\\d{4})-(\\d{4})$"),

    /**
     * 비밀번호 유효성 검증을 위한 정규표현식
     * <p>요구사항:</p>
     * <ul>
     *   <li>8~20자 길이</li>
     *   <li>영문자 1개 이상 포함 필수</li>
     *   <li>숫자 1개 이상 포함 필수</li>
     *   <li>특수문자 1개 이상 포함 필수 (!@#$%^&*)</li>
     * </ul>
     */
    PASSWORD("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]"),

    /**
     * 한글만 허용하는 정규표현식
     * <p>유니코드 범위: 가-힣</p>
     */
    ALLOWED_ONLY_KOR("^[가-힣]"),

    /**
     * 영문자만 허용하는 정규표현식
     * <p>허용 범위: 대소문자 알파벳 (a-z, A-Z)</p>
     */
    ALLOWED_ONLY_ENG("^[a-zA-Z]"),

    /**
     * 한글과 영문자만 허용하는 정규표현식
     * <p>허용 범위:</p>
     * <ul>
     *   <li>한글 (가-힣)</li>
     *   <li>영문 대소문자 (a-z, A-Z)</li>
     * </ul>
     */
    ALLOWED_ONLY_KOR_N_ENG("^[a-zA-Z가-힣]"),

    /**
     * 영문자와 숫자만 허용하는 정규표현식
     * <p>허용 범위:</p>
     * <ul>
     *   <li>영문 대소문자 (a-z, A-Z)</li>
     *   <li>숫자 (0-9)</li>
     * </ul>
     */
    ALLOWED_ONLY_ENG_N_NUM("^[a-zA-Z0-9]");

    private final String regex;

    /**
     * 정규표현식 패턴을 반환합니다.
     * <p>
     * 전화번호(TEL_REGEX)를 제외한 모든 패턴에는 다음과 같은 규칙이 적용됩니다:
     * <ul>
     *   <li>하나 이상의 문자 매칭을 위한 + 기호(수량자) 추가</li>
     *   <li>문자열 끝을 나타내는 $ 기호 추가</li>
     * </ul>
     * </p>
     *
     * @return 완성된 정규표현식 패턴
     */
    public String getRegex() {
        return this.equals(TEL)
                ? regex
                : regex + "+$";
    }

    /**
     * 지정된 길이 제한이 포함된 정규표현식을 반환합니다. <br/>
     * 전화번호 형식을 제외한 모든 정규표현식에 대해 길이 제한을 적용할 수 있습니다.
     *
     * @param minLength 최소 길이 (포함)
     * @param maxLength 최대 길이 (포함)
     * @return 길이 제한이 적용된 정규표현식 패턴
     */
    public String getRegex(final int minLength, final int maxLength) {
        if (this.equals(TEL)) {
            return regex;
        }
        return regex + "{" + minLength + "," + maxLength + "}" + "$";
    }

    private RegexUtils(final String regex) {
        this.regex = regex;
    }
}
