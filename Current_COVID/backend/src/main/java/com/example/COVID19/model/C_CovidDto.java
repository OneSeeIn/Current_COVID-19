package com.example.COVID19.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
public class C_CovidDto {
    //누적 확진률
    private Integer seq;  //게시글번호(감염현황 고유값)
    private String accDefRate;   //누적 확진률
    private Integer accExamCnt;  //누적 의심 검사 수
    private Timestamp createDt;  //등록일시분초
    private Integer deathCnt;  //사망자 수
    private Integer decideCnt;  //확진자 수
    private String stateDt;  //기준일
    private Time stateTime;  //기준시간
    private Timestamp updateDt; //수정일시분초


    public void setData(String name, String value) {
        switch (name){
            case ("accDefRate"): this.accDefRate = value;
            case ("accExamCnt"): this.accExamCnt = Integer.parseInt(value);
            case ("createDt"): this.createDt = Timestamp.valueOf(value);
            case ("deathCnt"): this.deathCnt = Integer.parseInt(value);
            case ("decideCnt"): this.decideCnt = Integer.parseInt(value);
            case ("seq"): this.seq = Integer.parseInt(value);
            case ("stateDt"): this.stateDt = value;
            case ("stateTime"): this.stateTime = Time.valueOf(value);
            case ("updateDt"): this.updateDt = Timestamp.valueOf(value);
        }
    }

    @Builder
    public C_CovidDto(int seq, String accDefRate, int accExamCnt, Timestamp createDt, int deathCnt, int decideCnt, String stateDt, Time stateTime, Timestamp updateDt) {
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
