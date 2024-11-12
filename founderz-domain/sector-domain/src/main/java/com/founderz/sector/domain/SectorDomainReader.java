package com.founderz.sector.domain;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.internal.data.sector.SectorDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Sector(사업 아이템 분야)</p>
 * <p>책임: 사업 아이템 분야 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>단일 사업 아이템의 분야 목록 조회</li>
 * </ul>
 */
public interface SectorDomainReader {
    /**
     * 단일 사업 아이템의 분야 목록 조회 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @return 분야 목록
     */
    List<SectorDto> getAllByBusinessId(BusinessId businessId);
}
