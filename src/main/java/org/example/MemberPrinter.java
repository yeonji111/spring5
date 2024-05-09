package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component("printer")
public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public MemberPrinter getPrinter() {
        return printer;
    }

    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

    @Autowired
    public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatter) {
        if(dateTimeFormatter.isPresent()){
            this.dateTimeFormatter = dateTimeFormatter.get();
        } else {
            this.dateTimeFormatter = null;
        }
        dateTimeFormatter.ifPresent(dtf -> this.dateTimeFormatter = dtf);
    }



    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
        }
    }


}
