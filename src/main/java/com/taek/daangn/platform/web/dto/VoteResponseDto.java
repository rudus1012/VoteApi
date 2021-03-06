package com.taek.daangn.platform.web.dto;

import com.taek.daangn.platform.domain.vote.Vote;
import com.taek.daangn.platform.domain.vote.VoteItem;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class VoteResponseDto {

    private String userId;

    private String voteTitle;

    private String voteContent;

    private List<VoteItem> voteItems;

    private LocalDateTime voteDeadline;

    private boolean voteFlag;

    public VoteResponseDto(Vote vote, List<VoteItem> voteItems, boolean voteFlag){
        this.userId = vote.getUserId();
        this.voteTitle = vote.getVoteTitle();
        this.voteContent = vote.getVoteContent();
        this.voteItems = voteItems;
        this.voteDeadline = vote.getVoteDeadline();
        this.voteFlag = voteFlag;
    }
}
