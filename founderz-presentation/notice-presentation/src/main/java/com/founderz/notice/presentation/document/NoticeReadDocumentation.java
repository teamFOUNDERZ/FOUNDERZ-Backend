package com.founderz.notice.presentation.document;

import com.founderz.common.vo.notice.SecuredNoticeId;
import com.founderz.external.response.ListResponse;
import com.founderz.notice.presentation.response.NoticeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Tag(name = "Notice", description = "Notice 관련 API")
public interface NoticeReadDocumentation {
    @Operation(
            summary = "공지사항 상세 조회",
            description = "공지사항 ID를 사용하여 공지사항 상세 정보를 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = NoticeResponse.class))),
                    @ApiResponse(responseCode = "404", description = "공지사항을 찾을 수 없음")
            }
    )
    NoticeResponse getById(SecuredNoticeId noticeId);

    @Operation(
            summary = "사용자 공지사항 목록 조회",
            description = "현재 사용자의 모든 공지사항을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = ListResponse.class))),
                    @ApiResponse(responseCode = "401", description = "인증 실패")
            }
    )
    ListResponse<NoticeResponse> getAllByCurrentUser();

    @Operation(
            summary = "공지사항 SSE 구독",
            description = "공지사항 실시간 알림을 구독합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = MediaType.TEXT_EVENT_STREAM_VALUE))
            }
    )
    SseEmitter subscribe();
}
