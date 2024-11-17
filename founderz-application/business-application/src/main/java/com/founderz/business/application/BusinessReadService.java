package com.founderz.business.application;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.business.BusinessDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Business(사업 아이템)</p>
 * <p>책임: 사업 아이템 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>사업 아이템 전체 조회</li>
 *   <li>사업 아이템 상세 조회</li>
 *   <li>작성자를 통한 사업 아이템 전체 조회</li>
 * </ul>
 */
public interface BusinessReadService {
    /**
     * 사업 아이템 전체 조회를 위한 메서드
     *
     * @return 사업 아이템 전체 목록
     */
    List<BusinessDto> getAll();

    /**
     * 사업 아이템 상세 조회를 위한 메서드
     *
     * @return 사업 아이템 상세 정보
     */
    BusinessDto getById(BusinessId businessId);

    /**
     * 작성자를 통한 사업 아이템 전체 조회를 위한 메서드
     *
     * @return 사업 아이템 전체 목록
     */
    List<BusinessDto> getAllByWriterAccountId(AccountId writerAccountId);
}

