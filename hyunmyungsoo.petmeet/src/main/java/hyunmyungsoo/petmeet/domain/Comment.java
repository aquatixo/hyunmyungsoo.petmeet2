package hyunmyungsoo.petmeet.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("comment.info")
public class Comment {
	private int commentNum;
	private String commentContent;
	private LocalDate regDate;
	private String userId;
	private int boardNum;
/*
 * 
create table hyunmyungsoo.comments (
comment_num number(4) constraint comments_commentnum_pk primary key,
comment_content varchar2(100) constraint comments_commentcontent_nn not null,
comment_reg_date date constraint comments_commentregdate_nn not null,
user_id varchar2(40),
board_num number(4),
constraint comments_userid_fk foreign key(user_id)
references hyunmyungsoo.users(user_id) on delete cascade,
constraint comments_boardnum_fk foreign key(board_num)
references hyunmyungsoo.boards(board_num) on delete cascade);
 * 
 * */
}
