package com.founderz.sector.domain;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.user.UserId;
import com.founderz.internal.data.sector.SectorDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Sector(사업 아이템 분야)</p>
 * <p>책임: 사업 아이템 분야 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 분야 단일 저장</li>
 *   <li>사업 아이템 분야 목록 저장</li>
 *   <li>사업 아이템 분야 삭제</li>
 * </ul>
 */
public interface SectorDomainWriter {
    /**
     * 사업 아이템 분야 단일 저장 메서드
     *
     * @param dto 분야 정보
     */
    void save(SectorDto dto);

    /**
     * 사업 아이템 분야 목록 저장
     *
     * @param dtoList 사업 아이템 분야 목록
     */
    void saveAll(List<SectorDto> dtoList);

    /**
     * 사업 아이템 분야 삭제 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @param tagId 태그 아이디
     */
    void delete(BusinessId businessId, TagId tagId);
}
