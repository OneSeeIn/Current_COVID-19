package com.example.COVID19.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class C_COVID {
    //누적 확진률
    private String accDefRate;
    private String accExamCnt;  //누적 의심 검사 수
    private String createDt;  //등록일시분초
    private String deathCnt;  //사망자 수
    private String decideCnt;  //확진자 수
    private String seq;  //게시글번호(감염현황 고유값)
    private String stateDt;  //기준일
    private String stateTime;  //기준시간
    private String updateDt; //수정일시분초


    public void setData(String name, String value) {
        switch (name){
            case ("accDefRate"): this.accDefRate = value;
            case ("accExamCnt"): this.accExamCnt = value;
            case ("createDt"): this.createDt = value;
            case ("deathCnt"): this.deathCnt = value;
            case ("decideCnt"): this.decideCnt = value;
            case ("seq"): this.seq = value;
            case ("stateDt"): this.stateDt = value;
            case ("stateTime"): this.stateTime = value;
            case ("updateDt"): this.updateDt = value;
        }
    }


    @Builder
    public C_COVID(String accDefRate, String accExamCnt, String createDt, String deathCnt, String decideCnt, String seq, String stateDt, String stateTime, String updateDt) {
        this.accDefRate = accDefRate;
        this.accExamCnt = accExamCnt;
        this.createDt = createDt;
        this.deathCnt = deathCnt;
        this.decideCnt = decideCnt;
        this.seq = seq;
        this.stateDt = stateDt;
        this.stateTime = stateTime;
        this.updateDt = updateDt;
    }


}
