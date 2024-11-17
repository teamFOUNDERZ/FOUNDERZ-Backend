package com.founderz.internal.function.business;

import com.founderz.common.vo.business.BusinessId;
import com.founderz.common.vo.user.AccountId;
import com.founderz.internal.data.business.BusinessDto;

import java.util.List;
import java.util.Optional;

/**
 * <p>바운디드 컨텍스트: Business(태그)</p>
 * <p>연관관계를 분리하고 바운디드 컨텍스트의 경계를 명확하게 하기 위해 사용되는 인터페이스입니다.</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *     <li>businessId로 사업 아이템 조회</li>
 * </ul>
 */
public interface BusinessReader {
    /**
     * businessId로 사업 아이템 조회 메서드
     *
     * @param businessId 사업 아이템 아이디
     * @return 사업 아이템 정보
     */
    Optional<BusinessDto> findById(BusinessId businessId);

    /**
     * writerAccountId로 사업 아이템 전체 조회 메서드
     *
     * @param writerAccountId 작성자의 accountId
     * @return 사업 아이템 목록
     */
    List<BusinessDto> findAllByWriterAccountId(AccountId writerAccountId);
}
