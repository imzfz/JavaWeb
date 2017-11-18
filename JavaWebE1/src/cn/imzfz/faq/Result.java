package cn.imzfz.faq;

/**
 * Created by zfz on 2017/10/17.
 * 本类用于计算得分
 */
public class Result {
    private String[] tf = null;
    private String[] single = null;
    private String[] multi = null;
    private int score = 0;

    public void setTf(String[] tf) {
        this.tf = tf;
    }

    public void setSingle(String[] single) {
        this.single = single;
    }

    public void setMulti(String[] multi) {
        this.multi = multi;
    }

    public int judge() {
        try {
            for (String e : tf) {
                if (e.equals("no")) {
                    score += 3;
                }
            }

            for (String e : single) {
                if (e.equals("a")) {
                    score += 3;
                }
            }

            int t = 0;
            for (String e : multi) {
                if (e.equals("e")) {
                    t = -1;
                    break;
                }

                if (e.equals("a")) {
                    t++;
                }
                if (e.equals("b")) {
                    t++;
                }
                if (e.equals("c")) {
                    t++;
                }
                if (e.equals("d")) {
                    t++;
                }
            }

            if (t == -1) {
                return score;
            }

            if (t == 4) {
                score += 4;
            } else {
                score += 2;
            }

            return score;

        } catch (Exception e){
            e.printStackTrace();
            return score;
        }
    }
}
