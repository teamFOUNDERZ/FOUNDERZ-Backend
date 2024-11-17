package com.founderz.common.vo.notice;

public enum NoticeType {
    INVESTMENT_REQUEST("투자 요청"),
    INVESTMENT_AGREEMENT_REVIEW("자금 투자 계약서 확인"),
    INVESTMENT_AGREEMENT_SIGNED("자금 투자 계약 체결"),
    INVESTMENT_AGREEMENT_MODIFY_REQUEST("자금 투자 계약 수정 요청");

    private final String content;

    public String getContent() {
        return content;
    }

    NoticeType(final String content) {
        this.content = content;
    }
}
