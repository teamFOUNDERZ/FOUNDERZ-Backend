package com.founderz.tag.application;

import com.founderz.internal.data.tag.TagDto;

import java.util.List;

/**
 * <p>바운디드 컨텍스트: Tag(태그)</p>
 * <p>책임: 태그 읽기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>태그 전체 조회</li>
 * </ul>
 */
public interface TagReadService {
    /**
     * 태그 전체 조회를 위한 메서드
     *
     * @return 태그 전체 목록
     */
    List<TagDto> getAll();
}
