package com.founderz.internal.function.tag;

import com.founderz.internal.data.tag.TagDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Tag(태그)</p>
 * <p>연관관계를 event로 분리하기 위해 사용되는 인터페이스입니다.</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *     <li>id 목록 전체 조회</li>
 * </ul>
 */
public interface TagReader {
    List<TagDto> findAllByIds(List<Long> ids);
}
