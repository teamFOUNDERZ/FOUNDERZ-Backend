package com.founderz.business.domain;

import com.founderz.internal.data.business.BusinessDto;

/**
 * <p>바운디드 컨텍스트: Business(사업 아이템)</p>
 * <p>책임: 사업 아이템 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 저장</li>
 * </ul>
 */
public interface BusinessDomainWriter {

    /**
     * 사업 아이템 생성 또는 업데이트를 위한 메서드
     *
     * @param dto 사업 아이템 도메인 정보
     */
    BusinessDto save(BusinessDto dto);
}