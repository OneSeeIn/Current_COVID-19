package com.example.COVID19.repository;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;

@Entity(name = "c_covid")
@Data
@ToString
@NoArgsConstructor
public class C_Covid {
    @Id
    @Column(name = "seq")
    private Integer seq;  //게시글번호(감염현황 고유값)
    @Column(name = "accDefRate")
    private String accDefRate;   //누적 확진률
    @Column(name = "accExamCnt")
    private int accExamCnt;  //누적 의심 검사 수
    @Column(name = "createDt")
    private Timestamp createDt;  //등록일시분초
    @Column(name = "deathCnt")
    private Integer deathCnt;  //사망자 수
    @Column(name = "decideCnt")
    private Integer decideCnt;  //확진자 수
    @Column(name = "stateDt")
    private String stateDt;  //기준일
    @Column(name = "stateTime")
    private Time stateTime;  //기준시간
    @Column(name = "updateDt")
    private Timestamp updateDt; //수정일시분초


    public void setData(String name, String value) {
	    if(value.equals("null")) return;
        switch (name){
            case ("accDefRate"): {this.accDefRate = value; break;}
            case ("accExamCnt"): {this.accExamCnt = Integer.parseInt(value); break;}
            case ("createDt"): {this.createDt = Timestamp.valueOf(value); break;}
            case ("deathCnt"): {this.deathCnt = Integer.parseInt(value); break;}
            case ("decideCnt"): {this.decideCnt = Integer.parseInt(value); break;}
            case ("seq"): {this.seq = Integer.parseInt(value); break;}
            case ("stateDt"): {this.stateDt = value; break;}
            case ("stateTime"):{this.stateTime = Time.valueOf(value+":00"); break;}
            case ("updateDt"): {this.updateDt = Timestamp.valueOf(value); break;}
        }
    }

    @Builder
    public C_Covid(int seq, String accDefRate, int accExamCnt, Timestamp createDt, int deathCnt, int decideCnt, String stateDt, Time stateTime, Timestamp updateDt) {
        this.seq = seq;
        this.accDefRate = accDefRate;
        this.accExamCnt = accExamCnt;
        this.createDt = createDt;
        this.deathCnt = deathCnt;
        this.decideCnt = decideCnt;
        this.stateDt = stateDt;
        this.stateTime = stateTime;
        this.updateDt = updateDt;
    }

}

