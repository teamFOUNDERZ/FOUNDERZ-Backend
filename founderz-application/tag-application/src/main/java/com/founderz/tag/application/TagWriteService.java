package com.founderz.tag.application;

import com.founderz.common.vo.tag.TagId;
import com.founderz.internal.data.tag.TagDto;

/**
 * <p>바운디드 컨텍스트: Tag(태그)</p>
 * <p>책임: 태그 쓰기 작업</p>
 * <p>계층: application</p>
 * <br/>
 *
 * <h2>제공 기능</h2>
 * <ul>
 *   <li>태그 생성 (어드민)</li>
 *   <li>태그 삭제 (어드민)</li>
 * </ul>
 */
public interface TagWriteService {
    /**
     * 태그 생성을 위한 메서드 (어드민)
     *
     * @param tagDto 태그 정보
     */
    void create(TagDto tagDto);

    /**
     * 태그 삭제를 위한 메서드 (어드민)
     *
     * @param tagId 태그 아이디
     */
    void delete(TagId tagId);
}
