package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    @Qualifier("summaryPrinter")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        // method reference: 람다식보다 더 축약된 방식
        members.forEach(printer::print);
    }
}
