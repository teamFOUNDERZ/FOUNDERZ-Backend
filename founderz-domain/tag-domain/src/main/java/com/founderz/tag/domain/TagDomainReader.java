package com.founderz.tag.domain;

import com.founderz.common.vo.tag.TagId;
import com.founderz.common.vo.tag.TagName;
import com.founderz.internal.data.tag.TagDto;
import com.founderz.internal.function.tag.TagReader;

import java.util.List;
import java.util.Optional;

/**
 * <p>바운디드 컨텍스트: Tag(태그)</p>
 * <p>책임: 태그 데이터베이스 테이블 읽기 작업</p>
 * <p>계층: domain</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>태그 전체 조회</li>
 *   <li>Id로 태그 조회</li>
 *   <li>name으로 태그 조회</li>
 * </ul>
 */
public interface TagDomainReader extends TagReader {
    /**
     * 태그 전체를 조회할 때 사용하는 메서드
     *
     * @return 전체 태그 정보
     */
    List<TagDto> findAll();

    /**
     * name으로 태그를 조회할 때 사용하는 메서드
     *
     * @param tagName 태그 이름
     * @return 태그 정보 (Optional)
     */
    Optional<TagDto> findByName(TagName tagName);
}
