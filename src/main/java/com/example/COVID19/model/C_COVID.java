package com.example.COVID19.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class C_COVID {
    private String accDefRate;
    private String accExamCnt;
    private String createDt;
    private String deathCnt;
    private String decideCnt;
    private String seq;
    private String stateDt;
    private String stateTime;
    private String updateDt;


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
