package hw.homework_data;


import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Presidents implements Comparable<Presidents> {
    private String name;
    private Date startOfTern;
    private Date endOfTern;
    private String sDate1 ;
    private String sDate2 ;
    private String sd1;
    private String sd2;

//    public String getDateFromConsole(){
//        return sdf.format(startOfTern);
//    }

    public Presidents(String name, Date startOfTern, Date endOfTern) {
        this.name = name;
        this.startOfTern = startOfTern;
        this.endOfTern = endOfTern;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM.yyyy");
        this.sDate1 = sdf.format(startOfTern);
        this.sDate2 = sdf.format(endOfTern);
        SimpleDateFormat sdp = new SimpleDateFormat("dd.MM.yyyy");
        this.sd1 = sdp.format(startOfTern);
        this.sd2 = sdp.format(endOfTern);
    }

    @Override
    public String toString() {
        return "Президент: {" + name +
                ", начало правления " + sDate1 +
                ", конец правления " + sDate2 +
                '}' + "\n";
    }


    public Date getStartOfTern() {
        return startOfTern;
    }

    public Date getEndOfTern() {
        return endOfTern;
    }

    public String getName() {
        return name;
    }

    public String getsDate1() {
        return sDate1;
    }

    public String getsDate2() {
        return sDate2;
    }

    public String getSd1() {
        return sd1;
    }

    public String getSd2() {
        return sd2;
    }

    @Override
    public int compareTo(Presidents o) {
        return startOfTern.compareTo(o.startOfTern);
    }
}

class SortByReversDate implements Comparator<Presidents>{

    @Override
    public int compare(Presidents o1, Presidents o2) {
        return o2.getStartOfTern().compareTo(o1.getStartOfTern());
    }
}

class SortByNamePresidents implements Comparator<Presidents>{

    @Override
    public int compare(Presidents o1, Presidents o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

