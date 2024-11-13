package com.founderz.business.application;

import com.founderz.common.vo.tag.SecuredTagId;
import com.founderz.internal.data.business.BusinessDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Business(사업 아이템)</p>
 * <p>책임: 사업 아이템 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 작성</li>
 * </ul>
 */
public interface BusinessWriteService {

    /**
     * 유저에게 정보를 입력 받아 사업 아이템을 작성하는 메서드
     *
     * @param dto 사업 아이템 작성을 위한 유저 정보
     */
    void write(BusinessDto dto, List<SecuredTagId> tagIds);
}
