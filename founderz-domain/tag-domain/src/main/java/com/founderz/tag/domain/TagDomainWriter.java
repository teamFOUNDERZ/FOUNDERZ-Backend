package com.founderz.tag.domain;

import com.founderz.tag.domain.dto.TagDomainDto;

/**
 * <p>바운디드 컨텍스트: Tag(태그)</p>
 * <p>책임: 태그 데이터베이스 테이블 쓰기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>태그 저장</li>
 * </ul>
 */
public interface TagDomainWriter {
    /**
     * 태그 생성 또는 업데이트를 위한 메서드
     *
     * @param dto 태그 도메인 정보
     */
    TagDomainDto save(TagDomainDto dto);
}
