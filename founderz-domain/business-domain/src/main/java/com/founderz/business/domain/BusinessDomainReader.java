package com.founderz.business.domain;

import com.founderz.internal.data.business.BusinessDto;
import com.founderz.internal.function.business.BusinessReader;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Business(사업 아이템)</p>
 * <p>책임: 사업 아이템 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 전체 조회</li>
 * </ul>
 */
public interface BusinessDomainReader extends BusinessReader {
    /**
     * 사업 아이템 전체를 조회할 때 사용하는 메서드
     *
     * @return 전체 사업 아이템 정보
     */
    List<BusinessDto> findAll();
}