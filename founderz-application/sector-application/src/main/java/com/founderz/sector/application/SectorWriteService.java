package com.founderz.sector.application;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.tag.TagId;

/**
 * <p>바운디드 컨텍스트: Sector(사업 아이템 분야)</p>
 * <p>책임: 사업 아이템 분야 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 분야 등록</li>
 *   <li>사업 아이템 분야 삭제</li>
 * </ul>
 */
public interface SectorWriteService {
    /**
     * 사업 아이템 분야 등록 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @param tagId 태그 아이디
     */
    void addSector(BusinessId businessId, TagId tagId);

    /**
     * 사업 아이템 분야 삭제 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @param tagId 태그 아이디
     */
    void removeSector(BusinessId businessId, TagId tagId);
}
