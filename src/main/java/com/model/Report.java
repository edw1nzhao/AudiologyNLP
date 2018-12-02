package main.java.com.model;

import java.util.*;

public class Report {
    public List<String> info;
    public List<List<String>> history;
    public List<List<String>> test;
    public List<String> recommendation;

    private String[] headings = new String[]{"General patient info", "Case history",
            "Test", "Recommendation/plan"};
    private List<String> infoHeadings = Arrays.asList("Name", "DOB", "Date of Visit", "Location", "Organization", "Sex");
    private List<String> historyHeadings = Arrays.asList("Hearing screen", "Known hearing loss",
            "Early intervention", "Risk factors", "Hearing aid");
    private List<String> testHeadings = Arrays.asList("Cochlear function", "Evoked potential",
            "Middle ear function", "Behavourial audiometry");

    public Report() {
        info = new ArrayList<>();
        history = new ArrayList<>();
        test = new ArrayList<>();
        recommendation = new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("-General patient info:\n");
        Iterator infoHeadingIt = infoHeadings.iterator();
        Iterator infoIt = info.iterator();
        while (infoIt.hasNext()) {
            sb.append(infoHeadingIt.next() + ": ");
            sb.append(infoIt.next() + "\n");
        }

        sb.append("-Case history:\n");
        Iterator histHeadingIt = historyHeadings.iterator();
        Iterator histIt = history.iterator();
        while (histIt.hasNext()) {
            sb.append(histHeadingIt.next() + ": ");
            List<String> ls = (List<String>)histIt.next();
            for (String s : ls) {
                sb.append(s + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        sb.append("-Test:\n");
        Iterator testHeadingIt = testHeadings.iterator();
        Iterator testIt = test.iterator();
        while (testIt.hasNext()) {
            sb.append(testHeadingIt.next() + ": ");
            List<String> ls = (List<String>)testIt.next();
            for (String s : ls) {
                sb.append(s + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        sb.append("-Recommendation:\n");
        for (String r : recommendation) {
            sb.append(r + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        return sb.toString();
    }

}
