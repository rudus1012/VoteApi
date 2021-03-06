package com.taek.daangn.platform.domain.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Vote {

    @Id
    private String voteId;

    private String userId;

    private Long postId;

    private LocalDateTime voteDeadline;

    @Size(max = 100)
    private String voteTitle;

    @Size(max = 10000)
    private String voteContent;

    @OneToMany
    private List<VoteItem> voteItems;

    @Builder
    public Vote(String voteId, Long postId, LocalDateTime voteDeadline, String voteTitle, String voteContent) {
        this.voteId = voteId;
        this.postId = postId;
        this.voteDeadline = voteDeadline;
        this.voteTitle = voteTitle;
        this.voteContent = voteContent;
    }

    public void setVoteIdAndUserId(String voteId, String userId) {
        this.voteId = voteId;
        this.userId = userId;
    }

    @PrePersist
    public void isCheckedDeadline() {
        if (this.voteDeadline == null) {
            this.voteDeadline = LocalDateTime.now().plusDays(1);
        }
    }
}
